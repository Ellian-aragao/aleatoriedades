use std::fmt::{Display, Formatter, Result};

impl Display for Position {
    fn fmt(&self, f: &mut Formatter<'_>) -> Result {
        write!(f, "({:0>2},{:0>2})", self.x, self.y)
    }
}

pub struct Position {
    x: i8,
    y: i8,
}

impl Position {
    pub fn new(x: i8, y: i8) -> Position {
        Position { x, y }
    }

    pub fn hash_code(&self) -> i64 {
        let x = self.x as i64;
        let y = self.y as i64;
        (x + y) * (x + y + 1) / 2 + x
    }
}
