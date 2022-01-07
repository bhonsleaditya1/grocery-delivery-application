package com.grocery.delivery.app.orders;

import com.grocery.delivery.app.inventories.Cart;
import com.grocery.delivery.app.inventories.CartType;
import com.grocery.delivery.app.users.Customer;

public class OnlineOrder extends Order{

    public OnlineOrder(Customer customer, Cart orderCart) {

        super(customer, orderCart);
    }
    private void processCart(Cart orderCart) {
        if(orderCart.getCartType().equals(CartType.ONLINE)){

            orderCart = null;
        }
    }
}
