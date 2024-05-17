package com.dnd.game;

import com.dnd.character.*;
import com.dnd.connection.DatabaseAccessPersona;
import com.dnd.equipment.*;
import com.dnd.equipment.offensive.*;
import com.dnd.equipment.defensive.*;
import com.dnd.exception.*;
import com.dnd.dice.*;
import com.dnd.interact.DieDisplayer;
import com.dnd.interact.PlayerDiedDisplayer;
import com.dnd.menu.*;
import com.dnd.square.*;
import com.dnd.square.enemy.*;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();
    Dice dice = new D6();
    WinnerMenu winnerMenu = new WinnerMenu();
    DisplayCharacterMenu displayCharacterMenu = new DisplayCharacterMenu();
    LooserMenu looserMenu = new LooserMenu();
    MainMenu mainMenu = new MainMenu();
    private static int capacity = 63;
    ArrayList<Square> gameBoard = new ArrayList<>();
    DatabaseAccessPersona dap = new PersonaDaoImplementation();

    public void gameLoop() throws StopGameException {
        while (true) {
            initiateGame();
            play();
        }
    }

    private void initiateGame() throws StopGameException {
        players = mainMenu.start(players);
        for (Player player : players) {
            try{
                dap.add(player);
            } catch (SQLException e){
                System.out.println("Impossible de sauvegarder " + player.getName());;
            }
        }
        makeGameBoard();
        displayGameBoard();
    }

    private void play() throws StopGameException {
        PlayerDiedDisplayer playerDiedDisplayer = new PlayerDiedDisplayer();
        displayCharacterMenu.displayPlayers(players);
        try
        {
            while (true)
            {
                for (Player player : players) {
                    int dieRoll = dice.roll();
                    try
                    {
                        newPosition(player, dieRoll);
                    } catch (PlayerDiedException playerDiedException)
                    {
                        playerDiedDisplayer.find(playerDiedException.getPlayerDead().getName());
                        removePlayerDead(playerDiedException.getPlayerDead());
                        if (players.isEmpty()){
                            throw new AllPlayersDiedEception();
                        }
                    }
                }
            }
        }
        catch (DragonDiedException dragonException)
        {
            winnerMenu.congrates(dragonException.getPlayer());
            winnerMenu.handleUserChoice(winnerMenu.getIntResponse());
        }
        catch (DragonPeaceException dragonException)
        {
            winnerMenu.congrates(dragonException.getPlayer());
            winnerMenu.handleUserChoice(winnerMenu.getIntResponse());
        }
        catch (AllPlayersDiedEception allPlayersDiedEception) {
            looserMenu.everybodyDied();
            looserMenu.handleUserChoice(looserMenu.getIntResponse());
        }
    }

    private void newPosition(Player player, int die) throws PlayerDiedException, DragonDiedException, DragonPeaceException {
        int newPosition = 0;
        DieDisplayer dieDisplayer = new DieDisplayer();
        if (player.getPosition() == 0) {
            System.out.println("\n" + player.getName() + " est sur la case départ.");
            mainMenu.pause(200);
        } else {
            System.out.println("\n" + player.getName() + " est sur la case " + player.getPosition() + ".");
        }
        System.out.println(player.getName() + " lance le dé...\n");
        dieDisplayer.dieFaces(die);
        if (player.getPosition() + die >= gameBoard.toArray().length) {
            newPosition = gameBoard.toArray().length * 2 - player.getPosition() - die - 2;
            System.out.println("\u001b[31mRebond sur la case arrivée...\u001b[0m\n");
        } else {
            newPosition = player.getPosition() + die;
        }
        player.setPosition(newPosition);
        System.out.println("Il fait " + die + " et avance donc jusqu'à la case " + player.getPosition() + ".");
        gameBoard.get(newPosition).interact(player);
    }

    public void makeGameBoard() {
        Random random = new Random();
        ArrayList<Square> temp = new ArrayList<>();
        int emptySquare = (int)(this.capacity * 0.1563);
        int enemySquare = (int)(this.capacity * 0.2344) + random.nextInt(5);
        int equipmentSquare = (int)(this.capacity * 0.3) + random.nextInt(3);
        int potionSquare = (int)(this.capacity * 0.1965) + random.nextInt(3);
        int surpriseSquare = capacity - emptySquare - equipmentSquare - potionSquare - enemySquare;
        for (int i = 0; i < emptySquare; i++){
            temp.add(new Empty());
        }
        for (int i = 0; i < enemySquare; i++){
            temp.add(selectEnemy());
        }
        for (int i = 0; i < equipmentSquare; i++){
            temp.add(selectEquipment());
        }
        for (int i = 0; i < potionSquare; i++){
            temp.add(new Potion());
        }
        for (int i = 0; i < surpriseSquare; i++){
            temp.add(new Surprise());
        }
        Collections.shuffle(temp);
        gameBoard.add(new Empty());
        for (int i = 1; i < this.capacity + 1; i++) {
            gameBoard.add(i, temp.get(i - 1));
        }
        gameBoard.add(new Dragon());
    }

    private Square selectSquare() {
        Dice dice = new D5();
        Square square = null;
        int squareType = dice.roll();
        switch (squareType){
            case 1 -> square = new Empty();
            case 2 -> square = selectEnemy();
            case 3 -> square = selectEquipment();
            case 4 -> square = new Potion();
            case 5 -> square = new Surprise();
        }
        return square;
    }

    private Square selectEnemy() {
        D2 d2 = new D2();
        Enemy enemy = null;
        boolean enemyType = d2.binary();
        if (enemyType) {
            enemy = new Goblin();
        } else {
            enemy = new Sorcerer();
        }
        return enemy;
    }

    private Square selectEquipment() {
        Dice dice = new D8();
        Equipment equipment = null;
        int equipmentType = dice.roll();
        switch (equipmentType){
            case 1 -> equipment = new Sword();
            case 2 -> equipment = new Flash();
            case 3 -> equipment = new WoodShield();
            case 4 -> equipment = new SmokeBomb();
            case 5 -> equipment = new Mace();
            case 6 -> equipment = new Fireball();
            case 7 -> equipment = new IronShield();
            case 8 -> equipment = new Teleportation();
        }
        return equipment;
    }

    private boolean fullGameBoard(){
        boolean full = true;
        if (gameBoard.isEmpty()) {
            return false;
        } else {
            for (Square position : gameBoard){
                if (position == null){
                    full = false;
                }
            }
        }
        return full;
    }

    private void displayGameBoard(){
        int count =0;
        for (Square square : gameBoard){
            System.out.println("\nCase n°" + count + ": " + square);
            count++;
        }
    }

    private void displayPlayers(){
        for (Persona player : players){
            System.out.println(player);
        }
    }

    private void removePlayerDead(Player player){
        players.remove(player);
    }

    public static int getCapacity() {
        return capacity;
    }
}
