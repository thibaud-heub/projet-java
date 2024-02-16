package items;

import java.util.Random;

public class StrenghPotion extends Item{
    private int value;

    public StrenghPotion() {
        super("Potion de force", "C'est une potion qui augmente votre force de 10 points.");
    }

    public int randomValue() {
        Random rand = new Random();
        return 5 + rand.nextInt(11);
    }

    public void use() {
        // TODO implement here
    }

    
    // Getters pour la valeur de la potion

    public int getValue() {
        value = randomValue();
        return this.value;
    }
}
