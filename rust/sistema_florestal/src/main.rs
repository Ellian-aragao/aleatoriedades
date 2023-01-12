use std::vec;

fn main() {
    let (width, height) = TAM_MAP_FLOREST;
    let florest = vec![vec![height]; width];
}

const DISTANCE_WARNING_MESSAGE: i8 = 3;
const DISTANCE_VIEW: i8 = 1;
const TAM_MAP_FLOREST: (usize, usize) = (30, 30);
struct Position {
    x: i8,
    y: i8,
}

struct Sensor {
    id: i8,
    position: Position,
}

struct Message {
    id_from_sensor: i8,
    warning_position: Position,
    time_warning: String,
}
