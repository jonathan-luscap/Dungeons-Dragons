package com.dnd.equipment.offensive;

import java.util.Random;

public class Fireball extends OffensiveEquipment{
    public Fireball() {
        super("Boule de feu", "sorcier blanc");
        this.damage = 5 + random.nextInt(3);
    }
}
