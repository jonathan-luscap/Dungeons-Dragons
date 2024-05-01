package com.dnd.character;

import java.util.ArrayList;

public abstract class Adventurer {
    private String name;
    private int position = 0;

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
