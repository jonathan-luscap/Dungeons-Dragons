package com.dnd.menu;

import com.dnd.character.PersonaDaoImplementation;
import com.dnd.character.Player;
import com.dnd.exception.StartPlayingException;
import com.dnd.exception.StopGameException;
import com.dnd.game.Game;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainMenu extends Menu{
    public void start() throws StopGameException {
        try {
            while (true){
                LoadGameMenu loadGameMenu = new LoadGameMenu();
                boolean entered = false;
                while (!entered)
                {
                    try
                    {
                        loadGameMenu.displayChoices();
                        loadGameMenu.handleUserChoice(loadGameMenu.getIntResponse());
                        entered = true;
                    }
                    catch (ArrayIndexOutOfBoundsException e)
                    {
                        System.out.println("Ce choix n'est pas valide");
                    }
                }
            }
        } catch (StartPlayingException startPlayingException) {
            System.out.println("*****    Ok, let's play folks !!   *****");
        }
    }
}