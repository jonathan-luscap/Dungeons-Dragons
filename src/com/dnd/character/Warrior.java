package com.dnd.character;

import com.dnd.equipment.defensive.DefensiveEquipmentFactory;
import com.dnd.equipment.offensive.OffensiveEquipmentFactory;
import com.dnd.exception.TypeMismatchException;

public class Warrior extends Player {

    public Warrior() throws TypeMismatchException {
        super(PersonaType.guerrier, 10, OffensiveEquipmentFactory.equip(PersonaType.guerrier), DefensiveEquipmentFactory.equip(PersonaType.guerrier));
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
