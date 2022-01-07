package com.grocery.delivery.app.work;

import com.grocery.delivery.app.store.Store;
import com.grocery.delivery.app.users.Customer;

public class ExecuteOnlineOrder extends Work{

    public void addOnlineOrder(Customer customer){
        // process payment
        // assign worker
        // add to shipping
    }
    public void executeOrder(){
        worker.setOrder(order);
        worker.generateCart();
        worker.standInQueue();
    }
}
