package characters;

import java.util.Scanner;

import weapons.*;

public abstract class character extends entity {

    public character(int PV, int attackSpeed, int Rfire, int Rphysic, int Rmagic, int Dfire, int Dphysic, int Dmagic, String name, int level, int mana, int speed) {
        // Appel du constructeur de la classe Entity avec les paramètres nécessaires
        super(PV, attackSpeed, Rfire, Rphysic, Rmagic, Dfire, Dphysic, Dmagic);

        this.name = name;
        this.level = level;
        this.mana = mana;
        this.speed = speed;
    }


    protected String name;
    protected int level;
    protected int mana;
    protected int speed;

    public abstract weapon chooseWeapon(Scanner scanner); 

    public void attack(entity otherEntity, weapon weaponUsed) {
        if (this.mana >= weaponUsed.getManaUsed()) {
            this.mana -= weaponUsed.getManaUsed(); // Déduire le mana utilisé pour l'attaque
            super.attack(otherEntity); // Appelle la méthode attack de la classe entity
            weaponUsed.decreaseDurability(); // Diminue la durabilité de l'arme après l'attaque
        } else {
            System.out.println(this.name + " n'a pas assez de mana pour attaquer avec " + weaponUsed.getName());
        }
    }  
}
