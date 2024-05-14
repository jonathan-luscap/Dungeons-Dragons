package com.dnd.square.enemy;


import com.dnd.character.Persona;
import com.dnd.character.Player;
import com.dnd.dice.D2;
import com.dnd.dice.D6;
import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.defensive.WoodShield;
import com.dnd.equipment.offensive.OffensiveEquipment;
import com.dnd.equipment.offensive.Sword;
import com.dnd.exception.DragonDiedException;
import com.dnd.exception.DragonPeaceException;
import com.dnd.exception.PlayerDiedException;
import com.dnd.interact.EnemyDisplayer;
import com.dnd.square.Square;

public abstract class Enemy extends Persona implements Square {
    EnemyDisplayer enemyDisplayer = new EnemyDisplayer();
    boolean dead = false;
    D2 d2 = new D2();
    D6 d6 = new D6();

    public Enemy(String type, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {
        super(type, offensiveEquipment, defensiveEquipment);
    }

    @Override
    public void interact(Player player) throws PlayerDiedException, DragonDiedException, DragonPeaceException {
        if (!dead) {
            enemyDisplayer.find(player.getName(), this.type, this.life, this.offensiveEquipment, this.defensiveEquipment);
            boolean turn = d2.binary();
            if ((turn)) {
                enemyDisplayer.enemyAttack(this.type);
            } else {
                enemyDisplayer.playerAttack(player.getName());
            }
            attack(player, turn);
        } else {
            enemyDisplayer.findDeadbody(player.getName(), this.type);
        }
    }

    private void attack(Player player, boolean isAttacked) throws PlayerDiedException {
        if (isAttacked){
            if (player.getDefensiveEquipment().getDefense() < this.getOffensiveEquipment().getDamage()) {
                enemyDisplayer.enemyMark(player.getName());
                int damage = d6.roll();
                enemyDisplayer.damage(damage);
                player.setLife(player.getLife() - damage);
                if (player.testLife()){
                    throw new PlayerDiedException(player);
                }
                enemyDisplayer.enemyEscape(this.type);
            } else {
                enemyDisplayer.fail();
                enemyDisplayer.enemyEscape(this.type);
            }
        } else {
            if (player.getOffensiveEquipment().getDamage() > this.getDefensiveEquipment().getDefense()) {
                enemyDisplayer.playerMark(this.type);
                int damage = d6.roll();
                enemyDisplayer.damage(damage);
                this.setLife(this.getLife() - damage);
                if (this.getLife() > 0){
                    enemyDisplayer.enemyEscape(this.type);
                } else {
                    enemyDisplayer.enemyDied(this.type);
                    dead = true;
                }
            } else {
                enemyDisplayer.fail();
                enemyDisplayer.enemyEscape(this.type);
            }
        }

    }
    @Override
    public String toString() {
        return "\nEnnemi de type " + type + " :\n\t\t" +
                "nombre de vie : " + life + "\n" +
                offensiveEquipment + "\n" +
                defensiveEquipment;
    }
}
