package com.dnd.game;

import com.dnd.character.Adventurer;
import com.dnd.exception.*;
import com.dnd.menu.ExitMenu;
import com.dnd.menu.MainMenu;
import com.dnd.menu.WinnerMenu;


import java.util.ArrayList;
import java.util.Random;

public class Game {
    public void gameLoop() throws StopGameException {
        while (true) {
            play(initiateGame());
        }
    }
    private ArrayList<Adventurer> initiateGame() throws StopGameException {
        ArrayList<Adventurer> players = new ArrayList<>();
        MainMenu mainMenu = new MainMenu();
        players = mainMenu.start(players);
        return players;
    }
    private void play(ArrayList<Adventurer> players) throws StopGameException {
        boolean finish = false;
        Random random = new Random();
        WinnerMenu winnerMenu = new WinnerMenu();
        try
        {
            while (!finish)
            {
                for (Adventurer player : players) {
                    int dieRoll = random.nextInt(6) + 1;
                    finish = newPosition(player, dieRoll);
                    if (finish)
                    {
                        throw new WinGameException(player);
                    }
                }
            }
        }
        catch (WinGameException winGameException)
        {
            winnerMenu.congrates(winGameException.getwinner());
            winnerMenu.handleUserChoice(winnerMenu.getIntResponse());
        }
    }
    private boolean newPosition(Adventurer player, int die)
    {
        boolean finish = false;
        System.out.println("\n" + player.getName() + " est sur la case " + player.getPosition() + ".");
        System.out.println(player.getName() + " lance le dé et fait...\n\n\n");
        if (player.getPosition() + die == 64) {
            player.setPosition(player.getPosition() + die);
            finish = true;
        } else if (player.getPosition() + die > 64) {
            player.setPosition(128 - player.getPosition() - die);
            System.out.println("Rebond sur la case arrivée...\n\n\n");
        } else {
            player.setPosition(player.getPosition() + die);
        }
        System.out.println("Il fait " + die + " et avance donc jusqu'à la case " + player.getPosition() + ".");
        return finish;
    }
}
