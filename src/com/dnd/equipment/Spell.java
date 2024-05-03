package com.dnd.equipment;

public class Spell extends OffensiveEquipment{
    @Override
    public void attack() {

    }

    public Spell() {
        super("Eclair", 3, "wizard");
    }

    @Override
    public String toString() {
        return "Spell équipement offensif\n\t"
                + "type : " + this.getType() + "\n\t"
                + "niveau d'attaque : " + this.getAttack();
    }
}
