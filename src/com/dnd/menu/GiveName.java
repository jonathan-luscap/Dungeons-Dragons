package com.dnd.menu;

import com.dnd.character.*;

public class GiveName extends Menu{

    public void displayChoices() {
        System.out.println("Entrer un nom (3 caractères minimum, 20 maximum) :");
    }

    public Player addName(Player player) {
        String name = getStringResponse();
        player.setName(name.toUpperCase());

        return player;
    }
}
