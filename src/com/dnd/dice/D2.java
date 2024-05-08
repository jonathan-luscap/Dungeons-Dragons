package com.dnd.dice;

import java.util.Random;

public class D2 implements Dice {
    Random random = new Random();

    @Override
    public int roll() {
        return 0;
    }

    @Override
    public boolean binary() {
        return random.nextBoolean();
    }
}
