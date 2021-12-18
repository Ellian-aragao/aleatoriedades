use crate::Tamagotchi;

pub fn read_tamagotchi_name() -> String {
    println!("Enter Tamagotchi name: ");
    read_input().trim().to_string()
}

pub fn read_action_to_tamagotchi_action() -> fn(&mut Tamagotchi) {
    println!("Enter 1 to eat, 2 to shower, 3 to play, 4 to nothing:");
    let input = read_input();
    println!("valor: {}", input);
    converters::parse_input_to_tamagotchi_action(input)
}

fn read_input() -> String {
    let mut buf = String::new();
    match std::io::stdin().read_line(&mut buf) {
        Err(_) => read_input(),
        Ok(_) => buf,
    }
}

mod converters {
    use crate::Tamagotchi;

    enum Commands {
        Eat,
        Shower,
        Play,
        Nothing,
        Unknown,
    }

    pub fn parse_input_to_tamagotchi_action(input: String) -> fn(&mut crate::Tamagotchi) {
        match input.trim().parse::<i8>() {
            Err(_) => command_to_tamagotchi_action(Commands::Unknown),
            Ok(integer) => {
                let command = integer_to_command(integer);
                command_to_tamagotchi_action(command)
            }
        }
    }

    fn integer_to_command(input_numbers: i8) -> Commands {
        match input_numbers {
            1 => Commands::Eat,
            2 => Commands::Shower,
            3 => Commands::Play,
            4 => Commands::Nothing,
            _ => Commands::Unknown
        }
    }

    fn command_to_tamagotchi_action(command: Commands) -> fn(&mut Tamagotchi) {
        match command {
            Commands::Eat => { |mut tamagotchi: &mut Tamagotchi| tamagotchi.eat() }
            Commands::Shower => { |mut tamagotchi: &mut Tamagotchi| tamagotchi.shower() }
            Commands::Play => { |mut tamagotchi: &mut Tamagotchi| tamagotchi.play() }
            Commands::Nothing => { |mut tamagotchi: &mut Tamagotchi| {} }
            Commands::Unknown => { |mut tamagotchi: &mut Tamagotchi| tamagotchi.unknown_action() }
        }
    }
}