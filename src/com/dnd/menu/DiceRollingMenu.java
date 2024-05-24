package com.dnd.menu;

import com.dnd.game.GameDaoImplementation;

import java.sql.SQLException;

public class DiceRollingMenu extends Menu {
    GameDaoImplementation gameDao = new GameDaoImplementation();

    public void displayChoices(){
        introMenu();
        System.out.println("\t|\t1.Lancer le dé");
        System.out.println("\t|\t2.Sauvegarder la partie");
    }

    public void handleUserChoice(int choice){
        possibleResponses response = possibleResponses.values()[choice - 1];
        switch (response){
            case ROLLDICE -> rollDice();
            case SAVEGAME -> saveGame();
            default -> badChoice();
        }
    }

    private void rollDice() {
    }

    private void saveGame() {
        try{
            gameDao.add();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la sauvegarde de la partie.");
        }
    }

    public enum possibleResponses {
        ROLLDICE(1),
        SAVEGAME(2);

        private int UserChoice;

        possibleResponses(int UserChoice) {
            this.UserChoice = UserChoice;
        }
    }
}
