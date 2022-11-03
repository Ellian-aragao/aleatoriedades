use std::env;

fn encrypt(key_offset: i8, phrase: &String) -> String {
    let mut encrypted_phrase = String::new();
    for c in phrase.chars() {
        if jump_space(c, &mut encrypted_phrase) {
            continue;
        }
        let encrypted_char = shift_char(c, key_offset);
        encrypted_phrase.push(encrypted_char);
    }
    encrypted_phrase
}

fn decrypt(key_offset: i8, phrase: &String) -> String {
    let mut decrypted_phrase = String::new();
    for c in phrase.chars() {
        if jump_space(c, &mut decrypted_phrase) {
            continue;
        }
        let decrypted_char = shift_char(c, -key_offset) as char;
        decrypted_phrase.push(decrypted_char);
    }
    decrypted_phrase
}

fn jump_space(c: char, phrase: &mut String) -> bool {
    if c != ' ' {
        return false;
    }
    phrase.push(char::from(c));
    return true;
}

fn shift_char(c: char, key_offset: i8) -> char {
    let mut shifted_char = c.to_ascii_lowercase() as i8 + key_offset;

    if shifted_char < ('a' as i8) {
        shifted_char = shifted_char + 26;
    }

    if shifted_char > ('z' as i8) {
        shifted_char = shifted_char - 26;
    }

    (shifted_char as u8) as char
}

fn main() {
    let args: Vec<String> = env::args().collect();
    let key_offset = args[1].parse::<i8>().unwrap();
    let phrase = args[2].to_string();
    let encrypted_phrase = encrypt(key_offset, &phrase);
    println!("entry phrase: {}", &phrase);
    println!("Encrypted phrase: {}", encrypted_phrase);
    let decrypted_phrase = decrypt(key_offset, &phrase);
    println!("Decrypted phrase: {}", decrypted_phrase);
}
