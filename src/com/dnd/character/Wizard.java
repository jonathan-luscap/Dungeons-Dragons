package com.dnd.character;

import com.dnd.equipment.defensive.DefensiveEquipmentFactory;
import com.dnd.equipment.offensive.OffensiveEquipmentFactory;
import com.dnd.exception.TypeMismatchException;

public class Wizard extends Player {

    public Wizard() throws TypeMismatchException {
        super("sorcier blanc", 15, OffensiveEquipmentFactory.equip("sorcier blanc"), DefensiveEquipmentFactory.equip("sorcier blanc"));
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
