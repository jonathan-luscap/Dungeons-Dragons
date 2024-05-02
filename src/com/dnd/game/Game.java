package com.dnd.game;

import com.dnd.character.Adventurer;
import com.dnd.exception.StopGameException;
import com.dnd.menu.ExitMenu;


import java.util.ArrayList;
import java.util.Random;

public class Game {
    public boolean play(ArrayList<Adventurer> players) throws StopGameException {
        boolean finish = false;
        boolean continu = true;
        Random random = new Random();
        while (!finish)
        {
            for (Adventurer player : players) {
                ExitMenu exitMenu = new ExitMenu();
                int dieRoll = random.nextInt(6) + 1;
                finish = newPosition(player, dieRoll);
                if (finish)
                {
                    exitMenu.displayChoices();
                    exitMenu.handleUserChoice(exitMenu.getIntResponse());
                    break;
                }
            }
        }
        return continu;
    }
    private boolean newPosition(Adventurer player, int die)
    {
        boolean finish = false;
        System.out.println("\n" + player.getName() + " est sur la case " + player.getPosition() + ".");
        System.out.println(player.getName() + " lance le dé et fait...\n\n\n\n");
        if (player.getPosition() + die == 64) {
            player.setPosition(player.getPosition() + die);
            finish = true;
        } else if (player.getPosition() + die > 64) {
            player.setPosition(128 - player.getPosition() - die);
            System.out.println("Rebond sur la case arrivée...\n\n\n\n");
        } else {
            player.setPosition(player.getPosition() + die);
        }
        System.out.println("Il fait " + die + " et avance donc jusqu'à la case " + player.getPosition() + ".");
        return finish;
    }
}
