package com.dnd.interact;

import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.offensive.OffensiveEquipment;

public class PeaceDisplayer extends Displayer{

    public void find(String name) {
        System.out.println("Le dragon et " + name + " se regardent dans les yeux...");
        System.out.println("...ils se relachent et chacun rengaine...");
    }
}
