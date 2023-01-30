use crate::{constants, message::Message, position::Position, sensor::Sensor};
use std::{collections::HashSet, sync::mpsc::channel, thread, time::Duration};

pub fn get_size_matrix<T>(matrix: &Vec<Vec<T>>) -> (usize, usize) {
    let range_x = matrix.len();
    let range_y = matrix.get(0).expect("Matrix can not be empty").len();
    (range_x, range_y)
}

pub fn connect_sensors(mut sensors: Vec<Sensor>, range_sensor_warning: usize) -> Vec<Sensor> {
    let mut control_duplication_index_correlation = HashSet::new();
    let mut correlationIndex = vec![];
    sensors.iter().enumerate().for_each(|(i, sensor_a)| {
        sensors.iter().enumerate().for_each(|(j, sensor_b)| {
            let delta_positions = sensor_a
                .position_ref()
                .delta_position(&sensor_b.position_ref());
            if delta_position_is_between_zero_and_right_limit(delta_positions, range_sensor_warning)
                && (not_saved_pair_in_set(&mut control_duplication_index_correlation, &i, &j))
            {
                println!("delta: {delta_positions} - could join: {sensor_a} - {sensor_b}");
                correlationIndex.push((i, j));
            }
        });
    });

    correlationIndex.iter().for_each(|(i, j)| {
        let (sender_a, receiver_a) = channel::<Message>();
        let (sender_b, receiver_b) = channel::<Message>();

        if let Some(sensor) = sensors.get_mut(*i) {
            sensor
                .add_sensor_receiver(receiver_a)
                .add_sensor_sender(sender_b);
        }

        if let Some(sensor) = sensors.get_mut(*j) {
            sensor
                .add_sensor_receiver(receiver_b)
                .add_sensor_sender(sender_a);
        }
    });
    sensors
}

fn not_saved_pair_in_set(hashset: &mut HashSet<(usize, usize)>, i: &usize, j: &usize) -> bool {
    let not_saved = !hashset.contains(&(*i, *j)) || !hashset.contains(&(*i, *j));
    if not_saved {
        hashset.insert((*i, *j));
        hashset.insert((*j, *i));
    }
    not_saved
}

fn delta_position_is_between_zero_and_right_limit(
    delta_positions: f64,
    right_limit: usize,
) -> bool {
    0.0 < delta_positions && delta_positions <= right_limit as f64
}

pub fn print_sensors(sensors: &[Sensor]) {
    for sensor in sensors {
        print!("{sensor}");
    }
    print!("\n");
}

pub fn create_sensors(lines: &Vec<Vec<Position>>, range_sensor_warning: &usize) -> Vec<Sensor> {
    let (range_x, range_y) = get_size_matrix(lines);
    let total_nodes = calc_total_nodes(&range_x, &range_y);
    let mut sensors = Vec::with_capacity(total_nodes);

    for counter_x in (1..range_x).step_by(*range_sensor_warning) {
        for counter_y in (1..range_y).step_by(*range_sensor_warning) {
            let position = lines
                .get(counter_x)
                .and_then(|collumn| collumn.get(counter_y))
                .expect(
                    r#"Do not exist position from called reference: ({counter_x},{counter_y})"#,
                );
            let sensor = Sensor::from_position(position);
            sensors.push(sensor);
        }
    }
    sensors
}

fn calc_nodes_per_range_emit_message(range: &usize) -> usize {
    let nodes = (range + 1) / constants::DISTANCE_WARNING_MESSAGE as usize;
    if nodes == 0 {
        1
    } else {
        nodes
    }
}

fn calc_total_nodes(range_x: &usize, range_y: &usize) -> usize {
    calc_nodes_per_range_emit_message(range_x) * calc_nodes_per_range_emit_message(range_y)
}

pub fn print_vector(lines: &Vec<Vec<Position>>) {
    for line in lines {
        for value in line {
            print!("{value} ");
        }
        print!("\n");
    }
}

pub fn create_map(range_x: usize, range_y: usize) -> Vec<Vec<Position>> {
    let mut lines: Vec<Vec<Position>> = Vec::with_capacity(range_x);
    for i in 0..range_x {
        let mut columns: Vec<Position> = Vec::with_capacity(range_y);
        for j in 0..range_y {
            let position = Position::new(i as u8, j as u8);
            columns.push(position);
        }
        lines.push(columns);
    }
    lines
}

pub fn initialize_sensors(sensors: Vec<Sensor>) -> Vec<thread::JoinHandle<()>> {
    // sensors.iter().for_each(move |sensor| {
    let mut threads = vec![];
    if let Some(sensor) = sensors.get(0) {
        sensor.send_message(&Position::new(0, 0));
    }

    for sensor in sensors {

        let joiner = thread::spawn(move || loop {
            sensor
                .read_messages(&Duration::new(1, 0))
                .iter()
                .filter(|result| result.is_ok())
                .map(|result| result.as_ref().ok())
                .for_each(|message| {
                    let str = message
                        .map(|data| data.to_message())
                        .unwrap_or_else(|| String::from("not exist message"));
                    println!("message: {}", str)
                });
        });
        threads.push(joiner);
    }
    threads
}
