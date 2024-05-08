package com.dnd.exception;

import com.dnd.character.Persona;
import com.dnd.character.Player;

public class PlayerDiedException extends Exception{
    private Player playerDead = null;
    public PlayerDiedException(Player player) {
        playerDead = player;
    }
    public Player getPlayerDead() {
        return playerDead;
    }
}
