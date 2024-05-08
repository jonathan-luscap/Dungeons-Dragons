package com.dnd.menu;

import com.dnd.exception.StopGameException;

public class LooserMenu extends Menu {

    public void everybodyDied() {
        System.out.println("Oh non, tout le monde est mort au combat....");
        introMenu();
        System.out.println("1.Refaire une partie");
        System.out.println("2.Arrêter le jeu");
    }
    public boolean handleUserChoice(int choice) throws StopGameException {
        WinnerMenu.possibleResponses response = WinnerMenu.possibleResponses.values()[choice - 1];
        boolean newgame = false;
        switch (response) {
            case NEWGAME -> newgame = newGame();
            case ENDGAME -> endGame();
            default -> badChoice();
        }
        return newgame;
    }
    private boolean newGame() {
        return true;
    }

    private void endGame() throws StopGameException {
        throw new StopGameException();
    }
    public enum possibleResponses{
        NEWGAME(1), ENDGAME(2);

        private int userChoice;

        possibleResponses(int userChoice){
            this.userChoice = userChoice;
        }
    }
}
