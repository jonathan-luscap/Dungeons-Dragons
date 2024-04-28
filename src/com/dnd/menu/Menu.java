package com.dnd.menu;

import com.dnd.character.Character;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Integer relou = 0;
    private Boolean continuGame = true;
    public ArrayList<Character> startMenu()
    {
        Scanner sc = new Scanner(System.in);
        int nbPlayer = 0;
        boolean newPlayer = true;
        ArrayList<Character> players = new ArrayList<>();
        System.out.println("Welcome Chewam! Faisons une partie de Donjons et Dragons.");
        while (newPlayer && continuGame)
        {
            displaySpace();
            mainMenu(nbPlayer);
            int response = isValidResponse(sc.nextLine());
            displaySpace();
            Character player = null;
            if (response == 1)
            {
                boolean created = false;
                String name = "";
                Character.CharacterType type = null;
                while (!created && continuGame)
                {
                    players.add(new Character());
                    player = players.get(nbPlayer);
                    changeName(player, sc);
                    displaySpace();
                    while (type == null)
                    {
                        type = typeMenu(player, type, created, sc);
                    }
                }
                if (continuGame)
                {
                    player.setType(type);
                }
                nbPlayer++;
            }
            else if (response == 2)
            {
                newPlayer = false;
            }
            else if (response == 3)
            {
                for (int i = 0; i < nbPlayer; i++){
                    System.out.println(players.get(i));
                }
            }
            else if (response == 4)
            {
                continuGame = !endGame(sc);
            }
            else
            {
                badChoice(relou);
            }
        }
        if (continuGame)
        {
            for (Character player : players){
                System.out.println(player);
            }
            displaySpace();
            System.out.println("**** **** OK, let's play folks !!! **** ****\n\n\n\n\n\n");
            pause(2000);
        }
        return (continuGame) ? players : null;
    }
    public void introMenu()
    {
        System.out.println("Entrer le numéro de la reponse choisie :");
    }
    public void mainMenu(int nbPlayer)
    {
        introMenu();
        System.out.println("\t|\t1.Ajouter un joueur(" + nbPlayer + " créés)");
        System.out.println("\t|\t2.Commencer à jouer");
        System.out.println("\t|\t3.Voir les personnages et leurs attributs");
        System.out.println("\t|\t4.Quitter");

    }
    public Character.CharacterType typeMenu(Character player,Character.CharacterType type,boolean created, Scanner sc)
    {
        while(!created && continuGame) {
            introMenu();
            System.out.println("\t|\t1.Votre personnage sera un guerrier");
            System.out.println("\t|\t2.Votre personnage sera un sorcier");
            System.out.println("\t|\t3.Voir les informations concernant le personnage");
            System.out.println("\t|\t4.Quitter");
            int typeChoice = isValidResponse(sc.nextLine());
            displaySpace();
            if (typeChoice == 1) {
                type = Character.CharacterType.warrior;
                created = true;
            } else if (typeChoice == 2) {
                type = Character.CharacterType.wizard;
                created = true;
            } else if (typeChoice == 3) {
                displaySpace();
                System.out.println(player);
                characterModMenu(player, sc);
            } else if (typeChoice == 4) {

                continuGame = !endGame(sc);
                continue;
            } else {
                badChoice(relou);
                continue;
            }
        }
        return type;
    }
    public void characterModMenu(Character player, Scanner sc)
    {
        introMenu();
        System.out.println("\t|\t1.Modifier le nom de " + player.getName());
        System.out.println("\t|\t2.Modifier le type de " + player.getName());
        int response = isValidResponse(sc.nextLine());
        if (response == 1)
        {
            changeName(player,sc);
        }
        else if (response == 2)
        {
            changeType(player, sc);
        }
    }
    public boolean endMenu(Character player)
    {
        Scanner sc = new Scanner(System.in);
        boolean continu = true;
        boolean hasAnswered = false;
        displaySpace();
        System.out.println(player + " a remporté la partie...");
        pause(1500);
        System.out.println("Félicitations !!!!");
        pause(2000);
        displaySpace();
        System.out.println("Félicitations !!!!");
        pause(100);
        displaySpace();
        System.out.println("Félicitations !!!!");
        pause(2000);
        while (!hasAnswered)
        {
            displaySpace();
            System.out.println("Entrer le numéro de l'option choisie :");
            System.out.println("\t|\t1.Faire un nouvelle partie");
            System.out.println("\t|\t2.Quitter");
            int response = isValidResponse(sc.nextLine());
            if (response == 1)
            {
                hasAnswered = true;
                return true;
            }
            else if (response == 2)
            {
                if (endGame(sc))
                {
                    hasAnswered = true;
                    return false;
                }
            }
            else
            {
                displaySpace();
                badChoice(relou);
                pause(5000);
            }
        }
        return continu;
    }
    public void changeName(Character player, Scanner sc)
    {
        boolean nameMatch = false;
        String newName;
        while (!nameMatch)
        {
            System.out.println("Entrer un nom de 3 caractères minimum :");
            newName = sc.nextLine().toUpperCase();
            nameMatch = isValidName(newName);
            if (nameMatch)
            {
                player.setName(newName);
            }
            else
            {
                System.out.println("\"" + newName + "\" n'est pas un nom valide !!");
            }
        }
    }
    public int isValidResponse(String response)
    {
        int intChoice = 0;
        try
        {
            if (response.isEmpty())
            {
                throw new IllegalArgumentException("Entrer une reponse valide, svp !");
            }
            intChoice = Integer.parseInt(response);
        }
        catch (InputMismatchException | NumberFormatException e)
        {
            System.out.println("Erreur : entrer le numéro de votre réponse.");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Erreur : " + e.getMessage());
        }
        return intChoice;
    }
    public boolean isValidName(String name)
    {
        return !name.isEmpty() && name.matches("[a-zA-Z- ']{3,20}");
    }
    public void changeType(Character player, Scanner sc)
    {
        introMenu();
        System.out.println("\t|\t1.Le personnage sera du type guerrier");
        System.out.println("\t|\t2.Le personnage sera du type sorcier");
        System.out.println("\t|\t3.Quitter");
        int response = isValidResponse(sc.nextLine());
        if (response == 1)
        {
            player.setType(Character.CharacterType.warrior);
        }
        else if (response == 2)
        {
            player.setType(Character.CharacterType.wizard);
        }
        else if (response == 3)
        {
            continuGame = !endGame(sc);
        }
    }
    public boolean endGame(Scanner sc)
    {
        while (true)
        {
            displaySpace();
            System.out.println("Arrêter la partie de Donjons et Dragons ?");
            System.out.println("\t|\t1.Oui");
            System.out.println("\t|\t2.Non");
            int response = isValidResponse(sc.nextLine());
            if (response == 1)
            {
                return true;
            } else if (response == 2)
            {
                return false;
            }
            else
            {
                badChoice(relou);
            }
        }
    }
    public boolean newPosition(Character character, int die)
    {
        boolean finish = false;
        displaySpace();
        System.out.println("\n" + character.getName() + " est sur la case " + character.getPosition() + ".");
        pause(500);
        System.out.println(character.getName() + " lance le dé et fait...\n\n\n\n");
        if (character.getPosition() + die == 64) {
            character.setPosition(character.getPosition() + die);
            finish = true;
        } else if (character.getPosition() + die > 64) {
            character.setPosition(128 - character.getPosition() - die);
            System.out.println("Rebond sur la case arrivée...\n\n\n\n");
            pause(500);
        } else {
            character.setPosition(character.getPosition() + die);
        }
        pause(1500);
        System.out.println("Il fait " + die + " et avance donc jusqu'à la case " + character.getPosition() + ".");
        pause(2000);
        return finish;
    }
    public void pause(int time)
    {
        try
        {
            Thread.sleep(time);
        }
        catch (InterruptedException e)
        {
            System.out.println("Somthing went wrong with the tempo.... : " + e);
        }
    }
    public void displaySpace()
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    public void badChoice (Integer relou)
    {
        System.out.println("Cette réponse ne figure pas dans la liste !!\n\n\n\n\n");
        pause(500 * relou);
        relou++;
    }
}

