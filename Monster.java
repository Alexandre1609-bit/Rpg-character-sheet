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
    boolean dead;
    List<Item> lootTable;
    public static ArrayList<Monster> Bestiary = new ArrayList();


    public Monster(String name, int ID, String comp, int health, int damage, int xp, boolean dead, List<Item> lootTable) {
        this.name = name;
        this.ID = ID;
        this.attack = comp;
        this.health = health;
        this.damage = damage;
        this.xp = xp;
        this.dead = dead;
        this.lootTable = lootTable;
    }

    public Monster(boolean dead) {

    }

    public static void initBestiary() {
        List<Item> SkeletonLoot = List.of(new Item("Bone", 0), new Item("Gold", 0));
        List<Item> ZombieLoot = List.of(new Item("Rotten flesh", 0), new Item("Gold", 0));
        List<Item> DragonLoot = List.of(new Item("Rare gem", 0), new Item("Gold", 0));


        createMonster(new Monster("Skeleton", 1, "bite", 50, 5, 500, false, SkeletonLoot));
        createMonster(new Monster("Zombie", 2, "claw", 40, 4, 500, false, ZombieLoot));
        createMonster(new Monster("Dragon", 3, "fireball", 80, 10, 15, false, DragonLoot));
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
        return name + " (Attack: " + attack + ", Damage: " + damage + ", XP: " + xp + "rajouter le drop)";
    }

    //attaque
    public void attack(CharacterSheet target, int damage) {
        System.out.println(this.name + " utilise " + this.attack + " !");
        if (Math.random() <= 0.1) {
            target.health -= this.damage * 1.5;
        } else {
            target.health -= this.damage;
        }
        if (target.health <= 0) {
            target.dead = true;
            System.out.println(target.name + " is dead");
        } else {
            System.out.println("The remaining life of " + target.name + " is " + target.health);
        }
    }

    public void dropLoot(CharacterSheet player) {
      Collections.shuffle(this.lootTable);
      Item rdmItem = this.lootTable.get(0);
      if (Math.random() < 0.5) {
          System.out.println("There is nothing to loot from this monster.");
      } else {
      player.inventory.addItem(rdmItem);
          System.out.println("You found " + rdmItem + " !");
        }
    }
}

