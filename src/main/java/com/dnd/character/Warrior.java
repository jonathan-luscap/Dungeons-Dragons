package com.dnd.character;

import com.dnd.equipment.defensive.DefensiveEquipmentFactory;
import com.dnd.equipment.offensive.OffensiveEquipmentFactory;

public class Warrior extends Player {

    public Warrior() {
        super(PersonaType.WARRIOR, 10, OffensiveEquipmentFactory.equip(PersonaType.WARRIOR), DefensiveEquipmentFactory.equip(PersonaType.WARRIOR));
    }

    public String getName()
    {
        return super.getName();
    }
    public void setName(String name)
    {
        super.setName(name);
    }
}
