package com.chewam.dnd;

import java.util.Scanner;

public class Menu {

    public final int playerMax = 6;

    public Character[] startMenu()
    {
        int nbPlayer = 0;
        boolean newPlayer = true;
        boolean continueGame = true;
        Character[] players = new Character[playerMax];
        System.out.println("Welcome Chewam! Faisons une partie de Donjons et Dragons.");
        while (newPlayer && continueGame && nbPlayer < playerMax)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Entrer le numéro de la reponse choisie :");
            System.out.println("1.Créer un joueur(" + nbPlayer + "/" + playerMax + ")");
            System.out.println("2.Passer au jeu");
            System.out.println("3.Quitter");
            int response = sc.nextInt();
            if (response == 1)
            {
                Scanner characterType = new Scanner(System.in);
                System.out.println("De quel type ?");
                System.out.println("1.Guerrier");
                System.out.println("2.Sorcier");
                System.out.println("3.Quitter");
                Character.CharacterType type = null;
                if (characterType.nextInt() == 1)
                {
                    type = Character.CharacterType.warrior;
                }
                else if (characterType.nextInt() == 2)
                {
                    type = Character.CharacterType.wizard;
                }
                else if (characterType.nextInt() == 3)
                {
                    int end = endGame();
                    if (end == 1)
                    {
                        continueGame = false;
                    }
                }
                String name = "";
                while (name == "")
                {
                    Scanner characterName = new Scanner(System.in);
                    System.out.println("Choisissez un nom :");
                    name = characterName.nextLine();
                    if (name == "")
                    {
                        System.out.println("Veuillez choisir un nom, svp.");
                    }
                }
                players[nbPlayer] = new Character(type, name);
                nbPlayer++;
            }
            else if (response == 2)
            {
                newPlayer = false;
            }
            else if (response == 3)
            {
                int end = endGame();
                if (end == 1)
                {
                    newPlayer = false;
                    continueGame = false;
                }
            }
            else
            {
                System.out.println("Veuillez entrer un numéro valide, svp.");
            }
        }
        if (continueGame && !newPlayer){
            return players;
        } else {
            return null;
        }
    }
    public int endGame()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Arrêter la partie de Donjons et Dragons ?");
        System.out.println("1.Oui");
        System.out.println("2.Non");
        int response = sc.nextInt();
        return response;
    }
}
