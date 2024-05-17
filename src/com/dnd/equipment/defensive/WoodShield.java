package com.dnd.equipment.defensive;

import com.dnd.character.Persona;

import java.util.Random;

public class WoodShield extends DefensiveEquipment {

    public WoodShield(Persona.PersonaType playerType) {
        super("Bouclier de bois", playerType);
        this.defense = 3;
    }
    public WoodShield() {
        super("Bouclier de bois", Persona.PersonaType.guerrier);
        this.defense = 2 + random.nextInt( 4);
    }
}
