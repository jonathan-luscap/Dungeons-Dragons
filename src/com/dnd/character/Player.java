package com.dnd.character;

import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.offensive.OffensiveEquipment;

public abstract class Player extends Persona {

    public Player(PersonaType type, int life, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {
        super(type, life, offensiveEquipment, defensiveEquipment);
        this.position = 0;
    }

    public int getMaxLife() {
        return 40;
    }

    public String toString()
    {
        return "\t****\t****\t****\t****\n" + this.getName() + " personnage de type " + this.type + " : \n\t" +
                "nombre de vies : " + this.life + "\n" +
                this.offensiveEquipment + "\n" +
                this.defensiveEquipment + "\n";
    }
}
