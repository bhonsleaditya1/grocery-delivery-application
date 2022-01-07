package com.grocery.delivery.app.work;

import com.grocery.delivery.app.deliveries.Trip;
import com.grocery.delivery.app.deliveries.TripPlanning;
import com.grocery.delivery.app.orders.Order;

public class Delivery extends Work{
    TripPlanning tripPlanning;

    public Delivery(){
        tripPlanning = new TripPlanning();
    }

    public void addOrder(Order order){
        System.out.println("Home Delivery for order "+order);
        tripPlanning.addOrder(order);}

    public void planDelivery(){
        tripPlanning.planTrip();
    }
    public void addTrip(Trip trip){
        tripPlanning.addTrip(trip);
    }
    public boolean isComplete(){
        return tripPlanning.isComplete();
    }
}
