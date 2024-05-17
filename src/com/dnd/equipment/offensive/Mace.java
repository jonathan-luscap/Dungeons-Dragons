package com.dnd.equipment.offensive;

import com.dnd.character.Persona;

public class Mace extends OffensiveEquipment{

    public Mace() {
        super("Masse", Persona.PersonaType.guerrier);
        this.damage = 6 + random.nextInt(8);
    }
}
