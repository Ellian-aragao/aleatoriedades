use std::fmt::Formatter;
use std::io::BufRead;
use std::vec;
use sensor::Sensor;
use position::Position;

mod sensor;
mod position;

fn main() {
    let mut lines: Vec<Vec<Sensor>> = Vec::new();
    let (range_x, range_y) = TAM_MAP_FLOREST;

    for i in 0..range_x {
        let mut columns: Vec<Sensor> = Vec::new();
        for j in 0..range_y {
            let position = Position::new(i as i8, j as i8);
            let hash_code = position.hash_code();
            columns.push(Sensor::new(hash_code, position));
        }
        lines.push(columns);
    }


    for line in lines {
        for value in line {
            print!("{value} ");
        }
        print!("\n");
    }
}

const DISTANCE_WARNING_MESSAGE: i8 = 3;
const DISTANCE_VIEW: i8 = 1;
const TAM_MAP_FLOREST: (usize, usize) = (10, 10);

struct Message {
    id_from_sensor: i8,
    warning_position: position,
    time_warning: String,
}
