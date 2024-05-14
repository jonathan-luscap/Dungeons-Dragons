package com.dnd.equipment.defensive;

public class IronShield extends DefensiveEquipment{
    public IronShield() {
        super("Bouclier de fer", "guerrier");
        this.defense = 5 + random.nextInt(3);
    }
}
