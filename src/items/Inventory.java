package src.items;

import java.util.HashMap;

public class Inventory {

    private HashMap<Item, Integer> inventory;
    private int inventoryCapacity;

    public Inventory(int inventoryCapacity){
        inventory = new HashMap<>();
        this.inventoryCapacity = inventoryCapacity;
    }


    public boolean putInventory(Item item, int count) {
        //if item exists
        Integer itemCount = inventory.get(item);
        if (itemCount != null) {
            itemCount += count;
            inventory.put(item, itemCount);
            return true;
        }
        //if inventory full
        if (inventory.size() <= inventoryCapacity) {
            return false;
        }

        inventory.put(item, count);
        return true;
    }

    public boolean useInventory(Item item, int count) {
        //placeholder
        return true;
    }

    public boolean showInventory(){
        //placeholder
        return true;
    }
}