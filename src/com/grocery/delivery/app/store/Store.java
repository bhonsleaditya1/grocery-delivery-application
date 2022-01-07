package com.grocery.delivery.app.store;

import com.grocery.delivery.app.deliveries.DeliveryType;
import com.grocery.delivery.app.deliveries.Location;
import com.grocery.delivery.app.deliveries.Trip;
import com.grocery.delivery.app.deliveries.TripPlanning;
import com.grocery.delivery.app.inventories.Inventory;
import com.grocery.delivery.app.orders.Order;
import com.grocery.delivery.app.users.Admin;
import com.grocery.delivery.app.users.Customer;
import com.grocery.delivery.app.users.Status;
import com.grocery.delivery.app.users.Worker;
import com.grocery.delivery.app.work.Counter;
import com.grocery.delivery.app.work.Delivery;
import com.grocery.delivery.app.work.ExecuteOnlineOrder;

import java.util.*;

public class Store {
    Queue<Worker> workerList;
    HashMap<String,Admin> admins;
    //List<Customer> customers;
    Inventory inventory;
    Queue<Counter> counters;
    Queue<Delivery> deliveries;
    ExecuteOnlineOrder executeOnlineOrder;
    Counter counter;
    Delivery delivery;
    Location storeLocation;

    public Store(){
        workerList = new LinkedList<>();
        admins = new HashMap<>();
        inventory = new Inventory();
        counters = new LinkedList<>();
        executeOnlineOrder = new ExecuteOnlineOrder();
    }

    public Location getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(Location storeLocation) {
        this.storeLocation = storeLocation;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Worker getWorker(){
        if(workerList.isEmpty())
            throw new RuntimeException("No Workers Found");
        Worker worker = workerList.poll();
        worker.setStatus(Status.BUSY);
        return worker;
    }

    public void addWorker(Worker worker){
        worker.setStatus(Status.AVAILABLE);
        workerList.add(worker);
        System.out.println("Worker: "+ worker+" added to list");
    }

    public void standInQueue(Customer customer){
        System.out.println("Customer: "+customer+" standing in queue");
        counter = getOrAddCounter();
        counter.addCustomer(customer);
        counter.processCustomers();
    }

    private Counter getOrAddCounter() {
        System.out.println("Getting Counter");
        counter = counters.poll();
        if(counter==null){
            counter = addCounter();
        }
        return counter;
    }

    private Delivery getOrAddDelivery() {
        System.out.println("Getting Delivery");
        if(delivery==null){
            delivery = addDeliveryService();
        }
        return delivery;
    }

    public void addDelivery(Customer customer, Order order) {
        if(order.getDeliveryType().equals(DeliveryType.INSTORE)){
            customer.setOrder(order);
        }
        else {
            //delivery = getOrAddDelivery();
            delivery.addOrder(order);
        }
    }

    public Counter addCounter(){
        Worker worker = getWorker();
        counter = new Counter();
        counter.setStoreManagement(this);
        counter.setWorker(worker);
        System.out.println("Counter Added with worker: "+worker);
        counters.add(counter);
        return counter;
    }

    public Delivery addDeliveryService() {
        Worker worker = getWorker();
        Delivery delivery = new Delivery();
        delivery.setStoreManagement(this);
        delivery.setWorker(worker);
        System.out.println("Adding Delivery Service with worker: "+worker);
        return delivery;
    }

    public void addOnlineOrderExecuter(Customer customer){
        executeOnlineOrder.addOnlineOrder(customer);
    }

    public void addRoute(Trip trip) {
        delivery = getOrAddDelivery();
        delivery.addTrip(trip);
    }

    public void startDelivery(){
        delivery.planDelivery();
    }
    public boolean isComplete(){
        return delivery.isComplete();
    }
}
