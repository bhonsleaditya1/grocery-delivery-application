package com.grocery.delivery.app.users;

import com.grocery.delivery.app.inventories.Cart;
import com.grocery.delivery.app.inventories.Inventory;
import com.grocery.delivery.app.payments.PaymentType;
import com.grocery.delivery.app.store.Store;

import java.util.HashMap;

public abstract class User {
    String name;
    HashMap<String,Integer> itemList;
    Cart userCart;
    Inventory globalInventory;
    Store store;
    public User(String name, Store store){
        this.name = name;
        itemList = new HashMap<>();
        this.store = store;
        userCart = new Cart();
    }

    public void setGlobalInventory(Inventory globalInventory) {
        this.globalInventory = globalInventory;
    }

    public Cart getUserCart() {
        return userCart;
    }

    public void setUserCart(Cart userCart) {
        this.userCart = userCart;
    }

    public void addItem(String item, Integer amount){
        itemList.put(item, itemList.getOrDefault(item,0)+amount);
    }

    public void removeItems(String item, Integer amount) {
        if(itemList.get(item)<amount){
            removeItem(item);
        }else{
            itemList.put(item, itemList.get(item)-amount);
        }
    }


    public void removeItem(String item) {
        itemList.remove(item);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", storeManagement=" + store +
                '}';
    }
}
