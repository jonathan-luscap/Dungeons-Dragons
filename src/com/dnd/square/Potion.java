package com.dnd.square;

import com.dnd.character.Player;
import com.dnd.interact.PotionDisplayer;

import java.util.Random;

public class Potion extends Square implements Openable {
    Random random = new Random();
    PotionDisplayer potionDisplayer = new PotionDisplayer();
    private int life;
    private String name;

    public Potion() {
        this.name = "Potion de remise en forme";
        this.life = 2 + random.nextInt(8);
    }

    public Potion(int power) {
        this.life = power;
        this.name = "Potion de remise en forme";
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public String toString() {
        return name + " : " + life + " vies";
    }

    @Override
    public void interact(Player player) {
        potionDisplayer.find(player.getName(), name, life);
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
