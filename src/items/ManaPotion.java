package items;

import weapons.*;

import java.util.Random;

import characters.*;

public class ManaPotion extends Item {
    
    private int value;

    public ManaPotion() {
        super("Potion de mana", "C'est une potion qui augmente votre mana de 10 points.");
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
