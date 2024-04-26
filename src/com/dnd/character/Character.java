package com.dnd.character;

import com.dnd.equipment.OffensiveEquipment;

public class Character {
    /**
     *
     */
    public enum CharacterType
    {
        warrior(10, 10),
        wizard(6, 15);

        private final int attack;
        private final int life;
        private OffensiveEquipment defaultEquipment;

        CharacterType(int attack, int life)
        {
            this.attack = attack;
            this.life = life;
        }

        //enum getters
        public int getAttack()
        {
            return attack;
        }

        public int getLife()
        {
            return life;
        }
    }

    private CharacterType type;
    private String name;
    private int attack;
    private int life;
    private int position = 1;

    public Character()
    {
    }

    public Character(String name)
    {
        this.name = name;
    }

    public Character(CharacterType type, String name)
    {
        this.name = name;
        this.type = type;
        this.attack = type.getAttack();
        this.life = type.getLife();
    }

    //Character getters and setters
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAttack()
    {
        return attack;
    }

    public void setAttack(int attack)
    {
        this.attack = attack;
    }

    public int getLife()
    {
        return life;
    }

    public void setLife(int life)
    {
        if (life < 0) {
            this.life = 0;
        } else {
            this.life = life;
        }
    }

    public CharacterType getType()
    {
        return type;
    }

    public void setType(CharacterType type)
    {
        this.type = type;
        this.attack = type.getAttack();
        this.life = type.getLife();
    }

    public int getPosition()
    {
        return position;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }

    @Override
    public String toString()
    {
        String returnedType = null;
        if (type == CharacterType.warrior)
        {
            returnedType = "guerrier";
        }
        else if (type == CharacterType.wizard)
        {
            returnedType = "sorcier";
        }
        return "\n\n" + name + " personnage de type " + returnedType + " : \n\t" +
                "niveau d'attaque : " + attack + "\n\t" +
                "nombre de vies : " + life + "\n\n";
    }
}
