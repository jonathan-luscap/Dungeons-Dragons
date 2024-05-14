package com.dnd.square;

import com.dnd.character.Player;
import com.dnd.dice.D2;
import com.dnd.dice.D6;
import com.dnd.exception.PlayerDiedException;
import com.dnd.interact.SurpriseDisplayer;

public class Surprise implements Square{

    D2 d2 = new D2();
    D6 d6 = new D6();
    public int squarePower;
    public int sens;
    public Surprise() {
        this.sens =  (int) Math.pow(-1, d2.roll());
        this.squarePower = d6.roll() * sens;
    }

    @Override
    public void interact(Player player) throws PlayerDiedException {
        SurpriseDisplayer surpriseDisplayer = new SurpriseDisplayer();
        surpriseDisplayer.find(player.getName());
        int newPosition = player.getPosition() + squarePower;
        if (newPosition > gameBoard.toArray().length - 1) {
            newPosition = gameBoard.toArray().length * 2 - newPosition;
            System.out.println("Rebond sur la case arrivée...\n\n\n");
        }
        surpriseDisplayer.shift(newPosition);
        player.setPosition(newPosition);
    }

    @Override
    public String toString() {
        if (squarePower < 0){
            return "surprise : " + -squarePower + " case(s) en arrière.";
        } else {
            return "surprise : " + squarePower + " case(s) en avant.";
        }
    }
}
