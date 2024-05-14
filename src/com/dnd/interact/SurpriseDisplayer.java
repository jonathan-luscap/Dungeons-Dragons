package com.dnd.interact;

import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.offensive.OffensiveEquipment;

public class SurpriseDisplayer implements Displayer{
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
        System.out.print("Quelque chose a bougé derrière un buisson...");
        mainMenu.pause(2000);
        System.out.println(name + " est sur ces gardes...");
    }

    @Override
    public void find(String playerName, int life, int attack, int defense) {

    }

    public void shift(int newPosition) {
        System.out.println("Il tombe dans un trou et atterit à le case n°" + newPosition + ".");
    }
}
