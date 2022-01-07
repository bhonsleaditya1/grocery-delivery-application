package com.grocery.delivery.app.inventories;

import com.grocery.delivery.app.items.Item;
import com.grocery.delivery.app.users.Customer;
import com.grocery.delivery.app.users.CustomerType;

import java.util.ArrayList;
import java.util.List;

public class Cart extends Inventory {
    Customer customer;
    CartType cartType;

    public void setCustomer(Customer customer) {
        this.customer = customer;
        this.cartType = switch (customer.getCustomerType()){
            case ONLINE -> CartType.ONLINE;
            case INSTORE -> CartType.INSTORE;
        };
    }

    public Customer getCustomer() {
        return customer;
    }

    public CartType getCartType() {
        return cartType;
    }

    public void setCartType(CartType cartType) {
        this.cartType = cartType;
    }

    @Override
    public String toString() {
        return "Cart{" +
                ", cartType=" + cartType +
                ", instances=" + instances +
                '}';
    }
}
