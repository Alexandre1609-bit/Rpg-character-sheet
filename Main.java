import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Scanner
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Création du joueur
        CharacterSheet player = CharacterSheet.Character().get(0);
        idle(player);

    }

    public static class GameState {
        List<CharacterSheet> charList;
        List<Item> items;
        Inventory playerInventory;
        ArrayList<Monster> bestiary;

        public GameState(List<CharacterSheet> charList, List<Item> items, Inventory inv, ArrayList<Monster> bestiary) {
            this.charList = charList;
            this.items = items;
            this.playerInventory = inv;
            this.bestiary = bestiary;
        }
    }

    public static GameState InitializeGame(CharacterSheet player) {
        List<CharacterSheet> charList = new ArrayList<>();
        charList.add(player);
        List<Item> items = Item.createItems();
        Inventory invPerso = player.inventory;
        Monster.initBestiary();
        return new GameState(charList, items, invPerso, Monster.Bestiary);
    }

    public static boolean idle(CharacterSheet player) {
        GameState state = Main.InitializeGame(player);
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;
        while  (playing && !player.isDead()) {
            System.out.println("Choose an action: 1- Move forward, 2- Inventory, 3- Save, 4- Leave");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You choose to move forward, who knows what you'll come across? ");
                    if (Math.random() <= 0.3) {
                        System.out.println("Prepare to fight !");
                        StartBattle(player);
                    }
                    break;
                case 2:
                    player.inventory.showInventory();
                    break;
                case 3:
                    System.out.println("Comming soon !");
                    break;
                case 4 :
                    System.out.println("see you soon !");
                    playing = false;
                    break;

            }

        }
        return playing;
    }

    public static void StartBattle(CharacterSheet player) {
        // GameState
        GameState state = Main.InitializeGame(player);

        // Initialiser encounter
        Encounter encounter = new Encounter(player, state);

        // Lancer le combat
        String result = encounter.combat();

        // Afficher le résultat et les infos du joueur
        System.out.println(result);
        player.getLvlInf();


    }
}


// gestion de loot et d'inventaire
// ajouter système de sauvegarde (.txt, Gson ??)
// se renseigner sur le fonctionnement des bases de données pour sauvegarde (veille technolique)
// ajouter système de couleur pour une meilleure lisibiilité (joueur, ennemie, CC...)