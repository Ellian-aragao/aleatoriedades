use position::Position;
use sensor::Sensor;

mod constants;
mod position;
mod sensor;

fn main() {
    let (range_x, range_y) = constants::TAM_MAP_FLOREST;

    let lines = create_map(range_x, range_y).expect("Error allocating map");

    // TODO: criar processo de verificação de nodos próximos

    print_vector(&lines);
}

fn print_vector(lines: &Vec<Vec<Sensor>>) {
    for line in lines {
        for value in line {
            print!("{value} ");
        }
        print!("\n");
    }
}

fn create_map(range_x: usize, range_y: usize) -> Result<Vec<Vec<Sensor>>, String> {
    let mut lines: Vec<Vec<Sensor>> = Vec::new();
    for i in 0..range_x {
        let mut columns: Vec<Sensor> = Vec::new();
        for j in 0..range_y {
            let position = Position::new(i as i8, j as i8);
            let hash_code = position.hash_code();
            columns.push(Sensor::new(hash_code, position));
        }
        lines.push(columns);
    }
    Ok(lines)
}
