import java.util.ArrayList;
import java.util.List;

public class Item {
    int ID;
    String itemName;
    String value;
    String type;
    boolean isBroken;
    int weight;
    int quantity;


    public Item(int ID, String itemName, String value, String type, boolean isBroken, int weight, int quantity) {
        this.ID = ID;
        this.itemName = itemName;
        this.value = value;
        this.type = type;
        this.isBroken = isBroken;
        this.weight = weight;
        this.quantity = quantity;
    }


    public static List<Item> createItems() {
        List<Item> items = new ArrayList<>();

        items.add(new Item(1, "Spear", "10 crowns", "Weapon", false, 10, 0));
        items.add(new Item(2, "bag", "5 crowns", "Container", false, 1, 0));
        items.add(new Item(3, "health potion", "5 crowns", "Consumable", false, 1, 0));
        return items;
    }

    public String toString() {
        return itemName + " (type: " + type + ", value: " + value + ", weight: " + weight + ", quantity: " + quantity + ")";
    }
}