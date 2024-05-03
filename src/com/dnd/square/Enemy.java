package com.dnd.square;

import com.dnd.character.Adventurer;

public abstract class Enemy implements Square{
    protected String name;
    protected int life;
    protected int attack;
    protected int defense;
    protected String type;

    public Enemy() {
        this.name = null;
        this.life = 0;
        this.attack = 0;
        this.defense = 0;
        this.type = null;
    }

    public Enemy(String name, int life, int attack, String type, int defense) {
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.type = type;
        this.defense = defense;
    }

    @Override
    public void interact(Adventurer player) {}

    @Override
    public String toString() {
        return "Enemy{}";
    }
}
