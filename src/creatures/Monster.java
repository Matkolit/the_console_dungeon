package src.creatures;

import java.util.Random;

public class Monster extends Creature{

    private double lootDropChance;

    public Monster(int strength, int level, int armor, String name){
        super(strength, level, armor, name);
        this.lootDropChance = new Random().nextDouble(0.0, 1.0);
    }


    @Override
    public String toString() {
        return "";
    }
}
