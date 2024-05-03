package com.dnd.menu;

import com.dnd.character.Adventurer;
import com.dnd.exception.StopGameException;

public class WinnerMenu extends Menu {
    @Override
    public void displayChoices() {
    }
    public void congrates(Adventurer winner) {
        System.out.println("\t\t\t\t****    La partie est finie!    ****\n\n");
        System.out.println("\t\t" + winner.getName() + " l'emporte\n\n\n\n");
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

        public int getUserChoice() {
            return userChoice;
        }
    }
}
