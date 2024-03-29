use crate::{constants, message::Message, position::Position, sensor::Sensor};
use std::{collections::HashSet, sync::mpsc::channel, thread};

pub fn get_size_matrix<T>(matrix: &Vec<Vec<T>>) -> (usize, usize) {
    let range_x = matrix.len();
    let range_y = matrix.get(0).expect("Matrix can not be empty").len();
    (range_x, range_y)
}

pub fn connect_sensors(mut sensors: Vec<Sensor>, range_sensor_warning: usize) -> Vec<Sensor> {
    let mut control_duplication_index_correlation = HashSet::new();
    let mut correlation_index = vec![];
    sensors.iter().enumerate().for_each(|(i, sensor_a)| {
        sensors.iter().enumerate().for_each(|(j, sensor_b)| {
            let delta_positions = sensor_a
                .position_ref()
                .delta_position(&sensor_b.position_ref());
            let is_value_between_zero_and_right_limit =
                value_is_between_zero_and_right_limit(delta_positions, range_sensor_warning as f64);
            let is_created_connection_yet =
                not_saved_pair_in_set(&mut control_duplication_index_correlation, &i, &j);
            if is_value_between_zero_and_right_limit && is_created_connection_yet {
                correlation_index.push((i, j));
            }
        });
    });

    correlation_index.iter().for_each(|(i, j)| {
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

fn value_is_between_zero_and_right_limit(value: f64, right_limit: f64) -> bool {
    0.0 < value && value <= right_limit
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
                .and_then(|column| column.get(counter_y))
                .expect(
                    r#"Do not exist position from called reference: ({counter_x},{counter_y})"#,
                );

            let is_border_sensor =
                verify_if_border_node(position, &range_x, &range_y, range_sensor_warning);
            let sensor = Sensor::from_position(position).border_sensor(is_border_sensor);

            sensors.push(sensor);
        }
    }
    sensors
}

fn verify_if_border_node(
    position: &Position,
    range_x: &usize,
    range_y: &usize,
    range_sensor_warning: &usize,
) -> bool {
    vec![
        position.delta_x(&0),
        position.delta_x(&(*range_x as u8)),
        position.delta_y(&0),
        position.delta_y(&(*range_y as u8)),
    ]
    .iter()
    .any(|delta| delta <= &(*range_sensor_warning as u8))
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
            println!("{value} ");
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
    let mut threads = Vec::with_capacity(sensors.len());
    if let Some(sensor) = sensors.get(0) {
        sensor.send_alert_from_position(&Position::new(0, 0));
    }

    for sensor in sensors {
        let joiner = sensor.run();
        threads.push(joiner);
    }
    threads
}
