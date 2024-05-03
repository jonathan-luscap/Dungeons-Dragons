package com.dnd.square;

import com.dnd.character.Adventurer;

public abstract class Equipment implements Square{
    protected String name;
    protected String type;

    public Equipment() {
        this.name = null;
        this.type = null;
    }

    public Equipment(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public void interact(Adventurer player) {}

    @Override
    public String toString() {
        return "Equipment{}";
    }

}
