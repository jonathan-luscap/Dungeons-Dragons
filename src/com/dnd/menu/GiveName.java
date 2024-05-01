package com.dnd.menu;

import com.dnd.character.*;

public class GiveName extends Menu{

    @Override
    public void displayChoices() {
        System.out.println("Entrer un nom (3 caractères minimum, 20 maximum) :");
    }

    public Adventurer addName(Adventurer player) {
        player.setName(getStringResponse().toUpperCase());

        return player;
    }
}
