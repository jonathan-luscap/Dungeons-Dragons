package com.dnd.interact;

import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.offensive.OffensiveEquipment;

public class EmptyDisplayer extends Displayer{

    public void find(String name) {
        System.out.println("\n\t" + name + " est tombé sur une case vide...\n");
    }
}
