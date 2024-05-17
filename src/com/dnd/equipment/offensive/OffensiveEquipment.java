package com.dnd.equipment.offensive;

import com.dnd.character.Persona;
import com.dnd.character.Player;
import com.dnd.equipment.Equipment;
import com.dnd.interact.EquipmentDisplayer;

import java.util.Objects;
import java.util.Random;


public class OffensiveEquipment extends Equipment {
    Random random = new Random();
    protected int damage;
    protected boolean taken;

    public OffensiveEquipment(int damage) {
        super();
        this.damage = damage;
        this.taken = false;
    }

    public OffensiveEquipment(String type, Persona.PersonaType playerType) {
        super(type, playerType);
        this.damage = 0;
        this.taken = false;
    }

    public OffensiveEquipment(String type, Persona.PersonaType playerType, int damage) {
        super(type, playerType);
        this.damage = damage;
        this.taken = false;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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
            equipmentDisplayer.find(player.getName(), this.type, damage);
            if (Objects.equals(player.getType(), this.playerType)) {
                equipmentDisplayer.typeMatch();
                if (player.getOffensiveEquipment().getDamage() < this.damage){
                    equipmentDisplayer.betterOne(player.getOffensiveEquipment().getType(), player.getOffensiveEquipment().getDamage(), this.type, this.damage);
                    player.getOffensiveEquipment().setDamage(this.damage);
                    player.getOffensiveEquipment().setType(this.type);
//                    player.setOffensiveEquipment(this);
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
}

