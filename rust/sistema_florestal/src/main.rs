use std::{io, sync::Arc};

mod constants;
mod message;
mod position;
mod sensor;
mod utils;

fn main() {
    let (range_x, range_y) = constants::TAM_MAP_FLOREST;
    let range_sensor_warning = constants::DISTANCE_WARNING_MESSAGE;
    let lines = Arc::new(utils::create_map(range_x, range_y));
    let sensors = utils::create_sensors(&lines, &range_sensor_warning);
    let connected_sensors = utils::connect_sensors(sensors, range_sensor_warning);
    let threads = utils::initialize_sensors(connected_sensors);
    // makes main thread wait input and other threads make his processes
    io::stdin().read_line(&mut String::new()).expect("send message");
    // TODO: criar processo de verificação de nodos próximos
    // utils::print_sensors(&connected_sensors);
    utils::print_vector(&lines);
}
