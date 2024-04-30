package com.dnd.character;

import com.dnd.equipment.OffensiveEquipment;

public abstract class Character {
    private String name;
    private int position = 1;

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
