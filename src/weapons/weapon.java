package weapons;

import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

/**
 * Classe abstraite pour les armes
 */
public abstract class weapon {
    protected String name;
    protected int damage;
    protected int durability;
    protected int manaUsed;
    protected int attackSpeed;
    protected BufferedImage[] weaponSprites;
    public enum State {IDLE, ATTACK};
    private State currentState = State.IDLE;
    private boolean isWeaponBroken = false;


    public abstract int setDamage();
    public abstract int setDurability();
    public abstract int setMana();
    public abstract int getOffsetWeaponX();
    public abstract int getOffsetWeaponY();


    

    public void attack() {
        System.out.println("Attaque avec " + name + " pour " + damage + " points de dégâts" + " et -" + manaUsed + " points de mana !");
    }

    

    // Augmente les dégats de l'arme de value
    public void increaseDamage(int value) {
        this.damage += value;
    }

    // Augmente la mana utilisée de l'arme de value
    public void increaseManaUsed(int value) {
        this.manaUsed += value;
    }

     // Augmente la durabilité de l'arme de value
    public void increaseDurability(int value) {
        this.durability += value;
    }

    
    // Diminue la durabilité de l'arme de value
    public void decreaseDurability(int value) {
        this.durability -= value; 
        if (this.durability <= 0) {
            this.isWeaponBroken = true;
            System.out.println("L'arme " + this.name + " est cassée !");
        }
    }

    // Augmente la vitesse d'attaque de l'arme de value
    public void increaseSpeedAttack(int value) {
        this.attackSpeed += value;
    }




    // Setters pour les sprites, l'état 
    
    protected void setWeaponSprites(String[] paths) {
        weaponSprites = new BufferedImage[paths.length];
        for (int i = 0; i < paths.length; i++) {
            try {
                weaponSprites[i] = ImageIO.read(getClass().getResourceAsStream(paths[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void setState(State newState) {
        this.currentState = newState;
    }

    


    // Getters pour l'état, les sprites, la mana, la durabilité, les dégats, le nom et l'état de l'arme

    public State getState() {
        return currentState;
    }
    public BufferedImage[] getWeaponSprites() {
        return weaponSprites;
    }

    public int getManaUsed() {
        return this.manaUsed;
    }

    public int getDurability() {
        return this.durability;
    }

    public int getDamage() {
        return this.damage;
    }

    public String getName() {
        return name;
    }

    public boolean getIsWeaponBroken() {
        return isWeaponBroken;
    }

    public int getSpeedAttack() {
        return attackSpeed;
    }
}

