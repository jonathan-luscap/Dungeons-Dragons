package com.dnd.exception;

import com.dnd.character.Player;

public class DragonDiedException extends Exception implements WinnerException{
    private Player killer = null;

    public DragonDiedException(Player player) {
        killer = player;
    }
    @Override
    public Player getPlayer() {
        return killer;
    }
}
