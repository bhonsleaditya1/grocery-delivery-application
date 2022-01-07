package com.grocery.delivery.app.users;

import com.grocery.delivery.app.deliveries.Trip;
import com.grocery.delivery.app.inventories.Inventory;
import com.grocery.delivery.app.items.ItemType;
import com.grocery.delivery.app.store.Store;

public class Admin extends User{
    public Admin(String name, Store store){
        super(name, store);
    }
    public void addWorker(Worker worker){
        worker.setStatus(Status.AVAILABLE);
        store.addWorker(worker);
    }

    public void addCounterService(){
        store.addCounter();}

    public void addDeliveryService(){
        store.addDeliveryService();}

    public Inventory addToInventory(){
        for(String item:itemList.keySet()) {
            globalInventory.createItem(item, ItemType.NONPERISHABLE,itemList.get(item));
        }
        return globalInventory;
    }

    public void addRoute(Trip trip) {
        store.addRoute(trip);
    }
}
