package com.dnd.dice;

import java.util.Random;

public class D8 implements Dice{
    Random random = new Random();
    @Override
    public int roll() {
        return random.nextInt(8) + 1;
    }
}
