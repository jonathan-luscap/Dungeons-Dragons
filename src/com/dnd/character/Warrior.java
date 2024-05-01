package com.dnd.character;

public class Warrior extends Adventurer {
    private String type = "warrior";
    private int attack = 10;
    private int life = 10;

    public Warrior()
    {
    }
    public Warrior(String name)
    {
        this.setName(name);
    }
    public Warrior(String name, String type)
    {
        this.setName(name);
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
