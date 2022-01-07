package com.grocery.delivery.app;

import com.grocery.delivery.app.deliveries.DeliveryType;
import com.grocery.delivery.app.deliveries.Location;
import com.grocery.delivery.app.deliveries.Trip;
import com.grocery.delivery.app.payments.PaymentType;
import com.grocery.delivery.app.users.Admin;
import com.grocery.delivery.app.store.Store;
import com.grocery.delivery.app.users.Customer;
import com.grocery.delivery.app.users.CustomerType;
import com.grocery.delivery.app.users.Worker;

import java.util.HashMap;

public class GroceryStore {
    static Store store;
    static Admin admin;
    static Trip trip;
    public static void main(String[] args) {
        store = new Store();
        adminActivity();
        location();
        addCustomers();
        store.startDelivery();
        //System.out.println(store.isComplete());
        while (!store.isComplete()){
            //System.out.println(store.isComplete());
        }
    }
    public static void location(){
        Location location = new Location("London",0.0,0.0);
        store.setStoreLocation(location);
        trip = new Trip();
        trip.addLocation(location);
        location = new Location("Manchester",10.0,31.0);
        trip.addLocation(location);
        location = new Location("Leeds",123.0,34.0);
        trip.addLocation(location);
        location = new Location("Worcester",233.0,123.0);
        trip.addLocation(location);
        location = new Location("Sussex",33.0,123.0);
        trip.addLocation(location);
        admin.addRoute(trip);
    }
    public static void addCustomers(){
        Customer customer = new Customer("C1",store);
        customer.setDeliveryType(DeliveryType.HOME);
        customer.setPaymentType(PaymentType.CASH);
        customer.setHome(trip.get(2));
        customer.addItem("Apple",12);
        customer.standInQueue();
        customer = new Customer("C12",store);
        customer.setDeliveryType(DeliveryType.HOME);
        customer.setPaymentType(PaymentType.CARD);
        customer.setHome(trip.get(3));
        customer.setCustomerType(CustomerType.ONLINE);
        customer.addItem("Apple",12);
        customer.standInQueue();
    }
    public static void adminActivity(){
        admin = new Admin("Admin",store);
        Worker worker = new Worker("W1",store);
        admin.addWorker(worker);
        worker = new Worker("W2",store);
        admin.addWorker(worker);
        admin.addItem("Apple",24);
        admin.setGlobalInventory(store.getInventory());
        admin.addToInventory();
        System.out.println(store.getInventory());
    }
}
