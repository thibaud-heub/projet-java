package items;

import java.util.Random;

public class SpeedPotion extends Item{
    
    private int value;

    public SpeedPotion() {
        super("Potion de vitesse", "C'est une potion qui augmente votre vitesse de 10 points.");
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
