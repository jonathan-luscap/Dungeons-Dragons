package com.dnd.equipment.offensive;

import com.dnd.character.Persona;

public class Flash extends OffensiveEquipment {

    public Flash(Persona.PersonaType playerType) {
        super(OffensiveEquipmentType.FLASH, playerType);
        this.damage = 2;
    }
    public Flash() {
        super(OffensiveEquipmentType.FLASH, Persona.PersonaType.WIZARD);
        this.damage = 2 + random.nextInt(4);
    }

    public Flash(int damage) {
        super(damage);
        this.type = OffensiveEquipmentType.FLASH;
        this.playerType = Persona.PersonaType.WIZARD;
    }

    public static class OffensiveEquipmentDaoImplementation {
    }
}
