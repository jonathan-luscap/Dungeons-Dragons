package com.dnd.equipment.offensive;

import com.dnd.character.Persona;
import com.dnd.character.Player;
import com.dnd.equipment.Equipment;
import com.dnd.interact.EquipmentDisplayer;

import java.util.Objects;
import java.util.Random;


public class OffensiveEquipment extends Equipment {
    Random random = new Random();
    protected OffensiveEquipmentType type;
    protected int damage;
    protected boolean taken;

    public OffensiveEquipment(int damage) {
        super();
        this.damage = damage;
        this.taken = false;
    }

    public OffensiveEquipment(OffensiveEquipmentType type, Persona.PersonaType playerType) {
        super(playerType);
        this.type = type;
        this.damage = 0;
        this.taken = false;
    }

    public OffensiveEquipment(OffensiveEquipmentType type, Persona.PersonaType playerType, int damage) {
        super(playerType);
        this.type = type;
        this.damage = damage;
        this.taken = false;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public OffensiveEquipmentType getType() {
        return type;
    }

    public void setType(OffensiveEquipmentType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "\n-> Equipement offensif pour combatant de type " + this.playerType + " :\n\t\t" +
                "type d'équipement : " + this.type + "\n\t\t" +
                "niveau de dégats : " + this.damage;
    }

    @Override
    public void interact(Player player) {
        EquipmentDisplayer equipmentDisplayer = new EquipmentDisplayer();
        if (!this.taken) {
            equipmentDisplayer.find(player.getName(), this.getType().getOffensiveEquipmentTypeName(), damage);
            if (Objects.equals(player.getType(), this.playerType)) {
                equipmentDisplayer.typeMatch();
                if (player.getOffensiveEquipment().getDamage() < this.damage){
                    equipmentDisplayer.betterOne(player.getOffensiveEquipment().getType().getOffensiveEquipmentTypeName(), player.getOffensiveEquipment().getDamage(), this.getType().getOffensiveEquipmentTypeName(), this.damage);
                    player.getOffensiveEquipment().setDamage(this.damage);
                    player.getOffensiveEquipment().setType(this.type);
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

    public enum OffensiveEquipmentType {
        SWORD(1, "épée"),
        FLASH(2, "éclair"),
        MACE(3, "masse d'arme"),
        FIREBALL(4, "boule de feu");

        private int id;
        private String name;
        OffensiveEquipmentType(int id, String offensiveEquipmentTypeName) {
            this.id = id;
            this.name = offensiveEquipmentTypeName;
        }
        public int getOffensiveEquipmentTypeId() {
            return id;
        }
        public String getOffensiveEquipmentTypeName() {
            return name;
        }
    }
}

