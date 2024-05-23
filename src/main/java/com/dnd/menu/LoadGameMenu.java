package com.dnd.menu;

import com.dnd.exception.NewPlayerException;
import com.dnd.exception.StartPlayingException;
import com.dnd.exception.StopGameException;
import com.dnd.game.Game;
import com.dnd.game.GameDaoImplementation;
import com.dnd.interact.GamesListDisplayer;

import java.util.List;

public class LoadGameMenu extends Menu {

    GameDaoImplementation gameDao = new GameDaoImplementation();

    public void displayChoices(){
        introMenu();
        System.out.println("\t|\t1.Nouvelle partie");
        System.out.println("\t|\t2.Parties sauvegardées");
    }

    public void handleUserChoice(int choice) throws StopGameException, StartPlayingException {
        possibleResponses response = possibleResponses.values()[choice - 1];
        switch (response)
        {
            case NEWGAME -> startNewGame();
            case SAVEDGAMES -> savedGames();
            default -> badChoice();
        }
    }

    private void startNewGame() throws StopGameException, StartPlayingException {
        StartMenu startMenu = new StartMenu();
        while (true){
            try {
                startMenu.displayChoices();
                startMenu.handleUserChoice(startMenu.getIntResponse());
            } catch (NewPlayerException newPlayerException) {}
        }
    }

    private void savedGames() {


        GetGameMenu getGameMenu = new GetGameMenu();
        GamesListDisplayer gamesListDisplayer = new GamesListDisplayer();
        List<Game> gamesList = gameDao.getGames();
        if (gamesList.isEmpty()) {
            gamesListDisplayer.emptyList();
        } else {
            gamesListDisplayer.displayGameList(gamesList);
            getGameMenu.displayChoices();
            getGameMenu.handleUserChoice(getGameMenu.getIntResponse());
        }
    }

    public enum possibleResponses{
        NEWGAME(1),
        SAVEDGAMES(2);

        private int userChoice;

        possibleResponses(int userChoice){
            this.userChoice = userChoice;
        }
    }
}
