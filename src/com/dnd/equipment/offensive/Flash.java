package com.dnd.equipment.offensive;

import java.util.Random;

public class Flash extends OffensiveEquipment {
    Random random = new Random();

    public Flash(String playerType) {
        super("Eclair", playerType);
        this.damage = 2;
    }
    public Flash() {
        super("Eclair", "sorcier blanc");
        this.damage = 2 + random.nextInt(4);
    }
}
