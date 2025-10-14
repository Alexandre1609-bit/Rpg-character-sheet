import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Item {
    String itemName;
    int damage;


    public Item( String itemName, int damage) {
        this.itemName = itemName;
        this.damage = damage;

    }


    public static List<Item> createItems() {
        List<Item> items = new ArrayList<>();

        //user
        items.add(new Item("Spear", 7));
        items.add(new Item("Bow", 12));
        items.add(new Item("Fist", 3));
        items.add(new Item("health potion", 7));
        return items;
    }

    public String toString() {
        return itemName;
    }


}