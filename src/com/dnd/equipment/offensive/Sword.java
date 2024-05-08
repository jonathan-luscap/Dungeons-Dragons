package com.dnd.equipment.offensive;

import java.util.Random;

public class Sword extends OffensiveEquipment {
    Random random = new Random();

    public Sword(String playerType) {
        super("Epée",  playerType);
        this.damage = 5;
    }
    public Sword() {
        super("Epée",  "guerrier");
        this.damage = 3 + random.nextInt(7);
    }
}
