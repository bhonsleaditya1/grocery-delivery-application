package com.grocery.delivery.app.deliveries;

import java.util.ArrayList;
import java.util.List;

public class Trip {
    List<Location> locationList;
    Integer curr;

    public Trip() {
        locationList = new ArrayList<>();
        curr=0;
    }

    public void addLocation(Location location){
        locationList.add(location);
    }
    public Location getFirst(){
        return locationList.get(0);
    }
    public Location next(){
        curr++;
        if(curr>= locationList.size())
            return null;
        return locationList.get(curr); }
    public Location get(int i){return locationList.get(i);}
}
