package com.dnd.square;

import com.dnd.character.Player;
import com.dnd.interact.EmptyDisplayer;

public class Empty extends Square implements Openable {

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
