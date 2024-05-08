package com.dnd.interact;

import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.offensive.OffensiveEquipment;

public class MagicalGemDisplayer implements Displayer {
    @Override
    public void find(String playerName, String equipmentName, int power) {

    }

    @Override
    public void find(String playerName, String enemyType, int life, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {

    }

    @Override
    public void find(String playerName, String type) {

    }

    @Override
    public void find(String name) {
        System.out.println(name + " trouve une pierre étrange qui dégage de la lumière...");
        System.out.println("Une fois certis sur son arme la lumiere devient plus intense...");
    }

    @Override
    public void find(String playerName, int life, int attack, int defense) {

    }

    public void greaterWeapon(String type, int damage) {
        System.out.println("Son " + type + " a maintenant " + damage + " de niveau d'attaque !");
        System.out.println("Retour au combat !");
    }
}
