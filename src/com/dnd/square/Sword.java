package com.dnd.square;

import com.dnd.character.Adventurer;

import java.util.Random;

public class Sword extends Equipment {
    Random random = new Random();
    private int damage;

    public Sword(int damage) {
        super("Sword", "warrior");
        this.damage = 3 + random.nextInt(7);
    }

    public int getDamage() {
        return damage;
    }
}
