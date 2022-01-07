package com.grocery.delivery.app.users;

import com.grocery.delivery.app.inventories.Cart;
import com.grocery.delivery.app.orders.Order;
import com.grocery.delivery.app.orders.OrderStatus;
import com.grocery.delivery.app.payments.*;
import com.grocery.delivery.app.store.Store;

public class Worker extends Customer{
    Payment payment;
    WorkerStatus workerStatus;

    public Worker(String name, Store store){
        super(name, store);
        workerStatus = WorkerStatus.UNAVALIABLE;
    }

    public WorkerStatus getStatus() {
        return workerStatus;
    }

    public void setStatus(WorkerStatus workerStatus) {
        this.workerStatus = workerStatus;
    }

    public Payment getPaymentMethod(PaymentType paymentType){
        return switch (paymentType) {
            case CARD -> new CardPayment();
            case CASH -> new CashPayment();
        };
    }

    public Order processCart(Cart cart){
        order = new Order(cart.getCustomer(),cart);
        payment = getPaymentMethod(order.getPaymentType());
        //payment
        payment.processOrder(order);
        if(order.getOrderStatus().equals(OrderStatus.PAID)){
            //generate bill
            // add to delivery queue
            // hand to customer
            return order;
        }
        else {
            if(order.getPaymentStatus().equals(PaymentStatus.SUCCEEDED)) {
                order.setOrderStatus(OrderStatus.PAID);
                return order;
            } else {
                order.setOrderStatus(OrderStatus.UNPAID);
            }
        }
        //generate bill
        workerStatus = WorkerStatus.AVAILABLE;
        return null;
    }

    public void isFree(){
        store.addWorker(this);
    }

}
