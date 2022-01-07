package com.grocery.delivery.app.deliveries;

import com.grocery.delivery.app.inventories.Inventory;

import java.util.ArrayList;
import java.util.List;

public class Trip {
    List<Location> trip;
    Integer curr;

    public Trip() {
        trip = new ArrayList<>();
        curr=0;
    }

    public void addLocation(Location location){
        trip.add(location);
    }
    public Location getFirst(){
        return trip.get(0);
    }
    public Location next(){
        curr++;
        if(curr>=trip.size())
            return null;
        return trip.get(curr); }
    public Location get(int i){return trip.get(i);}
}
