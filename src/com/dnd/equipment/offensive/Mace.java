package com.dnd.equipment.offensive;

public class Mace extends OffensiveEquipment{

    public Mace() {
        super("Masse", "guerrier");
        this.damage = 6 + random.nextInt(8);
    }
}
