package characters;

import java.util.Scanner;

import weapons.*;

public abstract class character extends entity {

    public character(int PV, int attackSpeed, int Rfire, int Rphysic, int Rmagic, int Dfire, int Dphysic, int Dmagic, String name, int level, int mana, int speed) {
        // Appel du constructeur de la classe Entity avec les paramètres nécessaires
        super(PV, attackSpeed, Rfire, Rphysic, Rmagic, Dfire, Dphysic, Dmagic);

        // Initialisation des attributs spécifiques à Character
        this.name = name;
        this.level = level;
        this.mana = mana;
        this.speed = speed;
    }


    protected String name;
    protected int level;
    protected int mana;
    protected int speed;

    public String getName() {
        return name;
    }

    public void printStats() {
        System.out.println(" - Niveau: " + level + " - Mana: " + mana + " - Vitesse: " + speed);
    }

    public abstract weapon chooseWeapon(Scanner scanner);   
}
