package com.dnd.character;

import com.dnd.equipment.defensive.DefensiveEquipmentFactory;
import com.dnd.equipment.offensive.OffensiveEquipmentFactory;

public class Wizard extends Player {

    public Wizard() {
        super(PersonaType.WIZARD, 15, OffensiveEquipmentFactory.equip(PersonaType.WIZARD), DefensiveEquipmentFactory.equip(PersonaType.WIZARD));
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
