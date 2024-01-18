package characters;

import java.awt.Image;


import weapons.*;

/**
 * Classe abstraite représentant un personnage, qui hérite de la classe Entity
 */
public abstract class character extends entity {
    
    protected SpriteSheet idleSheet;
    protected SpriteSheet runSheet;
    protected SpriteSheet deathSheet;
    protected int FRAME_COUNT;


    /**
     * Constructeur de la classe character
     * @param PV
     * @param attackSpeed
     * @param Rfire
     * @param Rphysic
     * @param Rmagic
     * @param Dfire
     * @param Dphysic
     * @param Dmagic
     * @param name
     * @param level
     * @param mana
     * @param speed
     */
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

    /**
     * décrémente la mana, la durabilité en fonction de l'arme utilisée
     * et appelle la méthode attack de la classe entity
     * @param otherEntity
     * @param weaponUsed
     */
    public void attack(entity otherEntity, weapon weaponUsed) {
        if (this.mana >= weaponUsed.getManaUsed()) {
            this.mana -= weaponUsed.getManaUsed(); // Déduit le mana utilisé pour l'attaque
            super.attack(otherEntity); // Appelle la méthode attack de la classe entity
            weaponUsed.decreaseDurability(); // Diminue la durabilité de l'arme après l'attaque
        } else {
            System.out.println(this.name + " n'a pas assez de mana pour attaquer avec " + weaponUsed.getName());
        }
    }  

    // méthodes abstraites implémentées dans les classes filles
    public abstract int getIdleFrameCount();
    public abstract int getRunFrameCount();
    public abstract int getDeathFrameCount();
    public abstract int getSpeed();

    // on obtient ici le chemin, la largeur et hauteur de chaque sprite 
    protected void setIdleSheet(String path, int frameWidth, int frameHeight) {
        this.idleSheet = new SpriteSheet(path, frameWidth, frameHeight);
    }

    protected void setRunSheet(String path, int frameWidth, int frameHeight) {
        this.runSheet = new SpriteSheet(path, frameWidth, frameHeight);
    }

    protected void setDeathSheet(String path, int frameWidth, int frameHeight) {
        this.deathSheet = new SpriteSheet(path, frameWidth, frameHeight);
    }

    // on obtient un sprite spécifique de la feuille de sprites
    public Image getIdleSprite(int col) {
        return idleSheet.getSprite(col, 0);
    }

    public Image getRunSprite(int col) {
        return runSheet.getSprite(col, 0);
    }

    public Image getDeathSprite(int col) {
        return deathSheet.getSprite(col, 0);
    }
}
