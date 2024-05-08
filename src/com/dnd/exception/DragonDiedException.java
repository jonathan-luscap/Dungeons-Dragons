package com.dnd.exception;

import com.dnd.character.Player;

public class DragonDiedException extends Exception{
    private Player killer = null;

    public DragonDiedException(Player player) {
        killer = player;
    }
    public Player getPlayer() {
        return killer;
    }
}
