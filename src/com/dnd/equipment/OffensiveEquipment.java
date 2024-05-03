package com.dnd.equipment;

public abstract class OffensiveEquipment {

    private String name;
    private int attack;
    private String type;

    public abstract void attack();

    public OffensiveEquipment() {
        this.name = "";
        this.attack = 0;
        this.type = "";
    }

    public OffensiveEquipment(String name, int attack, String type) {
        this.name = name;
        this.attack = attack;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
