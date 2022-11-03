use std::env;

fn encrypt(key_offset: &i8, phrase: &String) -> String {
    let mut encrypted_phrase = String::new();
    for c in phrase.chars() {
        if ignore_non_letters(c, &mut encrypted_phrase) {
            continue;
        }
        let encrypted_char = shift_char(c, key_offset);
        encrypted_phrase.push(encrypted_char);
    }
    encrypted_phrase
}

fn decrypt(key_offset: &i8, phrase: &String) -> String {
    let mut decrypted_phrase = String::new();
    for c in phrase.chars() {
        if ignore_non_letters(c, &mut decrypted_phrase) {
            continue;
        }
        let negative_key_offset = -key_offset;
        let decrypted_char = shift_char(c, &negative_key_offset) as char;
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

fn shift_char(c: char, key_offset: &i8) -> char {
    let unsigned_char_value = c.to_ascii_lowercase() as u8;
    let mut shifted_char: u8;
    if *key_offset < 0 {
        shifted_char = unsigned_char_value - key_offset.abs() as u8;
    } else {
        shifted_char = unsigned_char_value + *key_offset as u8;
    }

    if shifted_char < ('a' as u8) {
        shifted_char = shifted_char + 26;
    }

    if shifted_char > ('z' as u8) {
        shifted_char = shifted_char - 26;
    }

    shifted_char as char
}

fn main() {
    let args: Vec<String> = env::args().collect();
    let key_offset = match args[1].parse::<i8>() {
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
