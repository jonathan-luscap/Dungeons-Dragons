package com.dnd.menu;

import com.dnd.character.Character;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

//    public final int playerMax = 6;

    public ArrayList startMenu()
    {
        int nbPlayer = 0;
        boolean newPlayer = true;
        boolean continueGame = true;
        ArrayList<Character> players = new ArrayList<>();
        System.out.println("Welcome Chewam! Faisons une partie de Donjons et Dragons.");
        Scanner sc = new Scanner(System.in);
        while (newPlayer && continueGame)
        {
            System.out.println("Entrer le numéro de la reponse choisie :");
            System.out.println("1.Ajouter un joueur(" + nbPlayer + " créés)");
            System.out.println("2.Commencer à jouer");
            System.out.println("3.Voir les personnages et leurs attributs");
            System.out.println("4.Quitter");
            int response = isValidResponse(sc.nextLine());
            Character player = null;
            if (response == 1)
            {
                boolean created = false;
                String name = "";
                Character.CharacterType type = null;
                while (!created && continueGame)
                {
                    players.add(new Character());
                    player = players.get(nbPlayer);
                    System.out.println("Choisissez un nom (3 caractères minimum):");
                    name = sc.nextLine().toUpperCase();
                    while (!isValidName(name))
                    {
                        System.out.println(name + " n'est pas un nom valide pour le personnage.");
                        name = sc.nextLine();
                    }
                    while (!created && continueGame)
                    {
                        player.setName(name);
                        System.out.println("Entrer le numéro de l'option choisie :");
                        System.out.println("1.Votre personnage sera un guerrier");
                        System.out.println("2.Votre personnage sera un sorcier");
                        System.out.println("3.Voir les informations concernant le personnage");
                        System.out.println("4.Quitter");
                        int typeChoice = isValidResponse(sc.nextLine());
                        if (typeChoice == 1)
                        {
                            type = Character.CharacterType.warrior;
                            created = true;
                        }
                        else if (typeChoice == 2)
                        {
                            type = Character.CharacterType.wizard;
                            created = true;
                        }
                        else if (typeChoice == 3)
                        {
                            System.out.println(player);
                        }
                        else if (typeChoice == 4)
                        {
                            continueGame = endGame(sc) != 1;
                            continue;
                        }
                        else
                        {
                            System.out.println("Ce choix n'est pas proposé.");
                            continue;
                        }
                    }
                }
                if (continueGame)
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
                    System.out.println(player);
                }
            }
            else if (response == 4)
            {
                continueGame = endGame(sc) != 1;
            }
            else
            {
                System.out.println("Veuillez entrer un numéro valide, svp.");
            }
        }
        sc.close();
        if (continueGame)
        {
            for (Character player : players){
                System.out.println(player);
            }
        }

        return (continueGame && !newPlayer) ? players : null;
    }
    public int endGame(Scanner sc)
    {
        System.out.println("Arrêter la partie de Donjons et Dragons ?");
        System.out.println("1.Oui");
        System.out.println("2.Non");
        return isValidResponse(sc.nextLine());
    }
    public boolean isValidName(String name)
    {
        return !name.isEmpty() && name.matches("[a-zA-Z- ']{3,20}");
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
}

