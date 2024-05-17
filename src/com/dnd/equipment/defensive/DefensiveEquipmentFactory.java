package com.dnd.equipment.defensive;

import com.dnd.character.Persona;
import com.dnd.exception.TypeMismatchException;

public class DefensiveEquipmentFactory {
    public static DefensiveEquipment equip(Persona.PersonaType playerType) throws TypeMismatchException {
        switch (playerType) {
            case guerrier -> {
                return new WoodShield(Persona.PersonaType.guerrier);
            }
            case sorcier -> {
                return new SmokeBomb(Persona.PersonaType.sorcier);
            }
            default -> throw new TypeMismatchException();
        }
    }
}
