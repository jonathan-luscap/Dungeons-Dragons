package com.dnd.menu;

import java.util.ArrayList;
import com.dnd.exception.*;
import com.dnd.character.*;
import com.dnd.exception.StartPlayingException;

public class StartMenu extends Menu {

    public void displayChoices() {
        introMenu();
        System.out.println("\t|\t1.Ajouter un joueur");
        System.out.println("\t|\t2.Afficher les joueurs créés");
        System.out.println("\t|\t3.Commencer la partie");
        System.out.println("\t|\t4.Arrêter le jeu");
    }

    public ArrayList<Player> handleUserChoice(ArrayList<Player> players, int choice) throws StartPlayingException, StopGameException, ArrayIndexOutOfBoundsException {

        possibleResponses response = possibleResponses.values()[choice - 1];
        switch (response)
        {
            case ADDPLAYER -> players =  addPlayer(players);
            case DISPLAYPLAYERS -> players = displayPlayers(players);
            case STARTPLAYING ->  startPlaying();
            case ENGAME -> endGame();
            default -> badChoice();
        }
        return players;
    }

    private ArrayList<Player> addPlayer(ArrayList<Player> players) throws StopGameException {
        AddPlayerMenu addPlayerMenu = new AddPlayerMenu();
        addPlayerMenu.displayChoices();
        int response = addPlayerMenu.getIntResponse();
        try {
            players = addPlayerMenu.handleUserChoice(players, response);

        } catch (TypeMismatchException typeMismatchException) {
            System.out.println("Something went wrong while character creation.");
        }
        catch (GoBackException goBackException){}
        return players;
    }

    private ArrayList<Player> displayPlayers(ArrayList<Player> players) throws StopGameException {
        DisplayCharacterMenu displayCharacterMenu = new DisplayCharacterMenu();
        displayCharacterMenu.displayPlayers(players);
        displayCharacterMenu.displayChoices();
        try
        {
            players = displayCharacterMenu.handleUserChoice(players, displayCharacterMenu.getIntResponse());
        }
        catch (GoBackException ignored){}
        return players;
    }

    private void startPlaying() throws StartPlayingException {
        throw new StartPlayingException();
    }

    private void endGame() throws StopGameException {
        ExitMenu exitMenu = new ExitMenu();
        exitMenu.displayChoices();
        exitMenu.handleUserChoice(exitMenu.getIntResponse());
    }

    public enum possibleResponses{
        ADDPLAYER(1), DISPLAYPLAYERS(2), STARTPLAYING(3), ENGAME(4);

        private int userChoice;

        possibleResponses(int userChoice){
            this.userChoice = userChoice;
        }
    }
}
