package com.grocery.delivery.app.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Item {
    String name;
    HashMap<String,ItemInstance> instances;
    List<String> instanceIdList;
    Integer instanceSerial;
    ItemType type;
    public Item(String name,ItemType type){
        instances = new HashMap<>();
        instanceSerial=1;
        this.name = name;
        this.type = type;
        instanceIdList = new ArrayList<>();
    }

    public void addItemInstance(ItemInstance instance){
        instances.put(instance.Id,instance);
        instanceIdList.add(instance.Id);
    }
    public void createItemInstance(){
        String Id = name+instanceSerial++;
        addItemInstance(new ItemInstance(Id));
    }

    public ItemInstance getItemInstance(String Id){
        instanceIdList.remove(Id);
        return instances.remove(Id);
    }
    public ItemInstance getItemInstance(){
        if(!instanceIdList.isEmpty())
            return getItemInstance(instanceIdList.get(0));
        return null;
    }
    public void removeItemInstance(String Id){
        instances.remove(Id);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", instanceId=" + instanceIdList +
                '}';
    }
}
