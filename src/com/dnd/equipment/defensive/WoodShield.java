package com.dnd.equipment.defensive;

import com.dnd.character.Persona;

public class WoodShield extends DefensiveEquipment {

    public WoodShield(Persona.PersonaType playerType) {
        super(DefensiveEquipmentType.WOODSHIELD, playerType);
        this.defense = 3;
    }
    public WoodShield() {
        super(DefensiveEquipmentType.WOODSHIELD, Persona.PersonaType.WARRIOR);
        this.defense = 2 + random.nextInt( 4);
    }

    public WoodShield(int defense) {
        super(defense);
        this.type = DefensiveEquipmentType.WOODSHIELD;
        this.playerType = Persona.PersonaType.WARRIOR;
    }
}
