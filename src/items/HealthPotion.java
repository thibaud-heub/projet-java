package items;

import weapons.*;
import characters.*;
import java.util.Random;

public class HealthPotion extends Item {
    
    private int value;

    public HealthPotion() {
        super("Potion de vie", "C'est une potion qui augmente vos points de vie.");
    }


    public int randomValue() {
        Random rand = new Random();
        return 5 + rand.nextInt(11);
    }

    public int getValue() {
        value = randomValue();
        return this.value;
    }
    
    public void use() {
        // TODO implement here
    }
}
