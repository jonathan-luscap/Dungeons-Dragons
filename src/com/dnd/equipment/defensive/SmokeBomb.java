package com.dnd.equipment.defensive;

import com.dnd.character.Persona;

import java.util.Random;

public class SmokeBomb extends DefensiveEquipment {
    Random random = new Random();

    public SmokeBomb(Persona.PersonaType playerType) {
        super("Fumigène", playerType);
        this.defense = 6;
    }
    public SmokeBomb() {
        super("Fumigène", Persona.PersonaType.sorcier);
        this.defense = 3 + random.nextInt(7);
    }
}
