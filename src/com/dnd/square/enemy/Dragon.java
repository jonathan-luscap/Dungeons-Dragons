package com.dnd.square.enemy;

import com.dnd.character.Player;
import com.dnd.dice.D2;
import com.dnd.dice.D4;
import com.dnd.dice.D6;
import com.dnd.exception.PlayerDiedException;
import com.dnd.exception.DragonDiedException;
import com.dnd.exception.DragonPeaceException;
import com.dnd.interact.DragonDisplayer;
import com.dnd.interact.MagicalGemDisplayer;
import com.dnd.interact.PeaceDisplayer;

import java.util.Random;

public class Dragon extends Enemy{
    Random random = new Random();
    private int attack = 4 + random.nextInt(4);
    private int defense = 4 + random.nextInt(4);

    public Dragon() {
        super(PersonaType.monstre,null, null);
        this.life =  10 + random.nextInt(10);
    }

    @Override
    public void interact(Player player) throws PlayerDiedException, DragonDiedException, DragonPeaceException {
        DragonDisplayer dragonDisplayer = new DragonDisplayer();
        MagicalGemDisplayer magicalGemDisplayer = new MagicalGemDisplayer();
        PeaceDisplayer peaceDisplayer = new PeaceDisplayer();
        D2 d2 = new D2();
        D4 d4 = new D4();
        D6 d6 = new D6();
        boolean fighting = true;
        boolean turn = d2.binary();
        boolean attackIsNotEnough = false;
        boolean defenseIsNotEnough = false;
        boolean defenseIsEnough = false;
        boolean gemTaken = false;
        dragonDisplayer.find(player.getName(), this.life, this.attack, this.defense);
        while (fighting){
            if (turn){
                int damage = 2 + d6.roll();
                dragonDisplayer.playerAttack(player.getName());
                if (player.getOffensiveEquipment().getDamage() >= this.defense) {
                    dragonDisplayer.playerMark();
                    this.life = this.life - damage;
                    dragonDisplayer.damage(damage);
                    if (this.life <= 0){
                        dragonDisplayer.dragonDied();
                        throw new DragonDiedException(player);
                    }
                    int newPosition = player.getPosition() - damage;
                    dragonDisplayer.parade(player.getName(), newPosition);
                    player.setPosition(newPosition);
                    fighting = false;
                } else {
                    dragonDisplayer.fail();
                    attackIsNotEnough = true;
                }
            } else {
                int damage = d4.roll();
                dragonDisplayer.dragonAttack();
                if (player.getDefensiveEquipment().getDefense() < this.attack) {
                    dragonDisplayer.dragonMark(player.getName());
                    player.setLife(player.getLife() - damage);
                    dragonDisplayer.damage(damage);
                    defenseIsNotEnough = true;
                    if (player.testLife()){
                        throw new PlayerDiedException(player);
                    }
                } else {
                    dragonDisplayer.fail();
                    defenseIsEnough = true;
                }
            }
            if (attackIsNotEnough && defenseIsNotEnough && !gemTaken){
                magicalGemDisplayer.find(player.getName());
                player.getOffensiveEquipment().setDamage(player.getOffensiveEquipment().getDamage() + 8);
                magicalGemDisplayer.greaterWeapon(player.getOffensiveEquipment().getType(), player.getOffensiveEquipment().getDamage());
                gemTaken = true;
            }
            if (attackIsNotEnough && defenseIsEnough){
                peaceDisplayer.find(player.getName());
                throw new DragonPeaceException(player);
            }
            turn = !turn;
        }
    }
    @Override
    public String toString() {
        return "\nEnnemi de type " + this.type + " :\n\t\t" +
                "nombre de vie : " + this.life + "\n\t\t" +
                "niveau d'attaque : " + this.attack + "\n\t\t" +
                "niveau de défense : " + this.defense;
    }
}
