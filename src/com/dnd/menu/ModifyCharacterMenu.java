package com.dnd.menu;

import com.dnd.character.Player;
import com.dnd.exception.GoBackException;
import com.dnd.exception.StopGameException;
import com.dnd.exception.TypeMismatchException;

import java.util.ArrayList;

public class ModifyCharacterMenu extends Menu{

    public void displayChoices()
    {
        System.out.println("Entrer le numéro du personnage à modifier :");
    }

    public ArrayList<Player> handleUserChoice(ArrayList<Player> players, int choice) throws StopGameException {
        ModifyAttributeMenu modifyAttributeMenu = new ModifyAttributeMenu();
        System.out.println("il y a " + players.toArray().length + " choix possibles.");
        if (choice < 1 || choice > players.toArray().length){
            System.out.println("Ce choix ne correspond à rien.");
        } else {
            Player player = players.get(choice - 1);
            try
            {
                while (true)
                {
                    System.out.println(player);
                    modifyAttributeMenu.displayChoices();
                    player = modifyAttributeMenu.handleUserChoice(player, modifyAttributeMenu.getIntResponse());
                    players.remove(choice - 1);
                    players.add(choice - 1, player);
                }
            } catch (TypeMismatchException typeMismatchException) {
                System.out.println("Something went wrong while character creation.");
            } catch (GoBackException ignored){}
        }

        return players;
    }
}
