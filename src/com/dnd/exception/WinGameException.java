package com.dnd.exception;

import com.dnd.character.Adventurer;

public class WinGameException extends Throwable {
    private Adventurer winner = null;
    public WinGameException(Adventurer player) {
        winner = player;
    }
    public Adventurer getwinner(){
        return this.winner;
    }
}
