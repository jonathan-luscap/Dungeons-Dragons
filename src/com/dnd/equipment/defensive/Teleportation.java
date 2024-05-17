package com.dnd.equipment.defensive;

import com.dnd.character.Persona;

public class Teleportation extends DefensiveEquipment{
    public Teleportation() {
        super("Téléportation", Persona.PersonaType.sorcier);
        this.defense = 6 + random.nextInt(8);
    }
}
