package com.dnd.equipment.offensive;

import com.dnd.character.Persona;

public class Mace extends OffensiveEquipment{

    public Mace() {
        super(OffensiveEquipmentType.MACE, Persona.PersonaType.WARRIOR);
        this.damage = 6 + random.nextInt(8);
    }

    public Mace(int damage) {
        super(damage);
        this.type = OffensiveEquipmentType.MACE;
        this.playerType = Persona.PersonaType.WARRIOR;
    }
}
