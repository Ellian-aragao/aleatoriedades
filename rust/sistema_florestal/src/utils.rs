use crate::{position::Position, constants, sensor::Sensor};


pub fn get_size_matrix<T>(matrix: &Vec<Vec<T>>) -> (usize, usize) {
  let range_x = matrix.len();
  let range_y = matrix.get(0).expect("Matrix can not be empty").len();
  (range_x, range_y)
}


pub fn connect_sensors(sensors: Vec<Sensor>, range_sensor_warning: usize) -> Vec<Sensor> {
  for sensor_a in &sensors {
      for sensor_b in &sensors {
          let delta_positions = sensor_a
              .position_ref()
              .delta_position(&sensor_b.position_ref());
          if 0.0 < delta_positions && delta_positions <= range_sensor_warning as f64 {
              println!("delta: {delta_positions} - could join: {sensor_a} - {sensor_b}");
          }
      }
  }
  sensors
}

pub fn print_sensors(sensors: &[Sensor]) {
  for sensor in sensors {
      print!("{sensor}");
  }
  print!("\n");
}

pub fn create_sensors(lines: &Vec<Vec<Position>>, range_sensor_warning: &usize) -> Vec<Sensor> {
  let (range_x, range_y) = get_size_matrix(lines);
  let total_nodes = calc_total_nodes(&range_x, &range_y);
  let mut sensors = Vec::with_capacity(total_nodes);

  for counter_x in (1..range_x).step_by(*range_sensor_warning) {
      for counter_y in (1..range_y).step_by(*range_sensor_warning) {
          let position = lines
              .get(counter_x)
              .and_then(|collumn| collumn.get(counter_y))
              .expect(
                  r#"Do not exist position from called reference: ({counter_x},{counter_y})"#,
              );
          let sensor = Sensor::from_position(position);
          sensors.push(sensor);
      }
  }
  sensors
}

fn calc_nodes_per_range_emit_message(range: &usize) -> usize {
  let nodes = (range + 1) / constants::DISTANCE_WARNING_MESSAGE as usize;
  if nodes == 0 {
      1
  } else {
      nodes
  }
}

fn calc_total_nodes(range_x: &usize, range_y: &usize) -> usize {
  calc_nodes_per_range_emit_message(range_x) * calc_nodes_per_range_emit_message(range_y)
}

pub fn print_vector(lines: &Vec<Vec<Position>>) {
  for line in lines {
      for value in line {
          print!("{value} ");
      }
      print!("\n");
  }
}

pub fn create_map(range_x: usize, range_y: usize) -> Vec<Vec<Position>> {
  let mut lines: Vec<Vec<Position>> = Vec::with_capacity(range_x);
  for i in 0..range_x {
      let mut columns: Vec<Position> = Vec::with_capacity(range_y);
      for j in 0..range_y {
          let position = Position::new(i as u8, j as u8);
          columns.push(position);
      }
      lines.push(columns);
  }
  lines
}
