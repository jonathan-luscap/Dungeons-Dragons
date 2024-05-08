package com.dnd.square;

import com.dnd.character.Player;
import com.dnd.exception.PlayerDiedException;

public class Surprise implements Square{

    @Override
    public String toString() {
        return "Surprise{}";
    }

    @Override
    public void interact(Player player) throws PlayerDiedException {
    }
}
