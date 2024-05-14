package com.dnd.dice;

import java.util.Random;

public class D2 implements Dice {
    Random random = new Random();

    public boolean binary() {
        return random.nextBoolean();
    }

    @Override
    public int roll() {
        return random.nextInt(2) + 1;
    }
}
