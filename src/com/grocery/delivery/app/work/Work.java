package com.grocery.delivery.app.work;

import com.grocery.delivery.app.inventories.Cart;
import com.grocery.delivery.app.orders.Order;
import com.grocery.delivery.app.store.Store;
import com.grocery.delivery.app.users.Worker;

public abstract class Work {
    Worker worker;
    Cart cart;
    Order order;
    Store store;

    public void setStoreManagement(Store store) {
        this.store = store;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public void completed(){
        store.addWorker(worker);
    }
}
