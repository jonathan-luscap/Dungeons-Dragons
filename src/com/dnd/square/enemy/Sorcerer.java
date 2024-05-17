package com.dnd.square.enemy;

import com.dnd.equipment.defensive.SmokeBomb;
import com.dnd.equipment.offensive.Flash;

import java.util.Random;

public class Sorcerer extends Enemy {
    Random random = new Random();

    public Sorcerer() {
        super(PersonaType.sorcier, new Flash(), new SmokeBomb());
        this.life =  3 + random.nextInt(4);
    }
}
