package com.dnd.interact;

import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.offensive.OffensiveEquipment;

public class EnemyDisplayer implements Displayer{
    @Override
    public void find(String playerName, String equipmentName, int power) {

    }

    @Override
    public void find(String playerName, String type, int life, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {
        System.out.println(playerName + " tombe sur un " + type + ".\n");
        System.out.println("\tNombre de vies : " + life +
                offensiveEquipment + defensiveEquipment + "\n");
    }

    @Override
    public void find(String playerName, String type) {
        System.out.println(playerName + " tombe sur un cadavre de " + type + ".");
    }

    @Override
    public void find(String playerName) {
    }

    @Override
    public void find(String playerName, int life, int attack, int defense) {

    }

    public void enemyAttack(String type) {
        System.out.println("\nLe " + type + " dégaine en premier et attaque...");
    }

    public void enemyMark(String name) {
        System.out.println("Il touche " + name + "...");
    }

    public void damage(int damage) {
        System.out.println("...qui prend " + damage + " de dégats.");
    }

    public void enemyEscape(String type) {
        System.out.println("Le " + type +" s'enfuit à toute vitesse !");
    }

    public void fail() {
        System.out.println("Son attaque échoue.");
    }

    public void playerAttack(String name) {
        System.out.println("\n" + name + " dégaine en premier et attaque...");
    }

    public void playerMark(String type) {
        System.out.println("Il touche le " + type + "...");
    }

    public void enemyDied(String type) {
        System.out.println("Le " + type + " meurt.");
    }
}
