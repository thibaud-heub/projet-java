package characters;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.util.List;
import items.*;


import weapons.*;

/**
 * Classe abstraite représentant un personnage, qui hérite de la classe Entity
 */
public abstract class character extends entity {
    
    protected BufferedImage[] idleSprites;
    protected BufferedImage[] runSprites;
    protected BufferedImage[] deathSprites;
    protected int FRAME_COUNT;
    public enum State {IDLE, RUNNING, DEATH}; 
    private State currentState = State.IDLE;
    private double X;
    private double Y;
    private List<Item> inventory;


    /**
     * Constructeur de la classe character
     * @param PV Points de vie
     * @param Rfire Résistance au feu
     * @param Rphysic Résistance physique
     * @param Rmagic Résistance magique
     * @param Dfire Dégâts de feu
     * @param Dphysic Dégâts physiques
     * @param Dmagic Dégâts magiques
     * @param name Nom du personnage
     * @param level Niveau du personnage
     * @param mana Mana du personnage
     * @param speed Vitesse du personnage
     */
    public character(int PV, int Rfire, int Rphysic, int Rmagic, int Dfire, int Dphysic, int Dmagic, String name, int level, int mana, int speed) {
        // Appel du constructeur de la classe Entity avec les paramètres nécessaires
        super(PV, Rfire, Rphysic, Rmagic, Dfire, Dphysic, Dmagic);

        this.name = name;
        this.level = level;
        this.mana = mana;
        this.speed = speed;
    }

    protected String name;
    protected int level;
    protected int mana;
    protected int speed;

    // Méthodes abstraites implémentées dans les classes filles
    public abstract int getSpeed();
    public abstract weapon getWeapon();


    /**
     * Décrémente la mana, la durabilité en fonction de l'arme utilisée et appelle la méthode attack de la classe entity
     * @param otherEntity L'autre entité attaquée
     * @param weaponUsed  L'arme utilisée
     */
    public void attack(entity otherEntity, weapon weaponUsed) {
        if (this.mana >= weaponUsed.getManaUsed()) {
            this.mana -= weaponUsed.getManaUsed(); // Déduit le mana utilisé pour l'attaque
            super.attack(otherEntity); // Appelle la méthode attack de la classe entity
            weaponUsed.decreaseDurability(1); // Diminue la durabilité de l'arme après l'attaque
        } else {
            System.out.println(this.name + " n'a pas assez de mana pour attaquer avec " + weaponUsed.getName());
        }
    }  

    /**
     * Augmente le niveau du personnage
     */
    public void increaseLevel() {
        this.level += 1;
    }


    // Setters pour les sprites, l'état, l'inventaire et les coordonnées

    public void setXY (double x, double y)
    {
        this.X = x;
        this.Y = y;
    }


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

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void setItemInventory(Item item) {
        this.inventory.add(item);
    }

    public void setState(State newState) {
        this.currentState = newState;
    }


    // Getters pour les sprites, l'état, l'inventaire, le nom, le niveau, les coordonnées


    public double getX()
    {
        return this.X;
    }

    public double getY()
    {
        return this.Y;
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

    public State getState() {
        return currentState;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public List<Item> getInventory() {
        return inventory;
    }
}


