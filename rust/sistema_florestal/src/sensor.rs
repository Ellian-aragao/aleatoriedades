use std::{
    fmt::{Display, Formatter},
    result::Result,
    sync::mpsc::{Receiver, RecvTimeoutError, SendError, Sender},
    time::{self, Duration},
};

use crate::{message::Message, position::Position};

pub struct Sensor {
    id: i64,
    position: Position,
    near_sensors_sender: Box<Vec<Sender<Message>>>,
    near_sensors_receiver: Box<Vec<Receiver<Message>>>,
}

impl Sensor {
    pub fn new(id: i64, position: Position) -> Self {
        Sensor {
            id,
            position,
            near_sensors_sender: Box::new(vec![]),
            near_sensors_receiver: Box::new(vec![]),
        }
    }

    pub fn from_position(position: &Position) -> Self {
        Sensor::new(position.hash_code(), position.clone())
    }

    pub fn position_ref(&self) -> &Position {
        &self.position
    }

    pub fn add_sensor_sender(&mut self, sender: Sender<Message>) -> &mut Self {
        self.near_sensors_sender.push(sender);
        self
    }

    pub fn add_sensor_receiver(&mut self, receiver: Receiver<Message>) -> &mut Self {
        self.near_sensors_receiver.push(receiver);
        self
    }

    pub fn read_messages(&self, timeout: &Duration) -> Vec<Result<Message, RecvTimeoutError>> {
        self.near_sensors_receiver
            .iter()
            .map(|receiver| {
                println!("sensor received message: {}", self);
                receiver
            })
            .map(|receiver| receiver.recv_timeout(*timeout))
            .collect::<Vec<_>>()
    }

    pub fn send_message(&self, position: &Position) -> Vec<Result<(), SendError<Message>>> {
        self.near_sensors_sender
            .iter()
            .map(|sender| {
                let data = time::Instant::now().elapsed().as_secs().to_string();
                sender.send(Message::new(self.id as i8, position.clone(), data))
            })
            .collect::<Vec<_>>()
    }
}

impl Display for Sensor {
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
        write!(f, "[{:0>3},{}])", self.id, self.position)
    }
}

unsafe impl Send for Sensor {}
