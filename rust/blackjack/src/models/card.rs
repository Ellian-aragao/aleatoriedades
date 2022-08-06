use std::borrow::Borrow;
use crate::{CardDisplay, CardSuit};

pub struct Card {
    suit: CardSuit,
    display: CardDisplay,
}

impl Card {
    pub fn new(suit: CardSuit, display: CardDisplay) -> Card {
        Card {
            suit,
            display,
        }
    }

    pub fn get_suit(&self) -> &CardSuit {
        &self.suit
    }

    pub fn get_display(&self) -> &CardDisplay {
        &self.display
    }
}

impl std::fmt::Display for Card {
    fn fmt(&self, f: &mut std::fmt::Formatter) -> std::fmt::Result {
        write!(f, "{} of {}", self.display, self.suit)
    }
}
