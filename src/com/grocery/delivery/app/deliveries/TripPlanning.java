package com.grocery.delivery.app.deliveries;

import com.grocery.delivery.app.orders.Order;

import java.util.*;

public class TripPlanning {
    Queue<Trip> trips;
    Queue<Vehicle> vehicleList;
    HashMap<Location,List<Order>> orders;
    Trip trip;
    List<Vehicle> runningVehicles;


    public TripPlanning() {
        this.trips = new LinkedList<>();
        this.vehicleList = new LinkedList<>();
        this.orders = new HashMap<>();
        runningVehicles = new ArrayList<>();
    }

    public void addTrip(Trip trip){
        this.trips.add(trip);
    }

    Vehicle getVehicle(){
        Vehicle vehicle = vehicleList.poll();
        if (vehicle==null){
            vehicle=new Vehicle();
        }
        vehicleList.add(vehicle);
        return vehicle;
    }

    public void planTrip(){
        trip = trips.poll();
        if(trip!=null){
            Vehicle vehicle = getVehicle();
            vehicle.setCurrentLocation(trip.getFirst());
            vehicle.setTripPlanning(this);
            vehicle.setTrip(trip,orders);
            runningVehicles.add(vehicle);
        }
    }

    public void addOrder(Order order) {
        List<Order> orderList =  orders.get(order.getDestination());
        if(orderList==null)
            orderList= new ArrayList<>();
        orderList.add(order);
        orders.put(order.getDestination(), orderList);
    }

    public boolean isComplete(){
        return runningVehicles.isEmpty();
    }
}
