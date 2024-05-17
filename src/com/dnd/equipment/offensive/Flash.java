package com.dnd.equipment.offensive;

import com.dnd.character.Persona;

public class Flash extends OffensiveEquipment {

    public Flash(Persona.PersonaType playerType) {
        super("Eclair", playerType);
        this.damage = 2;
    }
    public Flash() {
        super("Eclair", Persona.PersonaType.sorcier);
        this.damage = 2 + random.nextInt(4);
    }
}
