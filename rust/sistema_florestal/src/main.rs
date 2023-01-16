use position::Position;
use sensor::Sensor;

mod constants;
mod position;
mod sensor;

fn main() {
    let mut lines: Vec<Vec<Sensor>> = Vec::new();
    let (range_x, range_y) = constants::TAM_MAP_FLOREST;

    for i in 0..range_x {
        let mut columns: Vec<Sensor> = Vec::new();
        for j in 0..range_y {
            let position = Position::new(i as i8, j as i8);
            let hash_code = position.hash_code();
            columns.push(Sensor::new(hash_code, position));
        }
        lines.push(columns);
    }

    // TODO: criar processo de verificaç~ao de nodos próximos

    for line in lines {
        for value in line {
            print!("{value} ");
        }
        print!("\n");
    }
}
