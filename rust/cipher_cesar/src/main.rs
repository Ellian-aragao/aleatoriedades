use std::env;

fn encrypt(key_offset: &u8, phrase: &String) -> String {
    let mut encrypted_phrase = String::new();
    for c in phrase.chars() {
        if ignore_non_letters(c, &mut encrypted_phrase) {
            continue;
        }
        let encrypted_char = shift_char(c, &(*key_offset as i8));
        encrypted_phrase.push(encrypted_char);
    }
    encrypted_phrase
}

fn decrypt(key_offset: &u8, phrase: &String) -> String {
    let mut decrypted_phrase = String::new();
    for c in phrase.chars() {
        if ignore_non_letters(c, &mut decrypted_phrase) {
            continue;
        }
        let decrypted_char = shift_char(c, &-(*key_offset as i8)) as char;
        decrypted_phrase.push(decrypted_char);
    }
    decrypted_phrase
}

fn ignore_non_letters(c: char, phrase: &mut String) -> bool {
    match c {
        'a'..='z' | 'A'..='Z' => false,
        __ => {
            phrase.push(c);
            true
        }
    }
}

fn shift_char(char_to_shift: char, key_offset: &i8) -> char {
    let shifted_char = shift_char_by_offset_absolute(&char_to_shift, &key_offset);
    let shifted_char_bounded = shift_char_bounded(&char_to_shift, &shifted_char);
    shifted_char_bounded as char
}

fn shift_char_by_offset_absolute(char_to_shift: &char, key_offset: &i8) -> u8 {
    if key_offset.is_positive() {
        return *char_to_shift as u8 + key_offset.abs() as u8;
    }
    return *char_to_shift as u8 - key_offset.abs() as u8;
}

fn shift_char_bounded(c: &char, shifted_char: &u8) -> u8 {
    if c.is_ascii_lowercase() {
        return shift_char_bounded_checker(&shifted_char, 'a', 'z');
    }
    return shift_char_bounded_checker(&shifted_char, 'A', 'Z');
}

fn shift_char_bounded_checker(
    shifted_char: &u8,
    left_bound_letter: char,
    right_bound_letter: char,
) -> u8 {
    let delta_letters = 26;

    if *shifted_char > right_bound_letter as u8 {
        return *shifted_char - delta_letters;
    }
    if *shifted_char < left_bound_letter as u8 {
        return *shifted_char + delta_letters;
    }
    return *shifted_char;
}

fn main() {
    let args: Vec<String> = env::args().collect();
    let key_offset = match args[1].parse::<u8>() {
        Ok(n) => match n {
            1..=25 => n,
            __ => panic!("Please enter a valid number (1..25)"),
        },
        Err(_) => panic!("Please enter a valid number (1..25)"),
    };
    println!("      key offset: {}", key_offset);
    let phrase = args[2].to_string();
    println!("    entry phrase: {}", phrase);
    let encrypted_phrase = encrypt(&key_offset, &phrase);
    println!("Encrypted phrase: {}", encrypted_phrase);
    let decrypted_phrase = decrypt(&key_offset, &phrase);
    println!("Decrypted phrase: {}", decrypted_phrase);
}
