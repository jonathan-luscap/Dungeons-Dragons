package com.dnd.game;

import com.dnd.character.Character;
import com.dnd.menu.Menu;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    public boolean play(ArrayList<Character> players, Menu menu)
    {
        boolean finish = false;
        boolean continu = true;
        Random random = new Random();
        while (!finish)
        {
            for (Character player : players) {
                int dieRoll = random.nextInt(6) + 1;
                finish = menu.newPosition(player, dieRoll);
                if (finish)
                {
                    continu = menu.endMenu(player);
                    break;
                }
            }
        }
        return continu;
    }
}
