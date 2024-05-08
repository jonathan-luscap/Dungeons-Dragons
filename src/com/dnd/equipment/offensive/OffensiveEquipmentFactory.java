package com.dnd.equipment.offensive;

import com.dnd.exception.TypeMismatchException;

public class OffensiveEquipmentFactory {
    public static OffensiveEquipment equip(String playerType) throws TypeMismatchException {
        switch (playerType) {
            case "guerrier" -> {
                return new Sword("guerrier");
            }
            case "sorcier blanc" -> {
                return new Flash("sorcier blanc");
            }
            default -> throw new TypeMismatchException();
        }
    }
}
