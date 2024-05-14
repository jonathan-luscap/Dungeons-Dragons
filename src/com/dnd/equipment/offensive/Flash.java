package com.dnd.equipment.offensive;

public class Flash extends OffensiveEquipment {

    public Flash(String playerType) {
        super("Eclair", playerType);
        this.damage = 2;
    }
    public Flash() {
        super("Eclair", "sorcier blanc");
        this.damage = 2 + random.nextInt(4);
    }
}
