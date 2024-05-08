package com.dnd.character;

import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.offensive.OffensiveEquipment;

public abstract class Persona {
    protected String name;
    protected int life;
    protected String type = "";
    protected OffensiveEquipment offensiveEquipment;
    protected DefensiveEquipment defensiveEquipment;

    public Persona() {
        this.name = null;
        this.life = 0;
        this.type = null;
        this.offensiveEquipment = null;
        this.defensiveEquipment = null;
    }

    public Persona(String type, int life, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {
        this.name = null;
        this.life = life;
        this.type = type;
        this.offensiveEquipment = offensiveEquipment;
        this.defensiveEquipment = defensiveEquipment;
    }

    public Persona(String type, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {
        this.name = null;
        this.life = 0;
        this.type = type;
        this.offensiveEquipment = offensiveEquipment;
        this.defensiveEquipment = defensiveEquipment;
    }

    //Persona getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public OffensiveEquipment getOffensiveEquipment() {
        return offensiveEquipment;
    }

    public void setOffensiveEquipment(OffensiveEquipment offensiveEquipment) {
        this.offensiveEquipment = offensiveEquipment;
    }

    public DefensiveEquipment getDefensiveEquipment() {
        return defensiveEquipment;
    }

    public void setDefensiveEquipment(DefensiveEquipment defensiveEquipment) {
        this.defensiveEquipment = defensiveEquipment;
    }

    public boolean testLife(){
        if (this.life > 0){
            return false;
        } else {
            return true;
        }
    }
}
