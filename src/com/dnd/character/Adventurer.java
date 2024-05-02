package com.dnd.character;

import com.dnd.equipment.DefensiveEquipment;
import com.dnd.equipment.OffensiveEquipment;

import java.util.ArrayList;

public abstract class Adventurer {
    private String name;
    private int position;
    protected int life;
    protected String type = "";
    protected OffensiveEquipment offensiveEquipment;
    protected DefensiveEquipment defensiveEquipment;

    public Adventurer() {
        this.position = 0;
        this.name = "";
        this.life = 0;
        this.type = "";
        this.offensiveEquipment = null;
        this.defensiveEquipment = null;
    }

    //Character getters and setters
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPosition()
    {
        return position;
    }
    public void setPosition(int position)
    {
        this.position = position;
    }
}
