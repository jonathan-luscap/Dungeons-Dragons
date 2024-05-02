package com.dnd.equipment;

public abstract class OffensiveEquipment {

    private int attack;
    private String type;

    public abstract void attack();

    public OffensiveEquipment() {
        this.attack = 0;
        this.type = "";
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
