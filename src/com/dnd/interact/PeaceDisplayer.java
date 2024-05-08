package com.dnd.interact;

import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.offensive.OffensiveEquipment;

public class PeaceDisplayer implements Displayer{
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
        System.out.println("Le dragon et " + name + " se regardent dans les yeux...");
        System.out.println("...ils se relachent et chacun rengaine...");
    }

    @Override
    public void find(String playerName, int life, int attack, int defense) {

    }
}
