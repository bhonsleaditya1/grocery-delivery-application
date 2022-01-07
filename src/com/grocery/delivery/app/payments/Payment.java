package com.grocery.delivery.app.payments;

import com.grocery.delivery.app.orders.Order;
import com.grocery.delivery.app.users.Customer;

public interface Payment {
    public void processOrder(Order order);
}
