package weapons;

import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import entity.*;

/**
 * Classe abstraite pour les armes
 */
public abstract class weapon {
    protected String name;
    protected typeDamage damage;
    protected int durability;
    protected int manaUsed;
    protected int attackSpeed;
    protected double range;
    protected BufferedImage[] weaponSprites;
    public enum State {IDLE, ATTACK};
    private State currentState = State.IDLE;
    private boolean isWeaponBroken = false;

    public weapon(){
        this.damage = new typeDamage(0, 0, 0);
    }

    public abstract int getOffsetWeaponX();
    public abstract int getOffsetWeaponY();



    // Augmente la mana utilisée de l'arme de value
    public void increaseManaUsed(int value) {
        this.manaUsed += value;
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

    public void setDamage(typeDamage newDamage){
        this.damage = newDamage;
    }



    // Getters pour l'état, les sprites, la mana, la durabilité, les dégats, le nom et l'état de l'arme


    public double getRange() {
        return this.range;
    }
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

    public typeDamage getDamage() {
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

