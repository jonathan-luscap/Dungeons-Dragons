package com.dnd.menu;


import com.dnd.character.*;
import com.dnd.exception.StopGameException;

public class ModifyTypeMenu extends Menu{

    @Override
    public void displayChoices() {
        introMenu();
        System.out.println("\t|\t1.Votre personnage sera un Guerrier");
        System.out.println("\t|\t2.Votre personnage sera un Sorcier");
        System.out.println("\t|\t3.Revenir au menu précedent");
        System.out.println("\t|\t4.Arrêter le jeu");
    }

    public Adventurer handleUserChoice(Adventurer player, int choice) throws StopGameException {
        ModifyTypeMenu.possibleResponses response = ModifyTypeMenu.possibleResponses.values()[choice - 1];
        switch (response)
        {
            case WARRIOR -> player = makeWarrior(player);
            case WIZARD -> player = makeWizard(player);
            case BACK ->  goBack();
            case ENGAME -> endGame();
            default -> badChoice();
        }
        return player;
    }

    private Adventurer makeWarrior(Adventurer player) {
        if (player instanceof Wizard)
        {
            String name = player.getName();
            player = new Warrior();
            player.setName(name);
        }
        return player;
    }

    private Adventurer makeWizard(Adventurer player) {
        if (player instanceof Warrior)
        {
            String name = player.getName();
            player = new Wizard();
            player.setName(name);
        }
        return player;
    }

    private void goBack() {
    }

    private void endGame() throws StopGameException {
        ExitMenu exitMenu = new ExitMenu();
        exitMenu.displayChoices();
        exitMenu.handleUserChoice(exitMenu.getIntResponse());
    }

    public enum possibleResponses{
        WARRIOR(1), WIZARD(2), BACK(3),ENGAME(4);

        private int userChoice;

        possibleResponses(int userChoice){
            this.userChoice = userChoice;
        }
    }
}
