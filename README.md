RPG Java Console Game

Un petit jeu de rôle (RPG) en console développé en Java, avec système de combat, inventaire, loot et progression de personnage.

**Fonctionnalités** : 

- Création de personnage : Un joueur unique avec nom, points de vie, dégâts, expérience et niveau.

- Combat au tour par tour :
    Choix d’attaques : lance, arc, poings.
    Système de coup critique avec chance aléatoire.
    Gestion des points de vie des monstres et du joueur.
    Monstres variés : Squelette, Zombie, Dragon avec points de vie, dégâts...

- Système de loot : Chaque monstre peut dropper des objets différents (os, or, viande, gemme…).

- Inventaire : Gestion des objets du joueur, affichage et utilisation (ex. potions de soins).

- Idle / Exploration : Le joueur peut choisir d’avancer (avec chance d’ennemi), consulter son inventaire ou sauvegarder.

- Progression du personnage : Gain d’expérience et montée de niveau automatique.


** Objectifs du projet**

- Pratiquer la programmation orientée objet (OOP) en Java.

- Créer un système de combat simple mais modulable.

- Mettre en place un système de loot et inventaire fonctionnel.

- Préparer une base pour ajouter des fonctionnalités futures (sauvegarde, nouvelles classes d’objets, monstres, etc.).

**Technologies utilisées**

- Java 21

- Console / Terminal pour l’affichage

- Collections Java (List, ArrayList)

- Scanner pour la saisie utilisateur

 **Organisation du projet**

- Main.java : point d’entrée du programme, gestion des combats et idle.

- CharacterSheet.java : classe pour le joueur (stats, inventaire, attaque, gain de niveau).

- Monster.java : classe pour les ennemis, points de vie, dégâts et loot.

- Item.java : classe des objets utilisables par le joueur.

- Encounter.java : gestion des combats, tours joueur/ennemi et loot.

- Inventory.java : gestion de l’inventaire et affichage.

**Améliorations prévues**

- Système de sauvegarde (fichier JSON / TXT / database).

- Ajout de plus de monstres et items.

- Système simple de missions ou quêtes.

- Amélioration de l’interface.
