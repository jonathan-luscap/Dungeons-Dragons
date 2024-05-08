package com.dnd.exception;

import com.dnd.character.Player;

public class DragonPeaceException extends Exception{
    private Player peacer = null;

    public DragonPeaceException(Player player) {
        this.peacer = player;
    }
    public Player getPlayer() {
        return peacer;
    }
}
