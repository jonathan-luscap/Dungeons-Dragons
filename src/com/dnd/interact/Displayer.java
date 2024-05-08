package com.dnd.interact;

import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.offensive.OffensiveEquipment;
import com.dnd.menu.MainMenu;

public interface Displayer {
    MainMenu mainMenu = new MainMenu();

    void find(String playerName, String equipmentName, int power);

    void find(String playerName, String enemyType, int life, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment);

    void find(String playerName, String type);

    void find(String name);

    void find(String playerName, int life, int attack, int defense);
}
