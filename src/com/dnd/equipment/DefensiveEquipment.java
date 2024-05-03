package com.dnd.equipment;

public abstract class DefensiveEquipment {

    private String name;
    private int defense;
    private String type;

    public abstract void parry();

    public DefensiveEquipment() {
        this.name = "";
        this.defense = 0;
        this.type = "";
    }

    public DefensiveEquipment(String name, int defense, String type) {
        this.name = name;
        this.defense = defense;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
