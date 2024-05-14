package com.dnd.interact;

import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.offensive.OffensiveEquipment;

public class PlayerDiedDisplayer extends Displayer {

    public void find(String name) {
        System.out.println(name + " est mort en combattant valeureusement et malheureusement !!!");
    }
}
