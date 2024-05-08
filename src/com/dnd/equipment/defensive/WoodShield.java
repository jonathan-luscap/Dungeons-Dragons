package com.dnd.equipment.defensive;

import java.util.Random;

public class WoodShield extends DefensiveEquipment {
    Random random = new Random();

    public WoodShield(String playerType) {
        super("Bouclier de bois", playerType);
        this.defense = 3;
    }
    public WoodShield() {
        super("Bouclier de bois", "guerrier");
        this.defense = 2 + random.nextInt( 4);
    }
}
