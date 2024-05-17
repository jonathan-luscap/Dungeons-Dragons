package com.dnd.square.enemy;

import com.dnd.equipment.defensive.WoodShield;
import com.dnd.equipment.offensive.Sword;

import java.util.Random;

public class Goblin extends Enemy{
    Random random = new Random();

    public Goblin() {
        super(PersonaType.guerrier, new Sword(), new WoodShield());
        this.life = 1 + random.nextInt(4);
    }
}
