package com.dnd.equipment.offensive;

import com.dnd.character.Persona;

public class OffensiveEquipmentFactory {
    public static OffensiveEquipment equip(Persona.PersonaType playerType) {
        switch (playerType) {
            case WARRIOR -> {
                return new Sword(Persona.PersonaType.WARRIOR);
            }
            case WIZARD -> {
                return new Flash(Persona.PersonaType.WIZARD);
            }
        }
        return null;
    }
}
