package com.dnd.square;

import com.dnd.character.Persona;
import com.dnd.character.Player;
import com.dnd.exception.PlayerDiedException;
import com.dnd.interact.EmptyDisplayer;

public class Empty implements Square {
    @Override
    public String toString() {
        return "Vide";
    }

    @Override
    public void interact(Player player) {
        EmptyDisplayer emptyDisplayer = new EmptyDisplayer();
        emptyDisplayer.find(player.getName());
    }
}
