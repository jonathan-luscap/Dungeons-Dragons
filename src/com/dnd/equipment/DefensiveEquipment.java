package com.dnd.equipment;

public class DefensiveEquipment {
    public enum OffensiveEquipmentType {
        shield,
        potion
    }

    public String name;
    public int defense;
    OffensiveEquipment.OffensiveEquipmentType equipmentType;

//    public DefensiveEquipment(Character.CharacterType characterType)
//    {
//        if (characterType == Character.CharacterType.warrior){
//            this.equipmentType = OffensiveEquipment.OffensiveEquipmentType.weapon;
//        } else if (characterType == Character.CharacterType.wizard) {
//            this.equipmentType = OffensiveEquipment.OffensiveEquipmentType.spell;
//        }
//    }

}