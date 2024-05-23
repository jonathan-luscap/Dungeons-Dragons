package com.dnd.equipment.defensive;

import com.dnd.character.Persona;

import java.util.Random;

public class SmokeBomb extends DefensiveEquipment {

    public SmokeBomb(Persona.PersonaType playerType) {
        super(DefensiveEquipmentType.SMOKEBOMB, playerType);
        this.defense = 6;
    }
    public SmokeBomb() {
        super(DefensiveEquipmentType.SMOKEBOMB, Persona.PersonaType.WIZARD);
        this.defense = 3 + random.nextInt(7);
    }

    public SmokeBomb(int defense) {
        super(defense);
        this.type = DefensiveEquipmentType.SMOKEBOMB;
        this.playerType = Persona.PersonaType.WIZARD;
    }
}
