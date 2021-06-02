fn main() {
    print!("Please enter some text: ");
    let s = read_input();
    println!("You typed: {}", clean_string(&s));
}

fn clean_string(string: &String) -> String {
    let mut s = string.to_string();
    if let Some('\n') = s.chars().next_back() {
        s.pop();
    }

    if let Some('\r') = s.chars().next_back() {
        s.pop();
    }
    return s;
}

fn read_input() -> String {
    std::io::stdout().flush().unwrap();
    let mut s = String::new();
    std::io::stdin().read_line(&mut s).unwrap();
    return s;
}
