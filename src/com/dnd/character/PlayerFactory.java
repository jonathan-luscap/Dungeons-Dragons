package com.dnd.character;

import com.dnd.exception.TypeMismatchException;
import com.dnd.square.enemy.Sorcerer;

public class PlayerFactory {
    public Player createPlayer(Persona.PersonaType playerType) throws TypeMismatchException {
        switch (playerType){
            case guerrier -> {
                return new Warrior();
            }
            case sorcier -> {
                return new Wizard();
            }
            default -> throw new TypeMismatchException();
        }
    }
}
