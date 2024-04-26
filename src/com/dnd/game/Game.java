package com.dnd.game;

import com.dnd.character.Character;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    public void play(ArrayList<Character> players)
    {
        boolean finish = false;
        Random random = new Random();
        while (!finish)
        {
            for (Character player : players) {
                int dieRoll = random.nextInt(6) + 1;
                System.out.println("\n" + player.getName() + " est sur la case " + player.getPosition() + ".");
                System.out.print(player.getName() + " joue.");
                System.out.println(" Il fait " + dieRoll + " et avance donc jusqu'à la case " + (player.getPosition() + dieRoll) + ".\n");
                if (player.getPosition() + dieRoll == 64) {
                    finish = true;
                    System.out.println(player.getName() + " a remporté la partie !");
                } else if (player.getPosition() + dieRoll > 64) {
                    player.setPosition(128 - player.getPosition() - dieRoll);
                } else {
                    player.setPosition(player.getPosition() + dieRoll);
                }
            }
        }
    }
}
