package com.grocery.delivery.app.deliveries;

import java.util.TimerTask;

public class VehicleTask extends TimerTask {
    Vehicle vehicle;

    public VehicleTask(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void run() {
        vehicle.move();

    }
}
