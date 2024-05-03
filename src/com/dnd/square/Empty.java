package com.dnd.square;

import com.dnd.character.Adventurer;

public class Empty implements Square {
    @Override
    public void interact(Adventurer player) {}

    @Override
    public String toString() {
        return "Empty{}";
    }
}
