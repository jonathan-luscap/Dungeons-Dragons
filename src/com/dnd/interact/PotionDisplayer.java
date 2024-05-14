package com.dnd.interact;

import com.dnd.character.Player;
import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.offensive.OffensiveEquipment;

public class PotionDisplayer extends Displayer{

    public void find(String playerName, String equipmentName, int life) {
        System.out.println(playerName + " trouve " + equipmentName + " de " + life + " vies.");
    }
    public void isFull() {
        System.out.println("\"Je suis à fond là !!\"");
    }

    public void better() {
        System.out.println("\"Aahhh, je me sens mieux !\"");
    }

    public void newLife(Player player) {
        System.out.println("\tIl a maintenant " + player.getLife() + " vies.");
        mainMenu.pause(2000);
    }
}
