use std::fmt::{Display, Formatter, Result};

impl Display for Position {
    fn fmt(&self, f: &mut Formatter<'_>) -> Result {
        write!(f, "({:0>2},{:0>2})", self.x, self.y)
    }
}

impl Clone for Position {
    fn clone(&self) -> Self {
        Position::new(self.x, self.y)
    }
}

pub struct Position {
    x: u8,
    y: u8,
}

impl Position {
    pub fn new(x: u8, y: u8) -> Self {
        Position { x, y }
    }

    pub fn hash_code(&self) -> i64 {
        let x = self.x as i64;
        let y = self.y as i64;
        (x + y) * (x + y + 1) / 2 + x
    }

    pub fn delta_position(&self, position: &Position) -> f64 {
        let delta_x = Position::delta_value(&self.x, &position.x) as i64;
        let delta_y = Position::delta_value(&self.y, &position.y) as i64;

        let square_delta_x = delta_x.pow(2) as f64;
        let square_delta_y = delta_y.pow(2) as f64;

        (square_delta_x + square_delta_y).sqrt()
    }

    pub fn delta_x(&self, reference: &u8) -> u8 {
        Position::delta_value(&self.x, reference)
    }

    pub fn delta_y(&self, reference: &u8) -> u8 {
        Position::delta_value(&self.y, reference)
    }

    fn delta_value(a: &u8, b: &u8) -> u8 {
        a.abs_diff(*b)
    }
}
