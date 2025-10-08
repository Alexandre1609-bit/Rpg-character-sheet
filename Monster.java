import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Monster {
    String name;
    int ID;
    String attack;
    int health;
    int damage;
    int xp;
    String loot;
    boolean dead;
    public static ArrayList<Monster> Bestiary = new ArrayList();

    public Monster(String name, int ID, String comp, int health, int damage, int xp, String loot, boolean dead) {
        this.name = name;
        this.ID = ID;
        this.attack = comp;
        this.health = health;
        this.damage = damage;
        this.xp = xp;
        this.loot = loot;
        this.dead = dead;
    }

    public Monster(boolean dead) {

    }

    public static void initBestiary() {
        createMonster(new Monster("Skeleton", 1, "bite", 50, 5, 500, "bone", false));
        createMonster(new Monster("Zombie", 2, "claw", 40, 4, 500, "rotten flesh", false));
        createMonster(new Monster("Dragon", 3, "fireball", 80, 10, 15, "Red skin", false));
    }

    public static List<Monster> createMonster(Monster newMst) {
        boolean exist = false;
        for (Monster monster : Bestiary) {
            if (monster.name.equals(newMst.name)) {
                return Bestiary;
            }
        }
        Bestiary.add(newMst);
        return Bestiary;
    }


    public ArrayList<Monster> mstLoop() {
        ArrayList<Monster> rtnMst = new ArrayList<>();
        for (Monster monster : Bestiary) {
            rtnMst.add(monster);
        }
        return rtnMst;
    }
    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public static Monster rdmz() {
        ArrayList<Monster> random = new ArrayList<>(Bestiary);
        Collections.shuffle(random);

        return random.get(0);
    }

    public String toString() {
        return name + " (Attack: " + attack + ", Damage: " + damage + ", XP: " + xp + ", Loot: " + loot + ")";
    }

    // Méthode d'attaque
    public void attack(CharacterSheet target, int damage) {
        System.out.println(this.name + " utilise " + this.attack + " !");
        target.health -= this.damage;
        if (target.health <= 0) {
            target.dead = true;
            System.out.println(target.name + " is dead");
        } else {
            System.out.println("The remaining life of " + target.name + " is " + target.health);
        }
    }

}
