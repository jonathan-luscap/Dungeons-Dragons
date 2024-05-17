package com.dnd.equipment.offensive;

import com.dnd.character.Persona;

import java.util.Random;

public class Fireball extends OffensiveEquipment{
    public Fireball() {
        super("Boule de feu", Persona.PersonaType.sorcier);
        this.damage = 5 + random.nextInt(3);
    }
}
