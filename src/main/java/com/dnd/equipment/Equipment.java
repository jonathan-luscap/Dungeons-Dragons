package com.dnd.equipment;

import com.dnd.character.Persona;
import com.dnd.square.Square;

public abstract class Equipment implements Square {
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
}
