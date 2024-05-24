package com.dnd.equipment;

import com.dnd.character.Persona;
import com.dnd.square.Openable;

public abstract class Equipment implements Openable {
    private int position;

    protected Persona.PersonaType playerType;

    public Equipment() {
        this.playerType = null;
    }

    public Equipment(Persona.PersonaType playerType) {
        this.playerType = playerType;
    }

    public Persona.PersonaType getPlayerType() {
        return playerType;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
