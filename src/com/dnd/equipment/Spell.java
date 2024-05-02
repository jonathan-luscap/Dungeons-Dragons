package com.dnd.equipment;

public class Spell extends OffensiveEquipment{
    @Override
    public void attack() {

    }

    public Spell() {
        super();
        this.setAttack(3);
        this.setType("wizard");
    }

    @Override
    public String toString() {
        return "Spell équipement offensif\n\t"
                + "type : " + this.getType() + "\n\t"
                + "niveau d'attaque : " + this.getAttack();
    }
}
