package com.dnd.menu;

import com.dnd.character.Player;
import com.dnd.exception.DragonPeaceException;

public class DragonPeaceMenu extends Menu{
    public void handleUserChoice(int choice, Player player) throws DragonPeaceException {
        DragonPeaceMenu.possibleResponses response = DragonPeaceMenu.possibleResponses.values()[choice - 1];
        switch (response)
        {
            case WINBYPEACE -> winByPeace(player);
            case BACKTOFIGHT -> backToFight();
            default -> badChoice();
        }
    }

    private void winByPeace(Player player) throws DragonPeaceException {
        throw new DragonPeaceException(player);
    }

    private void backToFight() {
    }

    public enum possibleResponses{
        WINBYPEACE(1), BACKTOFIGHT(2);

        private int userChoice;

        possibleResponses(int userChoice){
            this.userChoice = userChoice;
        }
    }
}
