package com.dnd.game;

import com.dnd.character.Adventurer;
import com.dnd.exception.*;
import com.dnd.dice.*;
import com.dnd.menu.MainMenu;
import com.dnd.menu.WinnerMenu;
import com.dnd.square.*;


import java.util.ArrayList;
import java.util.Random;

public class Game {

    public void gameLoop() throws StopGameException {
        while (true) {
            play(initiateGame());
        }
    }
    private ArrayList<Adventurer> initiateGame() throws StopGameException {
        ArrayList<Adventurer> players = new ArrayList<>();
        MainMenu mainMenu = new MainMenu();
        players = mainMenu.start(players);
        return players;
    }
    private void play(ArrayList<Adventurer> players) throws StopGameException {
        boolean finish = false;
        Dice dice = new D1();
        WinnerMenu winnerMenu = new WinnerMenu();
        Square[] gameBoard = makeGameBoard();
        displayGameBoard(gameBoard);
        try
        {
            while (!finish)
            {
                for (Adventurer player : players) {
                    int dieRoll = dice.roll();
                    finish = newPosition(player, dieRoll);
                    if (finish)
                    {
                        throw new WinGameException(player);
                    }
                }
            }
        }
        catch (WinGameException winGameException)
        {
            winnerMenu.congrates(winGameException.getwinner());
            winnerMenu.handleUserChoice(winnerMenu.getIntResponse());
        }
    }
    private boolean newPosition(Adventurer player, int die)
    {
        boolean finish = false;
        System.out.println("\n" + player.getName() + " est sur la case " + player.getPosition() + ".");
        System.out.println(player.getName() + " lance le dé et fait...\n\n\n");
        if (player.getPosition() + die == 64) {
            player.setPosition(player.getPosition() + die);
            finish = true;
        } else if (player.getPosition() + die > 64) {
            player.setPosition(128 - player.getPosition() - die);
            System.out.println("Rebond sur la case arrivée...\n\n\n");
        } else {
            player.setPosition(player.getPosition() + die);
        }
        System.out.println("Il fait " + die + " et avance donc jusqu'à la case " + player.getPosition() + ".");
        return finish;
    }
    public Square[] makeGameBoard() {
        Random random = new Random();
        int capacity = 64;
        Square[] gameBoard = new Square[64];
        int emptySquare = 6;
        int enemySquare = 9 + random.nextInt(5);
        int equipmentSquare = 12 + random.nextInt(3);
        int potionSquare = 12 + random.nextInt(3);
        int surpriseSquare = capacity - emptySquare - equipmentSquare - potionSquare - enemySquare;
        Square square = null;
        boolean completed = false;
        while (!completed){
            int squarePosition = random.nextInt(64);
            try
            {
                square = gameBoard[squarePosition];
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            if (square == null) {
                square = selectSquare();
                if (square instanceof Empty && emptySquare > 0) {
                    gameBoard[squarePosition] = square;
                    emptySquare--;
                } else if (square instanceof Enemy && enemySquare > 0) {
                    gameBoard[squarePosition] = square;
                    enemySquare--;
                } else if (square instanceof Equipment && equipmentSquare > 0) {
                    gameBoard[squarePosition] = square;
                    equipmentSquare--;
                } else if (square instanceof Potion && potionSquare > 0) {
                    gameBoard[squarePosition] = square;
                    potionSquare--;
                } else if (square instanceof Surprise && surpriseSquare >0) {
                    gameBoard[squarePosition] = square;
                    surpriseSquare--;
                }
            }
            completed = fullGameBoard(gameBoard);
        }
        return gameBoard;
    }

    private Square selectSquare() {
        Dice dice = new D5();
        Square square = null;
        int squareType = dice.roll();
        switch (squareType){
            case 1 -> square = new Empty();
            case 2 -> square = new Enemy();
            case 3 -> square = new Equipment();
            case 4 -> square = new Potion();
            case 5 -> square = new Surprise();
        }
        return square;
    }
    private boolean fullGameBoard(Square[] gameBoard){
        boolean ok = true;
        for (Square position : gameBoard){
            if (position == null){
                ok = false;
            }
        }
        return ok;
    }
    private void displayGameBoard(Square[] gameBoard){
        int count =1;
        for (Square square : gameBoard){
            System.out.println("Case n°" + count + ": " + square);
            count++;
        }
    }
}
