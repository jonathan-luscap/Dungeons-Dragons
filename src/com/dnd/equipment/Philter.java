package com.dnd.equipment;

public class Philter extends DefensiveEquipment {
    @Override
    public void parry() {

    }

    public Philter() {
        super("Fumigène", 5, "wizard");
    }

    @Override
    public String toString() {
        return "Philter équipement défensif\n\t"
                + "type : " + this.getType() + "\n\t"
                + "niveau d'attaque : " + this.getDefense();
    }
}
