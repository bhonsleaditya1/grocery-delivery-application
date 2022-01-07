package com.grocery.delivery.app.payments;

import com.grocery.delivery.app.orders.Order;
import com.grocery.delivery.app.users.Customer;

public class CardPayment implements Payment{
    @Override
    public void processOrder(Order order) {
        System.out.println("Making Card Payment");
        order.setPaymentStatus(PaymentStatus.SUCCEEDED);
    }
}
