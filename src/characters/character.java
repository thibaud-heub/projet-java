package characters;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import weapons.*;

/**
 * Classe abstraite représentant un personnage, qui hérite de la classe Entity
 */
public abstract class character extends entity {
    
    protected BufferedImage[] idleSprites;
    protected BufferedImage[] runSprites;
    protected BufferedImage[] deathSprites;
    protected BufferedImage[] attackSprites;
    protected int FRAME_COUNT;
    public enum State {IDLE, RUNNING, DEATH}; 
    private State currentState = State.IDLE;


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
    public abstract int getSpeed();
    public abstract int getAttackSpeed();
    public abstract weapon getWeapon();
    


   protected void setIdleSprites(String[] paths) {
    idleSprites = new BufferedImage[paths.length];
    for (int i = 0; i < paths.length; i++) {
        try {
            idleSprites[i] = ImageIO.read(getClass().getResourceAsStream(paths[i]));
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
    }
    protected void setRunSprites(String[] paths) {
        runSprites = new BufferedImage[paths.length];
        for (int i = 0; i < paths.length; i++) {
            try {
                runSprites[i] = ImageIO.read(getClass().getResourceAsStream(paths[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
   

   protected void setDeathSprites(String[] paths) {
    deathSprites = new BufferedImage[paths.length];
    for (int i = 0; i < paths.length; i++) {
        try {
            deathSprites[i] = ImageIO.read(getClass().getResourceAsStream(paths[i]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    protected void setAttackSprites(String[] paths) {
        attackSprites = new BufferedImage[paths.length];
        for (int i = 0; i < paths.length; i++) {
            try {
                attackSprites[i] = ImageIO.read(getClass().getResourceAsStream(paths[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public BufferedImage[] getIdleSprites() {
        return idleSprites;
    }
    public BufferedImage[] getRunSprites() {
        return runSprites;
    }
    public BufferedImage[] getDeathSprites() {
        return deathSprites;
    }
    public BufferedImage[] getAttackSprites() {
        return attackSprites;
    }

    public void setState(State newState) {
        this.currentState = newState;
    }

    public State getState() {
        return currentState;
    }
}


