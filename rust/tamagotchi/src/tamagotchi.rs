use rand::Rng;

pub struct Tamagotchi {
    name: String,
    hunger: u8,
    boredom: u8,
    health: u8,
    age: u8,
}

impl std::fmt::Display for Tamagotchi {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        write!(
            f,
            "Name: {}\nHunger: {}\nBoredom: {}\nHealth: {}\nAge: {}",
            self.name, self.hunger, self.boredom, self.health, self.age
        )
    }
}

impl Tamagotchi {
    pub fn new(name: String) -> Tamagotchi {
        Tamagotchi {
            name,
            hunger: 10,
            boredom: 10,
            health: 10,
            age: 0,
        }
    }

    pub fn randon_condition(&mut self) {
        match rand::thread_rng().gen_range(1..4) {
            1 => self.boredom += 1,
            2 => self.hunger += 1,
            3 => self.health -= 1,
            _ => {}
        }
    }

    pub fn get_name(&self) -> &String {
        &self.name
    }

    pub fn eat(&mut self) {
        self.hunger -= 2;
        self.health -= 2;
    }

    pub fn play(&mut self) {
        self.boredom -= 3;
        self.hunger += 1;
    }

    pub fn shower(&mut self) {
        self.health += 7;
        self.boredom += 3;
    }

    pub fn next_age(&mut self) -> &u8 {
        self.age += 1;
        return &self.age;
    }

    pub fn dead(&self) -> bool {
        return if vec![self.hunger, self.boredom, self.health]
            .iter().any(|&x| x <= 0 || x >= 15) {
            true
        } else {
            false
        };
    }
}
