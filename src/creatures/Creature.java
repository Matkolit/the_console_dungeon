package src.creatures;

abstract public class Creature {
    protected final String name;
    protected int health, strength, armor, level;

    public Creature(int strength, int level, int armor, String name){
        this.health = 100;

        if(strength <= 10)
            this.strength = strength;
        else this.strength = 5;

        if(level <= 10)
            this.level = level;
        else this.level = 1;

        if(armor <= 10)
            this.armor = armor;
        else this.armor = 5;

        this.name = name;
    }


    public void attack(Creature defender, int roll){
        float damage= (float)(strength * roll*0.3);
        defender.takeDamage(Math.round(damage));
    }

    public void takeDamage(int damage){
        int damageTaken = damage-armor;
        if(health < damageTaken)
            health = 0;
        else health -= damageTaken;
        this.isAlive();
    }

    public boolean isAlive(){
        return health > 0;
    }

    @Override
    abstract public String toString();
}
