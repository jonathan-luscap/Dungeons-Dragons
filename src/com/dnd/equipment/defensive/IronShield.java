package com.dnd.equipment.defensive;

import com.dnd.character.Persona;
import com.dnd.character.Warrior;

public class IronShield extends DefensiveEquipment{
    public IronShield() {
        super("Bouclier de fer", Persona.PersonaType.guerrier);
        this.defense = 5 + random.nextInt(3);
    }
}
