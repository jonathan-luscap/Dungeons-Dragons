package com.dnd.dice;

import java.util.Random;

public class D5 implements Dice {
    Random random = new Random();
    @Override
    public int roll() {
        return random.nextInt(5) + 1;
    }

    @Override
    public boolean binary() {
        return false;
    }
}