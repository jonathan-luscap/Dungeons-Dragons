package com.dnd.equipment;

public class OffensiveEquipment {
    public enum OffensiveEquipmentType
    {
        weapon,
        spell
    }

    private String name;
    private int attack;
    private OffensiveEquipmentType equipmentType;

//    public OffensiveEquipment(Character.CharacterType characterType)
//    {
//        if (characterType == Character.CharacterType.warrior){
//            this.equipmentType = OffensiveEquipmentType.weapon;
//        } else if (characterType == Character.CharacterType.wizard) {
//            this.equipmentType = OffensiveEquipmentType.spell;
//        }
//    }

}
