package com.chewam.dnd;

public class Character {
    /**
     *
     */
    public enum CharacterType {
        warrior(10,10),
        wizard(6, 15);

        private final int attack;
        private final int life;

        CharacterType(int attack, int life) {
            this.attack = attack;
            this.life = life;
        }
        //enum setters
        public int getAttack() {
            return attack;
        }
        public int getLife() {
            return life;
        }
    }
    public CharacterType type;
    public String name;
    public int attack;
    public int life;

    public Character(CharacterType type, String name) {
        this.name = name;
        this.type = type;
        this.attack = type.getAttack();
        this.life = type.getLife();
    }

    //Character getters and setters
    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public int getLife() {
        return life;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public CharacterType getType() {
        return type;
    }
    public void setType(CharacterType type) {
        this.type = type;
        this.attack = type.getAttack();
        this.life = type.getLife();
    }
    @Override
    public String toString() {
        return "Character{" +
                "type=" + type +
                ", attack=" + attack +
                ", life=" + life +
                "}";
    }
}
