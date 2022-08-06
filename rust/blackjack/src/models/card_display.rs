use std::fmt::{Formatter, write};

pub enum CardDisplay {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
}

impl CardDisplay {
    pub fn get_value(&self) -> i32 {
        match self {
            CardDisplay::ACE => 1,
            CardDisplay::TWO => 2,
            CardDisplay::THREE => 3,
            CardDisplay::FOUR => 4,
            CardDisplay::FIVE => 5,
            CardDisplay::SIX => 6,
            CardDisplay::SEVEN => 7,
            CardDisplay::EIGHT => 8,
            CardDisplay::NINE => 9,
            CardDisplay::TEN => 10,
            CardDisplay::JACK => 10,
            CardDisplay::QUEEN => 10,
            CardDisplay::KING => 10,
        }
    }
}


impl std::fmt::Display for CardDisplay {
    fn fmt(&self, f: &mut Formatter) -> std::fmt::Result {
        write!(f, "{} -> {}", match self {
            CardDisplay::ACE => "A",
            CardDisplay::TWO => "2",
            CardDisplay::THREE => "3",
            CardDisplay::FOUR => "4",
            CardDisplay::FIVE => "5",
            CardDisplay::SIX => "6",
            CardDisplay::SEVEN => "7",
            CardDisplay::EIGHT => "8",
            CardDisplay::NINE => "9",
            CardDisplay::TEN => "10",
            CardDisplay::JACK => "J",
            CardDisplay::QUEEN => "Q",
            CardDisplay::KING => "K",
        }, self.get_value())
    }
}
