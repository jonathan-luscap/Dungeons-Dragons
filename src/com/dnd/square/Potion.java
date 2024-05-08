package com.dnd.square;

import com.dnd.character.Persona;
import com.dnd.character.Player;
import com.dnd.exception.PlayerDiedException;
import com.dnd.interact.PotionDisplayer;

import java.util.Random;

public class Potion implements Square{
    Random random = new Random();
    PotionDisplayer potionDisplayer = new PotionDisplayer();
    private int life;
    private String type;

    public Potion() {
        this.type = "Potion de remise en forme";
        this.life = 2 + random.nextInt(8);
    }

    @Override
    public String toString() {
        return type + " : " + life + " vies";
    }

    @Override
    public void interact(Player player) throws PlayerDiedException {
        potionDisplayer.find(player.getName(), type, life);
        if (player.getLife() < player.getMaxLife()){
            int newLife = player.getLife() + life;
            if (newLife > player.getMaxLife()){
                potionDisplayer.isFull();
                newLife = player.getMaxLife();
            } else {
                potionDisplayer.better();
            }
            player.setLife(newLife);
        }
        potionDisplayer.newLife(player);
    }
}
