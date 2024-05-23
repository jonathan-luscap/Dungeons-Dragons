package com.dnd.equipment.offensive;

import com.dnd.character.Persona;

public class Fireball extends OffensiveEquipment{
    public Fireball() {
        super(OffensiveEquipmentType.FIREBALL, Persona.PersonaType.WIZARD);
        this.damage = 5 + random.nextInt(3);
    }

    public Fireball(int damage) {
        super(damage);
        this.type = OffensiveEquipmentType.FIREBALL;
        this.playerType = Persona.PersonaType.WIZARD;
    }
}
