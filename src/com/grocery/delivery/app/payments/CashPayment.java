package com.grocery.delivery.app.payments;

import com.grocery.delivery.app.orders.Order;
import com.grocery.delivery.app.users.Customer;

public class CashPayment implements Payment{

    @Override
    public void processOrder(Order order) {
        System.out.println("Making Cash Payment");
        order.setPaymentStatus(PaymentStatus.SUCCEEDED);
    }
}
