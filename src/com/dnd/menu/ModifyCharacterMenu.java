package com.dnd.menu;

import com.dnd.character.Adventurer;
import com.dnd.exception.GoBackException;
import com.dnd.exception.StopGameException;

import java.util.ArrayList;

public class ModifyCharacterMenu extends Menu{

    @Override
    public void displayChoices()
    {
        System.out.println("Entrer le numéro du personnage à modifier :");
    }
    public ArrayList<Adventurer> handleUserChoice(ArrayList<Adventurer> players, int choice) throws StopGameException {
        ModifyAttributeMenu modifyAttributeMenu = new ModifyAttributeMenu();
        Boolean modifying = true;
        Adventurer player = players.get(choice - 1);
        try
        {
            while (true)
            {
                System.out.println(player);
                modifyAttributeMenu.displayChoices();
                player = modifyAttributeMenu.handleUserChoice(player, modifyAttributeMenu.getIntResponse());
                players.add(choice - 1, player);
            }
        }
        catch (GoBackException ignored){}
        return players;
    }
}
