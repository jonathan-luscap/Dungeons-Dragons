package com.dnd.square;

import java.util.Random;

public class Flash extends Equipment {
    Random random = new Random();
    private int damage;

    public Flash(int damage) {
        super("Flash", "wizard");
        this.damage = 2 + random.nextInt(4);
    }

    public int getDamage() {
        return damage;
    }
}
