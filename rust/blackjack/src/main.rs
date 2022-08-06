use crate::models::card::Card;
use crate::models::card_display::CardDisplay;
use crate::models::card_suit::CardSuit;

mod models;

fn main() {
    println!("Hello, world!");
    println!("values: {}", CardSuit::HEARTS as i32);
    println!("values: {}", CardDisplay::ACE);
    println!("card {}", Card::new(CardSuit::HEARTS, CardDisplay::ACE));
}
