package com.dnd.equipment;

public class Weapon extends OffensiveEquipment{
    @Override
    public void attack() {

    }

    public Weapon() {
        super();
        this.setAttack(6);
        this.setType("warrior");
    }

    @Override
    public String toString() {
        return "Weapon équipement offensif\n\t"
                + "type : " + this.getType() + "\n\t"
                + "niveau d'attaque : " + this.getAttack();
    }
}
