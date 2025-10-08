import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class Encounter {

    // Scanner pour les choix du joueur
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
        this.bag = items.get(3);
        this.healthPotion = items.get(4);

        // Début du combat au tour du joueur
        this.playerTurn = true;
        this.encounterOver = false;
        this.fight = true; // tu peux randomiser si tu veux un combat aléatoire
    }

    // Combat
    public String combat() {
        while (!player.isDead() && !enemy.isDead()) {
            System.out.println("Choisis ton attaque : 1 : spear , 2 : bow ou 3 : fist");
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
                    default:
                        System.out.println("Choix invalide !");
                }
                playerTurn = false; // Passage au tour ennemi
            } else {
                enemy.attack(player, enemy.damage);
                playerTurn = true; // Retour au joueur
            }
        }

        // Vérification fin du combat
        if (player.isDead()) {
            return "Défaite";
        } else {
            // AJOUTER L'XP AU JOUEUR
            player.xp += enemy.xp;

            // Augmenter le niveau si besoin
            player.gainLevel();

            return "Victoire ! \nYou've earned " + enemy.xp + " xp !";
        }
    }

}
