package com.dnd.interact;

import com.dnd.character.Persona;
import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.offensive.OffensiveEquipment;

public class EnemyDisplayer extends Displayer{

    public void find(String playerName, String type, int life, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {
        System.out.println(playerName + " tombe sur un " + type + ".\n");
        mainMenu.pause(1000);
        System.out.println("\tNombre de vies : " + life +
                offensiveEquipment + defensiveEquipment + "\n");
    }

    public void findDeadbody(String playerName, String type) {
        System.out.println(playerName + " tombe sur un cadavre de " + type + ".");
        mainMenu.pause(500);
    }
    public void enemyAttack(String type) {
        System.out.println("\nLe " + type + " dégaine en premier et attaque...");
        mainMenu.pause(500);
    }

    public void enemyMark(String name) {
        System.out.println("Il touche " + name + "...");
        mainMenu.pause(200);
    }

    public void damage(int damage) {
        System.out.println("...qui prend " + damage + " de dégats.");
        mainMenu.pause(1000);
    }

    public void enemyEscape(String type) {
        System.out.println("Le " + type +" s'enfuit à toute vitesse !");
        mainMenu.pause(500);
    }

    public void fail() {
        System.out.println("Son attaque échoue.");
        mainMenu.pause(500);
    }

    public void playerAttack(String name) {
        System.out.println("\n" + name + " dégaine en premier et attaque...");
        mainMenu.pause(500);
    }

    public void playerMark(String type) {
        System.out.println("Il touche le " + type + "...");
        mainMenu.pause(200);
    }

    public void enemyDied(String type) {
        System.out.println("Le " + type + " meurt.");
        mainMenu.pause(2000);
    }
}
