use std::fmt::Display;

use crate::position::Position;

pub struct Message {
    id_from_sensor: i8,
    warning_position: Position,
    time_warning: String,
}

impl Message {
    pub fn new(id_from_sensor: i8, warning_position: Position, time_warning: String) -> Self {
        Message {
            id_from_sensor,
            warning_position,
            time_warning,
        }
    }

    pub fn to_message(&self) -> String {
        format!(
            "id sensor: {}, warning position: {}, time warning: {}",
            self.id_from_sensor, self.warning_position, self.time_warning
        )
    }
}

impl Clone for Message {
    fn clone(&self) -> Self {
        Self { id_from_sensor: self.id_from_sensor.clone(), warning_position: self.warning_position.clone(), time_warning: self.time_warning.clone() }
    }
}

impl Display for Message {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        write!(
            f,
            "id from sensor: {}, warning_position: {}, time_warning: {}",
            self.id_from_sensor, self.warning_position, self.time_warning
        )
    }
}

// impl Sync for Message {

// }
