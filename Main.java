import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Création du joueur une seule fois
        CharacterSheet player = CharacterSheet.Character().get(0);

        // Lancer plusieurs combats si tu veux
        StartBattle(player);
        StartBattle(player);
        // player conservera son XP et son niveau
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

    public static void StartBattle(CharacterSheet player) {
        // GameState
        GameState state = Main.InitializeGame(player);

        // Initialiser encounter en passant le joueur et le state
        Encounter encounter = new Encounter(player, state);

        // Lancer le combat
        String result = encounter.combat();

        // Afficher le résultat et les infos du joueur
        System.out.println(result);
        player.getLvlInf();


    }
}


// gestion de loot et d'inventaire
// ajouter système de sauvegarde (.txt, Gson ??) se renseigner sur le fonctionnement des bases de données pour sauvegarde (veille technolique)