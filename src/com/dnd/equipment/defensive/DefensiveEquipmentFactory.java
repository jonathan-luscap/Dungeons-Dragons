package com.dnd.equipment.defensive;

import com.dnd.exception.TypeMismatchException;

public class DefensiveEquipmentFactory {
    public static DefensiveEquipment equip(String playerType) throws TypeMismatchException {
        switch (playerType) {
            case "guerrier" -> {
                return new WoodShield("guerrier");
            }
            case "sorcier blanc" -> {
                return new SmokeBomb("sorcier blanc");
            }
            default -> throw new TypeMismatchException();
        }
    }
}
