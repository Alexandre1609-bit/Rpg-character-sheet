import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class Encounter {

    // Scanner
    private Scanner scanner = new Scanner(System.in);

    // Attributs de l'encounter
    CharacterSheet player;
    Monster enemy;
    boolean playerTurn;
    boolean encounterOver;
    boolean fight;

    // Items utilisés dans le combat
    Item spear;
    Item bow;
    Item fist;
    Item bag;
    Item healthPotion;

    // Référence au GameState
    Main.GameState state;

    // Constructor
    public Encounter(CharacterSheet player, Main.GameState state) {
        this.state = state;
        this.player = player;

        // Initialisation du monstre (aléatoire depuis le bestiary)
        this.enemy = Monster.rdmz();

        // Initialisation des items depuis le GameState
        List<Item> items = state.items;
        this.spear = items.get(0);
        this.bow = items.get(1);
        this.fist = items.get(2);
        this.healthPotion = items.get(3);

        // Début du combat au tour du joueur
        this.playerTurn = true;
        this.encounterOver = false;
        this.fight = true; // randomiser un combat aléatoire
    }

    // Combat
    public String combat() {
        while (!player.isDead() && !enemy.isDead()) {
            System.out.println("Choose your attack : 1 : spear , 2 : bow, 3 : fist, 4 : health potion");
            int choice = scanner.nextInt();

            if (playerTurn) {
                switch (choice) {
                    case 1:
                        player.attack(enemy, spear.damage, spear.itemName);
                        break;
                    case 2:
                        player.attack(enemy, bow.damage, bow.itemName);
                        break;
                    case 3:
                        player.attack(enemy, fist.damage, fist.itemName);
                        break;
                    case 4 :
                        if (player.health == player.maxHealth) {
                            System.out.println("You are already at maximum health");
                        } else {
                            player.health += healthPotion.damage;
                            if (player.health > player.maxHealth) player.health = player.maxHealth;
                            System.out.println("You used a health potion! Current HP: " + player.health);
                        }
                        break;
                    default:
                        System.out.println("Invalide choice !");
                }
                playerTurn = false; // Passage au tour ennemi
            } else {
                enemy.attack(player, enemy.damage);
                playerTurn = true; // Retour au joueur
            }
        }

        // Vérification fin du combat
        if (player.isDead()) {
            return "Defeat";
        } else {
            // AJOUTER L'XP AU JOUEUR
            player.xp += enemy.xp;

            // Augmenter le niveau si besoin
            player.gainLevel();

            // Afficher le loot
            enemy.dropLoot(player);

            return "Victory ! \nYou've earned " + enemy.xp + " xp !";
        }
    }

}
