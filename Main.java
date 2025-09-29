import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        List<CharacterSheet> charList = CharacterSheet.createChar();
        List<Item> items = Item.createItems();
        Inventory invPerso = charList.get(0).inventory;
        ArrayList<Item> allItems = invPerso.itemLoop();
        Item spear = Item.createItems().get(0);



        charList.get(0).inventory.addItem(spear);
        charList.get(0).inventory.addItem(spear);
        charList.get(0).inventory.showInventory();
        charList.get(0).inventory.checkWeight();
    }
}


