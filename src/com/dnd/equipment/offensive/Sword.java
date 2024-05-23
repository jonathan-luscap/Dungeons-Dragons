package com.dnd.equipment.offensive;

import com.dnd.character.Persona;

public class Sword extends OffensiveEquipment {

    public Sword(Persona.PersonaType playerType) {
        super(OffensiveEquipmentType.SWORD,  playerType);
        this.damage = 5;
    }
    public Sword() {
        super(OffensiveEquipmentType.SWORD, Persona.PersonaType.WARRIOR);
        this.damage = 3 + random.nextInt(7);
    }

    public Sword(int damage) {
        super(damage);
        this.type = OffensiveEquipmentType.SWORD;
        this.playerType = Persona.PersonaType.WARRIOR;
    }
}
