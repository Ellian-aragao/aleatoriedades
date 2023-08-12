pub enum CardSuit {
    HEARTS,
    DIAMONDS,
    CLUBS,
    SPADES,
}

impl std::fmt::Display for CardSuit {
    fn fmt(&self, f: &mut std::fmt::Formatter) -> std::fmt::Result {
        write!(f, "{}", match self {
            CardSuit::HEARTS => "Hearts",
            CardSuit::DIAMONDS => "Diamonds",
            CardSuit::CLUBS => "Clubs",
            CardSuit::SPADES => "Spades",
        })
    }
}
