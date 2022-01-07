package com.grocery.delivery.app.orders;

import com.grocery.delivery.app.deliveries.DeliveryType;
import com.grocery.delivery.app.deliveries.Location;
import com.grocery.delivery.app.inventories.Cart;
import com.grocery.delivery.app.inventories.CartType;
import com.grocery.delivery.app.payments.*;
import com.grocery.delivery.app.users.Customer;

public class Order {
    OrderStatus orderStatus;
    Customer customer;
    PaymentStatus paymentStatus;
    Cart orderCart;

    public Order(Customer customer, Cart orderCart) {
        this.customer = customer;
        this.orderCart = orderCart;
        orderStatus = OrderStatus.PROCESSING;
        paymentStatus = PaymentStatus.UNDEFINED;
    }

    public PaymentType getPaymentType(){
        return customer.getPaymentType();
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public DeliveryType getDeliveryType() {
        return customer.getDeliveryType();
    }

    public void deliverOrder(){
        customer.setOrder(this);
    }

    public Location getDestination(){
        return customer.getHome();
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderStatus=" + orderStatus +
                ", paymentStatus=" + paymentStatus +
                ", orderCart=" + orderCart +
                '}';
    }
}
