use crate::position::Position;

pub struct Message {
    id_from_sensor: i8,
    warning_position: Position,
    time_warning: String,
}
