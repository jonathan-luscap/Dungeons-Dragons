package com.dnd.interact;

import com.dnd.game.Game;

import java.util.List;

public class GamesListDisplayer extends Displayer {
    public void displayGameList(List<Game> games) {
        for (Game game : games) {
            System.out.println(game);
        }
    }

    public void emptyList() {
        System.out.println("Aucune partie enregistrée.");
    }
}
