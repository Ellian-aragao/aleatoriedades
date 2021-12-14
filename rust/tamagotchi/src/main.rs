use tamagotchi::Tamagotchi;

mod tamagotchi;

fn main() {
    let mut tamagotchi = Tamagotchi::new("Tamagotchi".to_string());
    println!("show\n{}\n", tamagotchi);
    let input_numbers = read_input_numbers();
    println!("valor: {}", input_numbers);
    input_to_tamagotchi_action(&mut tamagotchi, input_numbers);
    println!("show\n{}\n", tamagotchi);
    tamagotchi.randon_condition();
    if tamagotchi.dead() {
        println!("{} is dead :(", tamagotchi.get_name());
        return;
    }
    println!("show\n{}\n", tamagotchi);
}

fn read_tamagotchi_name() -> String {
    print!("Enter Tamagotchi name: ");

    let mut buf = String::new();
    std::io::stdin()
        .read_line(&mut buf)
        .expect("Failed to read line");
    buf
}

fn input_to_tamagotchi_action(tamagotchi: &mut Tamagotchi, input_numbers: u8) {
    match input_numbers {
        1 => tamagotchi.eat(),
        2 => tamagotchi.shower(),
        3 => tamagotchi.play(),
        _ => {}
    }
}

fn read_input_numbers() -> u8 {
    let mut buf = String::new();
    std::io::stdin().read_line(&mut buf)
        .expect("Should send some data");
    buf.trim().parse::<u8>().expect("Should send some integers")
}
