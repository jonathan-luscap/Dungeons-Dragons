package com.dnd.equipment.defensive;

public class Teleportation extends DefensiveEquipment{
    public Teleportation() {
        super("Téléportation", "sorcier blanc");
        this.defense = 6 + random.nextInt(8);
    }
}
