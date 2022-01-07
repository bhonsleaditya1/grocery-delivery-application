package com.grocery.delivery.app.deliveries;

public class Location {
    String Name;
    Double lat,lon;
    public Location(String name, Double x, Double y){
        Name = name;
        lat = x;
        lon = y;
    }

    public boolean equals(Object location){
        if(location instanceof Location){
            return Name.equals(((Location) location).Name) && lat.equals(((Location) location).lat) && lon.equals(((Location) location).lon);
        }
        return false;

    }

    public int hashCode(){
        return Name.hashCode()+lat.hashCode()+lon.hashCode();
    }

    @Override
    public String toString() {
        return "Location{" +
                "Name='" + Name + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
