package com.dnd.equipment.offensive;

public class Sword extends OffensiveEquipment {

    public Sword(String playerType) {
        super("Epée",  playerType);
        this.damage = 5;
    }
    public Sword() {
        super("Epée",  "guerrier");
        this.damage = 3 + random.nextInt(7);
    }
}
