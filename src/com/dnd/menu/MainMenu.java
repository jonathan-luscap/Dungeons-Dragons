package com.dnd.menu;

import com.dnd.character.PersonaDaoImplementation;
import com.dnd.character.Player;
import com.dnd.exception.StartPlayingException;
import com.dnd.exception.StopGameException;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainMenu extends Menu{
    public ArrayList<Player> start(ArrayList<Player> players) throws StopGameException {
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
        } catch (StartPlayingException startPlayingException) {
            System.out.println("*****    Ok, let's play folks !!   *****");
        }
        return players;
    }
}
