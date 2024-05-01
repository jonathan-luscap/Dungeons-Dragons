package com.dnd.menu;

import com.dnd.character.Adventurer;
import com.dnd.exception.GoBackException;
import com.dnd.exception.StopGameException;

public class ModifyAttributeMenu extends Menu{

    @Override
    public void displayChoices() {
        introMenu();
        System.out.println("\t|\t1.Modifier le nom");
        System.out.println("\t|\t2.Modifier le type");
        System.out.println("\t|\t3.Revenir au menu précedent");
        System.out.println("\t|\t4.Arrêter le jeu");
    }

    public Adventurer handleUserChoice(Adventurer player, int choice) throws StopGameException, GoBackException {
        ModifyAttributeMenu.possibleResponses response = ModifyAttributeMenu.possibleResponses.values()[choice - 1];
        switch (response)
        {
            case MODIFYNAME -> player = modifyName(player);
            case MODIFYTYPE -> player = modifyType(player);
            case BACK ->  goBack();
            case ENGAME -> endGame();
            default -> badChoice();
        }
        return player;
    }

    private Adventurer modifyName(Adventurer player) {
        GiveName giveName = new GiveName();
        giveName.displayChoices();
        player = giveName.addName(player);
        return player;
    }

    private Adventurer modifyType(Adventurer player) throws StopGameException {
        ModifyTypeMenu modifyTypeMenu = new ModifyTypeMenu();
        modifyTypeMenu.displayChoices();
        player = modifyTypeMenu.handleUserChoice(player, modifyTypeMenu.getIntResponse());
        return player;
    }

    private void goBack() throws GoBackException {
        throw new GoBackException();
    }

    private void endGame() throws StopGameException {
        ExitMenu exitMenu = new ExitMenu();
        exitMenu.displayChoices();
        exitMenu.handleUserChoice(getIntResponse());
    }

    public enum possibleResponses{
        MODIFYNAME(1), MODIFYTYPE(2), BACK(3),ENGAME(4);

        private int userChoice;

        possibleResponses(int userChoice){
            this.userChoice = userChoice;
        }
    }
}
