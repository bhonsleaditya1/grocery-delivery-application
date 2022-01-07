package com.grocery.delivery.app.deliveries;

import com.grocery.delivery.app.orders.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;

public class Vehicle {
    HashMap<Location,List<Order>> orders;
    Location currentLocation;
    List<Order> temp;
    Trip trip;
    final Timer timer;
    int limit;
    TripPlanning tripPlanning;

    public Vehicle(){
        orders = new HashMap<>();
        temp = new ArrayList<>();
        this.timer = new Timer("Vehicle",true);
        this.timer.scheduleAtFixedRate(new VehicleTask(this),0,2000);
        limit = 5;
    }

    public void setTripPlanning(TripPlanning tripPlanning) {
        this.tripPlanning = tripPlanning;
    }

    public void move() {
        System.out.println("Vehicle is at: "+currentLocation);
        currentLocation = trip.next();
        if(currentLocation==null) {
            this.timer.cancel();
            //this.timer.purge();
            this.tripPlanning.runningVehicles.remove(this);
        }else {
            makeDelivery();
        }
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
        makeDelivery();
    }

    public void setTrip(Trip trip, HashMap<Location, List<Order>> orders) {
        this.trip = trip;
        for(Location location:orders.keySet()){
            this.orders.put(location,orders.get(location));
        }
    }

    public void addTripOrder(Order order){
        Location destination = order.getDestination();
        if(orders.containsKey(destination)) {
            temp = new ArrayList<>();
            temp.add(order);
        }
        else{
            temp = new ArrayList<>();
            temp.add(order);
        }
        orders.put(order.getDestination(),temp);
    }

    public void makeDelivery(){
        temp = orders.get(currentLocation);
        if(temp!=null) {
            for (Order order : temp) {
                order.deliverOrder();
            }
        }
    }
}
