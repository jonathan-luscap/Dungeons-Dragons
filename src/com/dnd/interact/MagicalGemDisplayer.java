package com.dnd.interact;

import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.offensive.OffensiveEquipment;

public class MagicalGemDisplayer extends Displayer {

    public void find(String name) {
        System.out.println(name + " trouve une pierre étrange qui dégage de la lumière...");
        mainMenu.pause(2000);
        System.out.println("Une fois certis sur son arme la lumiere devient plus intense...");
    }

    public void greaterWeapon(String type, int damage) {
        System.out.println("Son " + type + " a maintenant " + damage + " de niveau d'attaque !");
        System.out.println("Retour au combat !\n\n");
        mainMenu.pause(1000);
    }
}
