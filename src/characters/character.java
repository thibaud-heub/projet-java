package characters;

import java.util.Scanner;

import weapons.*;

public abstract class character {
    protected String name;
    protected int level;
    protected int pv; 
    protected int mana;
    protected int speed;

    public String getName() {
        return name;
    }

    public void printStats() {
        System.out.println(" - Niveau: " + level + " - PV: " + pv + " - Mana: " + mana + " - Vitesse: " + speed);
    }

    public abstract weapon chooseWeapon(Scanner scanner);   
}
