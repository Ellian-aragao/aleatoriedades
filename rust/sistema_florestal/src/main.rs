use std::{thread, time::Duration};

use position::Position;
use sensor::Sensor;

mod constants;
mod position;
mod sensor;
mod utils;
mod message;

fn main() {
    let (range_x, range_y) = constants::TAM_MAP_FLOREST;
    let range_sensor_warning = constants::DISTANCE_WARNING_MESSAGE;
    let lines = utils::create_map(range_x, range_y);
    let sensors = utils::create_sensors(&lines, &range_sensor_warning);
    let connected_sensors = utils::connect_sensors(sensors, range_sensor_warning);
    let threads = utils::initialize_sensors(connected_sensors);
    thread::sleep(Duration::from_secs(10));
    for thread in threads {
        thread.join().expect("could not join threads");
    }
    // TODO: criar processo de verificação de nodos próximos
    // utils::print_sensors(&connected_sensors);
    // utils::print_vector(&lines);
}
