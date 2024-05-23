package com.dnd.equipment.defensive;

import com.dnd.character.Persona;

public class IronShield extends DefensiveEquipment{
    public IronShield() {
        super(DefensiveEquipmentType.IRONSHIELD, Persona.PersonaType.WARRIOR);
        this.defense = 5 + random.nextInt(3);
    }

    public IronShield(int defense) {
        super(defense);
        this.type = DefensiveEquipmentType.IRONSHIELD;
        this.playerType = Persona.PersonaType.WARRIOR;
    }
}
