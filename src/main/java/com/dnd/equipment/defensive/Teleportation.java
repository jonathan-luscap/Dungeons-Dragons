package com.dnd.equipment.defensive;

import com.dnd.character.Persona;

public class Teleportation extends DefensiveEquipment{
    public Teleportation() {
        super(DefensiveEquipmentType.TELEPORTATION, Persona.PersonaType.WIZARD);
        this.defense = 6 + random.nextInt(8);
    }

    public Teleportation(int defense) {
        super(defense);
        this.type = DefensiveEquipmentType.TELEPORTATION;
        this.playerType = Persona.PersonaType.WIZARD;
    }
}
