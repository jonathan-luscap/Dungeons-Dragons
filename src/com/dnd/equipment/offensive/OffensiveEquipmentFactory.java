package com.dnd.equipment.offensive;

import com.dnd.character.Persona;
import com.dnd.exception.TypeMismatchException;

public class OffensiveEquipmentFactory {
    public static OffensiveEquipment equip(Persona.PersonaType playerType) throws TypeMismatchException {
        switch (playerType) {
            case guerrier -> {
                return new Sword(Persona.PersonaType.guerrier);
            }
            case sorcier -> {
                return new Flash(Persona.PersonaType.sorcier);
            }
            default -> throw new TypeMismatchException();
        }
    }
}
