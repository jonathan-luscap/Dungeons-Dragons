package com.dnd.exception;

import com.dnd.character.Player;

public class DragonPeaceException extends Exception implements WinnerException{
    private Player peacer = null;

    public DragonPeaceException(Player player) {
        this.peacer = player;
    }
    @Override
    public Player getPlayer() {
        return peacer;
    }
}
