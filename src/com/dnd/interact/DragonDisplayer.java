package com.dnd.interact;

import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.offensive.OffensiveEquipment;

public class DragonDisplayer extends Displayer{

    public void find(String playerName, int life, int attack, int defense) {
        System.out.println(playerName + " tombe sur le dragon !!");
        mainMenu.pause(1000);
        System.out.println("\tNombre de vies : " + life + "\n\t" +
                "Niveau d'attaque : " + attack + "\n\t" +
                "Niveau de défense : " + defense);
    }

    public void dragonAttack() {
        System.out.print("Le dragon attaque...");
        mainMenu.pause(500);
    }

    public void dragonMark(String name) {
        System.out.println("Il touche " + name + ".");
        mainMenu.pause(200);
    }

    public void damage(int damage) {
        System.out.println("Il prend " + damage + " de dégats.");
        mainMenu.pause(1000);
    }

    public void fail() {
        System.out.println("Son attaque échoue.");
    }

    public void playerAttack(String name) {
        System.out.print(name + " attaque...");
        mainMenu.pause(500);
    }

    public void playerMark() {
        System.out.println("Il touche le dragon...");
        mainMenu.pause(200);
    }

    public void dragonDied() {
        System.out.println("Le dragon est mort....");
        mainMenu.pause(2000);
    }

    public void parade(String playerName,int newPosition) {
        System.out.println("Il rugit de fureur et renvoie " + playerName + " à la case n°" + newPosition + ".");
        mainMenu.pause(1000);
    }
}
