package com.dnd.equipment.defensive;

import com.dnd.character.Persona;
import com.dnd.character.Player;
import com.dnd.equipment.Equipment;
import com.dnd.interact.EquipmentDisplayer;

import java.util.Objects;
import java.util.Random;


public class DefensiveEquipment extends Equipment {
    Random random = new Random();
    protected DefensiveEquipmentType type;
    protected int defense;
    protected boolean taken;

    public DefensiveEquipment(int defense) {
        super();
        this.defense = defense;
        this.taken = false;
    }

    public DefensiveEquipment(DefensiveEquipmentType type, Persona.PersonaType playerType) {
        super(playerType);
        this.type = type;
        this.defense = 0;
        this.taken = false;
    }

    public DefensiveEquipment(DefensiveEquipmentType type, Persona.PersonaType playerType, int defense) {
        super(playerType);
        this.type = type;
        this.defense = defense;
        this.taken = false;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public DefensiveEquipmentType getType() {
        return type;
    }

    public void setType(DefensiveEquipmentType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "\n-> Equipement défensif pour combatant de type " + this.playerType + " :\n\t\t" +
                "type d'équipement : " + this.type + "\n\t\t" +
                "niveau de defense : " + this.defense;
    }

    @Override
    public void interact(Player player) {
        EquipmentDisplayer equipmentDisplayer = new EquipmentDisplayer();
        if (!this.taken) {
            equipmentDisplayer.find(player.getName(), this.getType().getDefensiveEquipmentTypeName(), defense);
            if (Objects.equals(player.getType(), this.playerType)) {
                equipmentDisplayer.typeMatch();
                if (player.getDefensiveEquipment().getDefense() < this.defense){
                    equipmentDisplayer.betterOne(player.getDefensiveEquipment().getType().getDefensiveEquipmentTypeName(), player.getDefensiveEquipment().getDefense(), this.getType().getDefensiveEquipmentTypeName(), this.defense);
                    player.getDefensiveEquipment().setDefense(this.defense);
                    player.getDefensiveEquipment().setType(this.type);
                    this.taken = true;
                } else {
                    equipmentDisplayer.drop();
                }
            } else {
                equipmentDisplayer.typeMismatch();
            }
        } else {
            equipmentDisplayer.alreadyTaken();
        }
    }

    public enum DefensiveEquipmentType {
        WOODSHIELD(1, "bouclier de bois"),
        SMOKEBOMB(2, "fumigène"),
        IRONSHIELD(3, "bouclier de fer"),
        TELEPORTATION(4, "téléportation");

        private int id;
        private String name;
        DefensiveEquipmentType(int id, String defensiveEquipmentTypeName) {
            this.id = id;
            this.name = defensiveEquipmentTypeName;
        }
        public int getDefensiveEquipmentTypeId() {
            return id;
        }
        public String getDefensiveEquipmentTypeName() {
            return name;
        }
    }
}
