package com.dnd.interact;

import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.offensive.OffensiveEquipment;

public class EquipmentDisplayer extends Displayer{

    public void find(String playerName, String equipmentType, int power) {
        System.out.println("\n" + playerName + " trouve un(e) " + equipmentType + " de niveau " + power + ".");
    }

    public void typeMatch() {
        System.out.println("Cet équipement peut être utilisé.");
    }

    public void betterOne(String oldEquipmentType, int oldEquipmentAttack,String newEquipmentType,  int newEquipmentAttack) {
        System.out.println("Il est de meilleure qualité que l'équipement actuelle.");
        System.out.println("Il échange un(e) " + oldEquipmentType + " de niveau " + oldEquipmentAttack + " contre un(e) " + newEquipmentType + " de niveau " + newEquipmentAttack + ".");
    }

    public void drop() {
        System.out.println("Il n'en vaut pas la peine.");
    }

    public void typeMismatch() {
        System.out.println("Impossible de l'utiliser !");
    }

    public void alreadyTaken() {
        System.out.println("On dirait qu'un objet manque ici...");
    }
}
