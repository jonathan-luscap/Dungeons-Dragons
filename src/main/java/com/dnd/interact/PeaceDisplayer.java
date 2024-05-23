package com.dnd.interact;

import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.offensive.OffensiveEquipment;

public class PeaceDisplayer extends Displayer{

    public void find(String name) {
        System.out.print("Le dragon et " + name + " se regardent dans les yeux...");
        mainMenu.pause(3000);
        System.out.println("\t...ils se relachent et chacun rengaine...");
    }
}
