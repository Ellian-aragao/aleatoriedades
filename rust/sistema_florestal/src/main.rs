use position::Position;
use sensor::Sensor;

mod constants;
mod message;
mod position;
mod sensor;

fn main() {
    let (range_x, range_y) = constants::TAM_MAP_FLOREST;
    let range_sensor_warning = constants::DISTANCE_WARNING_MESSAGE;
    let lines = create_map(range_x, range_y);
    let sensors = create_sensors(&lines, &range_sensor_warning);
    // // TODO: criar processo de verificação de nodos próximos
    print_sensors(&sensors);
    print_vector(&lines);
}

fn print_sensors(sensors: &[Sensor]) {
    for sensor in sensors {
        print!("{sensor}");
    }
    print!("\n");
}

fn create_sensors(lines: &Vec<Vec<Position>>, range_sensor_warning: &usize) -> Vec<Sensor> {
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

fn get_size_matrix<T>(matrix: &Vec<Vec<T>>) -> (usize, usize) {
    let range_x = matrix.len();
    let range_y = matrix.get(0).expect("Matrix can not be empty").len();
    (range_x, range_y)
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

fn print_vector(lines: &Vec<Vec<Position>>) {
    for line in lines {
        for value in line {
            print!("{value} ");
        }
        print!("\n");
    }
}

fn create_map(range_x: usize, range_y: usize) -> Vec<Vec<Position>> {
    let mut lines: Vec<Vec<Position>> = Vec::with_capacity(range_x);
    for i in 0..range_x {
        let mut columns: Vec<Position> = Vec::with_capacity(range_y);
        for j in 0..range_y {
            let position = Position::new(i as i8, j as i8);
            columns.push(position);
        }
        lines.push(columns);
    }
    lines
}
