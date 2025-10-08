import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Inventory {
    public int ID;
    public ArrayList<Item> items;
    public HashMap<String, Item> itemMap;

    public Inventory(int ID) {
        this.ID = ID;
        this.items = new ArrayList<>();
        this.itemMap = new HashMap<>();
    }

    public ArrayList<Item> itemLoop() {
        ArrayList<Item> items1 = new ArrayList<>();
        for (Item item : items) {
            items1.add(item);
        }
        return items1;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void showInventory() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty");
            return;
        }

        HashMap<String, Item> map = new HashMap<>();

        for (Item item : items) {
            if (map.containsKey(item.itemName)) {
                map.get(item.itemName);
            }
            else {
                map.put(item.itemName, item);
            }
        }

        for (Item item : map.values()) {
            System.out.println(item.itemName);
        }
    }

}

