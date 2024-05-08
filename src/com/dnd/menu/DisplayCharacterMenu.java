package com.dnd.menu;

import com.dnd.exception.GoBackException;
import com.dnd.exception.StopGameException;
import com.dnd.character.*;

import java.util.ArrayList;

public class DisplayCharacterMenu extends Menu{

    public void displayChoices() {
        introMenu();
        System.out.println("\t|\t1.Modifier un personnage");
        System.out.println("\t|\t2.Revenir au menu précedent");
        System.out.println("\t|\t3.Arrêter le jeu");
    }

    public void displayPlayers(ArrayList<Player> players)
    {
        System.out.println("*****     Liste des participants à l'aventure     *****");
        int count = 1;
        for (Persona player : players)
        {
            System.out.println("Aventurier n°" + count + " :");
            System.out.println(player);
            count++;
        }
    }

    public ArrayList<Player> handleUserChoice(ArrayList<Player> players, int choice) throws StopGameException, GoBackException {
        DisplayCharacterMenu.possibleResponses response = DisplayCharacterMenu.possibleResponses.values()[choice - 1];
        switch (response)
        {
            case MODIFY -> {
                players = modifyPlayer(players);
            }
            case BACK ->  goBack();
            case ENGAME -> endGame();
            default -> badChoice();
        }
        return players;
    }

    private ArrayList<Player> modifyPlayer(ArrayList<Player> players) throws StopGameException {
        ModifyCharacterMenu modifyCharacterMenu = new ModifyCharacterMenu();
        modifyCharacterMenu.displayChoices();
        players = modifyCharacterMenu.handleUserChoice(players, modifyCharacterMenu.getIntResponse());
        return players;
    }

    private void goBack() throws GoBackException {
        throw new GoBackException();
    }

    private void endGame() throws StopGameException {
        ExitMenu exitMenu = new ExitMenu();
        exitMenu.displayChoices();
        exitMenu.handleUserChoice(exitMenu.getIntResponse());
    }

    public enum possibleResponses{
        MODIFY(1), BACK(2),ENGAME(3);

        private int userChoice;

        possibleResponses(int userChoice){
            this.userChoice = userChoice;
        }

        public int getUserChoice() {
            return userChoice;
        }
    }
}
