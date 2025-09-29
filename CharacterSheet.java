import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class CharacterSheet {
    String pseudo;
    String race;
    String classe;
    int maxWeight;
    int ID;
    int hp;
    int max_hp;
    int attack;
    int max_attack;
    int defense;
    int max_defense;
    int luck;
    int agility;
    Inventory inventory;

    public CharacterSheet(String pseudo, String race, String classe, int maxWeight, int ID, int hp, int max_hp, int attack, int max_attack, int defense, int max_defense, int luck, int agility) {
        this.pseudo = pseudo;
        this.race = race;
        this.classe = classe;
        this.maxWeight = maxWeight;
        this.ID = ID;
        this.hp = hp;
        this.max_hp = max_hp;
        this.attack = attack;
        this.max_attack = max_attack;
        this.defense = defense;
        this.max_defense = max_defense;
        this.luck = luck;
        this.agility = agility;
        this.inventory = new Inventory(ID);

    }

    public static List<CharacterSheet> createChar() {
        List<CharacterSheet> charList = new ArrayList<>();
        charList.add(new CharacterSheet("Ainz", "Undead", "Mage",  20, 100, 100, 5, 10, 2, 5, 5, 5,5));
        return charList;
    }

}
