package com.dnd.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dnd.exception.*;
import com.dnd.character.*;
import com.dnd.exception.StartPlayingException;
import com.dnd.game.Game;
import com.dnd.game.GameDaoImplementation;
import com.dnd.interact.GamesListDisplayer;

public class StartMenu extends Menu {

    public void displayChoices() {
        introMenu();
        System.out.println("\t|\t1.Ajouter un joueur");
        System.out.println("\t|\t2.Afficher les joueurs créés");
        System.out.println("\t|\t3.Commencer la partie");
        System.out.println("\t|\t4.Arrêter le jeu");
    }

    public void handleUserChoice(int choice) throws StartPlayingException, StopGameException, ArrayIndexOutOfBoundsException, NewPlayerException {

        possibleResponses response = possibleResponses.values()[choice - 1];
        ArrayList<Player> players = Game.getPlayers();
        switch (response)
        {
            case ADDPLAYER -> addPlayer();
            case DISPLAYPLAYERS -> displayPlayers();
            case STARTPLAYING ->  startPlaying();
            case ENGAME -> endGame();
            default -> badChoice();
        }
        Game.setPlayers(players);
    }

    private void addPlayer() throws StopGameException, NewPlayerException {
        ArrayList<Player> players = Game.getPlayers();
        AddPlayerMenu addPlayerMenu = new AddPlayerMenu();
        addPlayerMenu.displayChoices();
        int response = addPlayerMenu.getIntResponse();
        try {
            players = addPlayerMenu.handleUserChoice(players, response);

        } catch (TypeMismatchException typeMismatchException) {
            System.out.println("Something went wrong while character creation.");
        }
        catch (GoBackException goBackException){

        }
        Game.setPlayers(players);
    }

    private void displayPlayers() throws StopGameException {
        ArrayList<Player> players = Game.getPlayers();
        DisplayCharacterMenu displayCharacterMenu = new DisplayCharacterMenu();
        displayCharacterMenu.displayPlayers(players);
        displayCharacterMenu.displayChoices();
        try
        {
            players = displayCharacterMenu.handleUserChoice(players, displayCharacterMenu.getIntResponse());
        }
        catch (GoBackException ignored){}
        Game.setPlayers(players);
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
        ADDPLAYER(1),
        DISPLAYPLAYERS(3),
        STARTPLAYING(4),
        ENGAME(5);

        private int userChoice;

        possibleResponses(int userChoice){
            this.userChoice = userChoice;
        }
    }
}
