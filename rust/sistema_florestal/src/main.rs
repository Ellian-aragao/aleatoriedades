use position::Position;
use sensor::Sensor;

mod constants;
mod message;
mod position;
mod sensor;

fn main() {
    let (range_x, range_y) = constants::TAM_MAP_FLOREST;
    let nodes_per_range_y = calc_nodes_per_range_emit_message(range_y);
    let nodes_per_range_x = calc_nodes_per_range_emit_message(range_x);
    let total_nodes = nodes_per_range_x * nodes_per_range_y;
    println!("range y {range_y}, nodes in range y: {nodes_per_range_y}");
    println!("range x {range_x}, nodes in range x: {nodes_per_range_x}");
    println!("total nodes: {total_nodes}");
    let lines = create_map(range_x, range_y);
    map_near_sensors(&lines, &range_x, &range_y);
    // // TODO: criar processo de verificação de nodos próximos
    print_vector(&lines);
}

fn map_near_sensors(lines: &Vec<Vec<Position>>, range_x: &usize, range_y: &usize) {
    let mut counter_x: usize = 0;
    let mut counter_y: usize = 0;
    while counter_x < *range_x {
        while counter_y < *range_y {
            if counter_y % 3 == 1 {
                let position = lines
                    .get(counter_x)
                    .and_then(|collumn| collumn.get(counter_y))
                    .unwrap();
                let sensor = Sensor::from_position(&position);
                println!("sensor: {sensor}")
            }
            counter_y += 1;
        }
        counter_x += 1;
    }
}

fn calc_nodes_per_range_emit_message(range: usize) -> usize {
    let nodes = (range + 1) / constants::DISTANCE_WARNING_MESSAGE as usize;
    if nodes == 0 {
        1
    } else {
        nodes
    }
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
