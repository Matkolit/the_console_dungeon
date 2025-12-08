package src.creatures;
import src.items.Inventory;

public class Player extends Creature{
    private int experience;
    private Inventory inventory;


    public Player(int strength, int level, int armor, String name) {
        super(strength, level, armor, name);
        experience = 0;
        inventory = new Inventory(10);
    }

    public boolean setExperience(int exp){
       if(exp > 0) {
           experience += exp;
           return true;
       }
       return false;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Player "+name+" ";
    }
}
