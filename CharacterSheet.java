import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharacterSheet {
    private Scanner scanner = new Scanner(System.in);

    String name;
    int health;
    int maxHealth;
    int damage;
    boolean dead;
    Inventory inventory;
    int xp;
    int level;

    // Instance statique pour garder le même joueur en mémoire
    private static CharacterSheet savedPlayer = null;

    // Constructeur
    public CharacterSheet(String name, int health, int maxHealth, int damage, boolean dead, int xp, int level) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.damage = damage;
        this.dead = dead;
        this.inventory = new Inventory(0);
        this.xp = xp;
        this.level = level;
    }

    // Méthode pour créer/récupérer le joueur
    public static List<CharacterSheet> Character() {
        List<CharacterSheet> charList = new ArrayList<>();

        // Si le joueur existe déjà, on le reprend
        if (savedPlayer != null) {
            charList.add(savedPlayer);
        } else {
            // sinon on le crée une seule fois
            savedPlayer = new CharacterSheet("Alex", 100, 100, 7, false, 0, 0);
            charList.add(savedPlayer);
        }

        return charList;
    }

    // === Getters / Setters ===
    public boolean isDead() { return dead; }
    public void setDead(boolean dead) { this.dead = dead; }

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }

    public int getDamage() { return damage; }
    public void setDamage(int damage) { this.damage = damage; }

    //Attaque
    public void attack(Monster target, int damage, String itemName) {
        System.out.println(this.name + " utilise " + itemName + " !");
        if (Math.random() <= 0.1) {
            System.out.println("Critical Hit !");
            target.health -= damage * 1.5;
        } else {
            target.health -= damage;
        }

        if (target.health <= 0) {
            target.dead = true;
            System.out.println(target.name + " is dead");
        } else {
            System.out.println("The remaining life of " + target.name + " is " + target.health);
        }
    }

    public String toString() {
        return name;
    }

    // Gestion des level
    public void gainLevel() {
        int base = 100;
        int xpNeeded = base + (this.level * 50);

        while (this.xp >= xpNeeded) {
            this.xp -= xpNeeded;
            this.level++;
            System.out.println("You've gained a level! You are now level " + this.level + "!");
            System.out.println("You can pick a new item!");

            xpNeeded = base + (this.level * 50);
        }
    }

    public void getLvlInf() {
        System.out.println("You are currently level " + this.level + " and have " + this.xp + " xp");
    }


}
