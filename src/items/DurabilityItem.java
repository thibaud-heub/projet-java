package items;

import weapons.*;

import java.util.Random;

import characters.*;


public class DurabilityItem extends Item {
    private int value;

    public DurabilityItem() {
        super("Objet de durabilité","C'est un objet qui augmente la durabilité de votre arme, d'une valeur de 10 points.");
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
