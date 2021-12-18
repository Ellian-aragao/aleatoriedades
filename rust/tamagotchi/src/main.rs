use std::process::exit;

use tamagotchi::Tamagotchi;

mod tamagotchi;
mod ui_actions;

fn main() {
    println!("Give a name to your Tamagotchi:");
    let mut tamagotchi = Tamagotchi::new(ui_actions::read_tamagotchi_name());
    while tamagotchi.is_alive() {
        println!("{}", tamagotchi);
        let action = ui_actions::read_action_to_tamagotchi_action();
        action(&mut tamagotchi);
        println!("{}", tamagotchi);
        tamagotchi.random_condition();
        println!("{}", tamagotchi);
        tamagotchi.is_dead_get_reason().map(|dead_reason| {
            println!("{} is dead :( why was {}", tamagotchi.get_name(), dead_reason);
            exit(0);
        });
        tamagotchi.next_age();
    }
}
