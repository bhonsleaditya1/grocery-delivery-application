package com.grocery.delivery.app.inventories;

import com.grocery.delivery.app.items.Item;
import com.grocery.delivery.app.items.ItemInstance;
import com.grocery.delivery.app.items.ItemType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory {
    HashMap<String, Item> instances;
    Integer instanceSerial;
    public Inventory(){
        instances = new HashMap<>();
        instanceSerial=1;
    }

    public void addItemInstance(String itemName,ItemInstance instance){
        Item item = instances.get(itemName);
        if(item==null)
            item = new Item(itemName,ItemType.NONPERISHABLE);
        item.addItemInstance(instance);
        instances.put(itemName,item);
    }

    public void removeItem(String itemName){
        instances.remove(itemName);
    }
    public void removeInstance(String item,String itemInstanceId){
        instances.get(item).removeItemInstance(itemInstanceId);
    }

    public void createItem(String itemName, ItemType type,Integer quantity){
        Item item = new Item(itemName,type);
        for (int i = 0; i < quantity; i++) {
            item.createItemInstance();
        }
        instances.put(itemName,item);
    }

    public ItemInstance getItemInstance(String itemName){
        return instances.get(itemName).getItemInstance();
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "instances=" + instances +
                '}';
    }
}
