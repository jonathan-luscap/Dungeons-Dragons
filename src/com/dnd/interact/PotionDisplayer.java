package com.dnd.interact;

import com.dnd.character.Player;
import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.offensive.OffensiveEquipment;

public class PotionDisplayer implements Displayer{
    @Override
    public void find(String playerName, String equipmentName, int life) {
        System.out.println(playerName + " trouve " + equipmentName + " de " + life + " vies.");
    }

    @Override
    public void find(String playerName, String enemyType, int life, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {

    }

    @Override
    public void find(String playerName, String type) {

    }

    @Override
    public void find(String name) {

    }

    @Override
    public void find(String playerName, int life, int attack, int defense) {

    }

    public void isFull() {
        System.out.println("\"Je suis à fond là !!\"");
    }

    public void better() {
        System.out.println("\"Aahhh, je me sens mieux !\"");
    }

    public void newLife(Player player) {
        System.out.println("\tIl a maintenant " + player.getLife() + " vies.");
    }
}
