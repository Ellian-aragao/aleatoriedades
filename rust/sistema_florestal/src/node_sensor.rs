use crate::Sensor;
use std::sync::atomic::AtomicPtr;

pub struct NodeSensor {
    sensor: Sensor,
    near_sensors: AtomicPtr<Vec<Sensor>>,
}

impl NodeSensor {
    pub fn new(sensor: Sensor) -> NodeSensor {
        let mut mutable: AtomicPtr<Vec<Sensor>> = AtomicPtr::default();
        NodeSensor {
            sensor,
            near_sensors: mutable,
        }
    }

    // pub fn add_near_sensor(&self, sensor: &Sensor) {
    //     self.near_sensors.get_mut().push((*sensor).clone())
    // }
}
