package com.dnd.dice;

public class D1 implements Dice {
    @Override
    public int  roll(){
        return 1;
    }

    @Override
    public boolean binary() {
        return false;
    }
}
