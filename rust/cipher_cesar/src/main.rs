use std::env;
mod cesar_cipher {

    pub struct CesarCipher {
        key: u8,
        initial_text: String,
        rigth: String,
        left: String,
    }

    impl CesarCipher {
        pub fn new(key: u8, initial_text: &str) -> CesarCipher {
            CesarCipher {
                key: key,
                initial_text: initial_text.to_string(),
                left: left_cipher(&key, &initial_text.to_string()),
                rigth: right_cipher(&key, &initial_text.to_string()),
            }
        }

        pub fn get_key(&self) -> u8 {
            self.key
        }

        pub fn get_initial_text(&self) -> &str {
            &self.initial_text
        }

        pub fn get_right(&self) -> String {
            self.rigth.clone()
        }

        pub fn get_left(&self) -> String {
            self.left.clone()
        }
    }

    fn right_cipher(key_offset: &u8, phrase: &String) -> String {
        cipher_calculate(&(*key_offset as i8), phrase)
    }

    fn left_cipher(key_offset: &u8, phrase: &String) -> String {
        cipher_calculate(&-(*key_offset as i8), phrase)
    }

    fn cipher_calculate(key_offset: &i8, phrase: &String) -> String {
        let mut final_phrase = String::new();
        for c in phrase.chars() {
            let shifted_char = shift_characters::shift_char(c, &key_offset) as char;
            final_phrase.push(shifted_char);
        }
        final_phrase
    }

    mod shift_characters {
        pub fn shift_char(char_to_shift: char, key_offset: &i8) -> char {
            if should_ignore_non_letter(char_to_shift) {
                return char_to_shift;
            }
            let shifted_char = shift_char_by_offset_absolute(&char_to_shift, &key_offset);
            let shifted_char_bounded = shift_char_bounded_loop(&char_to_shift, &shifted_char);
            shifted_char_bounded as char
        }

        fn should_ignore_non_letter(c: char) -> bool {
            match c {
                'a'..='z' | 'A'..='Z' => false,
                __ => true,
            }
        }

        fn shift_char_by_offset_absolute(char_to_shift: &char, key_offset: &i8) -> u8 {
            if key_offset.is_positive() {
                return *char_to_shift as u8 + key_offset.abs() as u8;
            }
            return *char_to_shift as u8 - key_offset.abs() as u8;
        }

        fn shift_char_bounded_loop(c: &char, shifted_char: &u8) -> u8 {
            if c.is_ascii_lowercase() {
                return shift_char_bounded_checker_resolver(&shifted_char, 'a', 'z');
            }
            return shift_char_bounded_checker_resolver(&shifted_char, 'A', 'Z');
        }

        fn shift_char_bounded_checker_resolver(
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
    }
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
    let phrase = args[2].to_string();
    let cipher = cesar_cipher::CesarCipher::new(key_offset, &phrase);

    println!("  key offset: {}", cipher.get_key());
    println!("entry phrase: {}", cipher.get_initial_text());
    println!("right phrase: {}", cipher.get_right());
    println!(" left phrase: {}", cipher.get_left());
}

}
