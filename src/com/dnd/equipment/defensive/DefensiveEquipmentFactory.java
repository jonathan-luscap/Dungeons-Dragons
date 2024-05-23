package com.dnd.equipment.defensive;

import com.dnd.character.Persona;

public class DefensiveEquipmentFactory {
    public static DefensiveEquipment equip(Persona.PersonaType playerType) {
        switch (playerType) {
            case WARRIOR -> {
                return new WoodShield(Persona.PersonaType.WARRIOR);
            }
            case WIZARD -> {
                return new SmokeBomb(Persona.PersonaType.WIZARD);
            }
        }
        return null;
    }
}
