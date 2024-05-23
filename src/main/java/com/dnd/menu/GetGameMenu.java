package com.dnd.menu;

import com.dnd.game.GameDaoImplementation;

import java.sql.SQLException;

public class GetGameMenu extends Menu{

    GameDaoImplementation gameDao = new GameDaoImplementation();

    public void displayChoices(){
        System.out.println("Entrer le numéro de la partie à charger :");
    }

public void handleUserChoice(int choice){
        try {
            gameDao.getGame(choice);
        } catch (SQLException e) {
            System.out.println("Erreur lors du chargement de la partie.");
        }
    }
}
