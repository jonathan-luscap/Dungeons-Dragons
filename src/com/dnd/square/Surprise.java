package com.dnd.square;

import com.dnd.character.Player;
import com.dnd.interact.SurpriseDisplayer;
import com.dnd.dice.D2;
import com.dnd.dice.D6;

import java.util.Random;

import static com.dnd.game.Game.getCapacity;

public class Surprise implements Square{
    Random random = new Random();
    SurpriseDisplayer surpriseDisplayer = new SurpriseDisplayer();
    D6 d6 = new D6();
    D2 d2 = new D2();
    private int squarePower;
    private boolean squareSign;

    public Surprise() {
        this.squareSign = d2.binary();
        if (this.squareSign) {
            this.squarePower = d6.roll() * -1;
        } else {
            this.squarePower = d6.roll();
        }
    }

    @Override
    public String toString() {
        return "Surprise : " + squarePower;
    }

    @Override
    public void interact(Player player) {
        int newPosition = 0;
        surpriseDisplayer.find(player.getName());
        if (player.getPosition() + this.squarePower >= getCapacity()) {
            newPosition = getCapacity() * 2 - player.getPosition() - squarePower - 1;
        } else newPosition = Math.max(player.getPosition() + this.squarePower, 0);
        player.setPosition(newPosition);
        surpriseDisplayer.shift(player.getName(), newPosition);
    }
}
