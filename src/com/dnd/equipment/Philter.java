package com.dnd.equipment;

public class Philter extends DefensiveEquipment {
    @Override
    public void parry() {

    }

    public Philter() {
        super();
        this.setDefense(8);
        this.setType("wizard");
    }

    @Override
    public String toString() {
        return "Philter équipement défensif\n\t"
                + "type : " + this.getType() + "\n\t"
                + "niveau d'attaque : " + this.getDefense();
    }
}
