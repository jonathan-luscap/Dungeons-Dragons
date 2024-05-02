package com.dnd.menu;

import com.dnd.character.Adventurer;
import com.dnd.exception.StartPlayingException;
import com.dnd.exception.StopGameException;

import java.util.ArrayList;

public class MainMenu extends Menu{
    public void start(ArrayList<Adventurer> players) throws StopGameException {
        try {
            while (true){
                StartMenu startMenu = new StartMenu();
                boolean entered = false;
                while (!entered)
                {
                    try
                    {
                        startMenu.displayChoices();
                        players = startMenu.handleUserChoice(players,startMenu.getIntResponse());
                        entered = true;
                    }
                    catch (ArrayIndexOutOfBoundsException e)
                    {
                        System.out.println("Ce choix n'est pas valide");
                    }
                }
            }
        } catch (
                StartPlayingException startPlayingException) {
            System.out.println("*****    Ok, let's play folks !!   *****");
        }
    }

    @Override
    public void displayChoices() {}
}
