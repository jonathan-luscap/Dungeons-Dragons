package com.dnd.equipment.offensive;

import com.dnd.character.Persona;

public class Sword extends OffensiveEquipment {

    public Sword(Persona.PersonaType playerType) {
        super("Epée",  playerType);
        this.damage = 5;
    }
    public Sword() {
        super("Epée",  Persona.PersonaType.guerrier);
        this.damage = 3 + random.nextInt(7);
    }
}
