package com.dnd.menu;

import com.dnd.exception.StartPlayingException;
import com.dnd.exception.*;

public class ExitMenu extends Menu{

    @Override
    public void displayChoices()
    {
        introMenu();
        System.out.println("\t|\t1.Arrêter le jeu");
        System.out.println("\t|\t2.Revenir au menu précedent");
    }

    public void handleUserChoice(int choice) throws StopGameException {

        ExitMenu.possibleResponses response = ExitMenu.possibleResponses.values()[choice - 1];
        switch (response)
        {
            case ENDGAME -> endGame();
            case BACK -> goBack();
            default -> badChoice();
        }
    }

    private void endGame() throws StopGameException {
        throw new StopGameException();
    }

    private void goBack() {
    }

    public enum possibleResponses{
        ENDGAME(1), BACK(2);

        private int userChoice;

        possibleResponses(int userChoice){
            this.userChoice = userChoice;
        }

        public int getUserChoice() {
            return userChoice;
        }
    }
}
