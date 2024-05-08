package com.dnd.equipment.defensive;

import java.util.Random;

public class SmokeBomb extends DefensiveEquipment {
    Random random = new Random();

    public SmokeBomb(String playerType) {
        super("Fumigène", playerType);
        this.defense = 6;
    }
    public SmokeBomb() {
        super("Fumigène", "sorcier blanc");
        this.defense = 3 + random.nextInt(7);
    }
}
