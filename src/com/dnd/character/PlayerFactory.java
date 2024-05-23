package com.dnd.character;

import com.dnd.exception.TypeMismatchException;

public class PlayerFactory {
    public Player createPlayer(Persona.PersonaType playerType) throws TypeMismatchException {
        switch (playerType){
            case WARRIOR -> {
                return new Warrior();
            }
            case WIZARD -> {
                return new Wizard();
            }
            default -> throw new TypeMismatchException();
        }
    }
}
