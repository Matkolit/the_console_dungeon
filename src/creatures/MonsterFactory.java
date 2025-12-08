package src.creatures;

import java.util.Random;

public class MonsterFactory {
    private final Random random = new Random();

    private int randomStrength(){
        return random.nextInt(10);
    }

    private int randomLevel(){
        return random.nextInt(10);
    }

    private int randomArmor(){
        return random.nextInt(10);
    }
    private String randomName(){
        String[] names = {"Hydra",
        "Dragon",
        "Vampire",
        "Cat",
        "Lion",
        };
        return names[random.nextInt(names.length)];
    }

    public Monster generate(){
        return new Monster(
                randomStrength(),
                randomLevel(),
                randomArmor(),
                randomName()
        );
    }

}
