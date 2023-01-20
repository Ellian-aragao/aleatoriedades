use std::fmt::{Display, Formatter, Result};

use crate::position::Position;

pub struct Sensor {
    id: i64,
    position: Position,
}

impl Sensor {
    pub fn new(id: i64, position: Position) -> Sensor {
        Sensor { id, position }
    }

    pub fn from_position(position: &Position) -> Sensor {
        Sensor::new(position.hash_code(), position.clone())
    }

    pub fn position_ref(&self) -> &Position {
        &self.position
    }
}

impl Display for Sensor {
    fn fmt(&self, f: &mut Formatter<'_>) -> Result {
        write!(f, "[{:0>3},{}])", self.id, self.position)
    }
}
