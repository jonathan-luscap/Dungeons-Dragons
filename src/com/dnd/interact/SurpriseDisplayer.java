package com.dnd.interact;

public class SurpriseDisplayer extends Displayer{
    public void find(String playerName) {
        System.out.print("Quelque chose bouge derrière un buisson...");
        mainMenu.pause(1000);
        System.out.println("\t..." + playerName + " se rapproche, la main sur son arme ...");
        mainMenu.pause(2000);
    }

    public void shift(String playerName, int position) {
        System.out.print("Avant qu'il n'ai pu réagir " + playerName + " se retrouve sur la case n°" + position + " !!");
    }
}
