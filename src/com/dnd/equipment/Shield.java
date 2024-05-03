package com.dnd.equipment;

public class Shield extends DefensiveEquipment {
    @Override
    public void parry() {

    }

    public Shield() {
        super("Boublier de bois", 4, "warrior");
    }

    @Override
    public String toString() {
        return "Shield équipement défensif\n\t"
                + "type : " + this.getType() + "\n\t"
                + "niveau d'attaque : " + this.getDefense();
    }
}
