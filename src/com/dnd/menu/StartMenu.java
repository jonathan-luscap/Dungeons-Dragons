package com.dnd.menu;

public class StartMenu extends Menu {
    public void displayChoice()
    {
        introMenu();
        System.out.println("\t|\t1.Ajouter un joueur");
        System.out.println("\t|\t2.Afficher les joueurs créés");
        System.out.println("\t|\t3.Commencer la partie");
        System.out.println("\t|\t4.Terminer la partie");
    }
    public int getResponse()
    {
        return isValidResponse(sc.nextLine());
    }
}
