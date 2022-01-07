package com.grocery.delivery.app.users;

import com.grocery.delivery.app.deliveries.DeliveryType;
import com.grocery.delivery.app.deliveries.Location;
import com.grocery.delivery.app.inventories.Cart;
import com.grocery.delivery.app.orders.Order;
import com.grocery.delivery.app.payments.PaymentType;
import com.grocery.delivery.app.store.Store;


public class Customer extends User {
    Order order;
    DeliveryType deliveryType;
    Location home;
    PaymentType paymentType;
    CustomerType customerType;

    public Customer(String name, Store store) {
        super(name, store);
        setGlobalInventory(store.getInventory());
        paymentType = PaymentType.CASH;
        customerType = CustomerType.INSTORE;
        deliveryType = DeliveryType.INSTORE;
        home = null;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public void setHome(Location home) {
        this.home = home;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Cart generateCart() {
        for(String item: itemList.keySet()) {
            int quantity = itemList.get(item);
            for(int i=0;i<quantity;i++) {
                this.userCart.addItemInstance(item,globalInventory.getItemInstance(item));
            }
        }
        userCart.setCustomer(this);
        System.out.println("Collecting Items: "+ userCart);
        return userCart;
    }

    public void emptyCart(){
        userCart = null;
    }

    public void setOrder(Order order) {
        System.out.println("Received Order: "+ order);
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void standInQueue(){
        generateCart();
        store.standInQueue(this);
    }

    public Location getHome() {
        return home;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "order=" + order +
                ", deliveryType=" + deliveryType +
                ", home=" + home +
                ", paymentType=" + paymentType +
                '}';
    }
}
