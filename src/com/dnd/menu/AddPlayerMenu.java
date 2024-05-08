package com.dnd.menu;

import com.dnd.character.Persona;
import com.dnd.character.Player;
import com.dnd.character.Warrior;
import com.dnd.character.Wizard;
import com.dnd.exception.*;

import java.util.ArrayList;

public class AddPlayerMenu extends Menu{

    public void displayChoices() {
        introMenu();
        System.out.println("\t|\t1.Votre personnage sera un Guerrier");
        System.out.println("\t|\t2.Votre personnage sera un Sorcier");
        System.out.println("\t|\t3.Revenir au menu précedent");
        System.out.println("\t|\t4.Arrêter le jeu");
    }

    public ArrayList<Player> handleUserChoice(ArrayList<Player> players, int choice) throws StopGameException, GoBackException, TypeMismatchException {
        AddPlayerMenu.possibleResponses response = AddPlayerMenu.possibleResponses.values()[choice - 1];
        switch (response)
        {
            case WARRIOR -> players = createWarrior(players);
            case WIZARD -> players = createWizard(players);
            case BACK ->  goBack();
            case ENGAME -> endGame();
            default -> badChoice();
        }
        return players;
    }

    private ArrayList<Player> createWarrior(ArrayList<Player> players) throws TypeMismatchException {
        Player warrior = new Warrior();
        GiveName giveName = new GiveName();
        giveName.displayChoices();
        warrior = giveName.addName(warrior);
        players.add(warrior);
        return players;
    }

    private ArrayList<Player> createWizard(ArrayList<Player> players) throws TypeMismatchException {
        Player wizard = new Wizard();
        GiveName giveName = new GiveName();
        giveName.displayChoices();
        wizard = giveName.addName(wizard);
        players.add(wizard);
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
        WARRIOR(1), WIZARD(2), BACK(3), ENGAME(4);

        private int userChoice;

        possibleResponses(int userChoice){
            this.userChoice = userChoice;
        }
    }
}
