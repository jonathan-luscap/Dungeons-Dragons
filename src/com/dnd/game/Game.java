package com.dnd.game;

import com.dnd.character.Character;
import com.dnd.menu.Menu;
import com.dnd.menu.StartMenu;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    public void play()
    {
        StartMenu startMenu = new StartMenu();
        startMenu.displayChoice();
        int response = startMenu.getResponse();

    }
}
