package com.dnd.character;

import com.dnd.equipment.Philter;
import com.dnd.equipment.Spell;

public class Wizard extends Adventurer {

    private int attack;

    public Wizard()
    {
        super();
        this.type = "wizard";
        this.life = 15;
        this.attack = 6;
        this.offensiveEquipment = new Spell();
        this.defensiveEquipment = new Philter();
    }
    public Wizard(String name)
    {
        this();
        this.setName(name);
    }
    public Wizard(String name, String type)
    {
        this(name);
        this.type = type;
    }

    public String getName()
    {
        return super.getName();
    }
    public void setName(String name)
    {
        super.setName(name);
    }

    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public int getAttack()
    {
        return attack;
    }
    public void setAttack(int attack)
    {
        this.attack = attack;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public String toString()
    {
        return "\t\t" + this.getName() + " personnage de type " + type + " : \n\t\t\t" +
                "niveau d'attaque : " + attack + "\n\t\t\t" +
                "nombre de vies : " + life + "\n";
    }
}
