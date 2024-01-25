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
    protected BufferedImage[] weaponSprites;
    public enum State {IDLE, ATTACK};
    private State currentState = State.IDLE;


    public abstract int getOffsetWeaponX();
    public abstract int getOffsetWeaponY();

    public String getName() {
        return name;
    }

    public void attack() {
        System.out.println("Attaque avec " + name + " pour " + damage + " points de dégâts" + " et -" + manaUsed + " points de mana !");
    }

    /**
     * Retourne les dégâts de l'arme
     * @return
     */
    public int getManaUsed() {
        return this.manaUsed;
    }

    /**
     * Diminue la durabilité de l'arme de 1
     */
    public void decreaseDurability() {
        this.durability -= 1; 
        if (this.durability <= 0) {
            System.out.println("L'arme " + this.name + " est cassée !");
        }
    }

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


    public BufferedImage[] getWeaponSprites() {
        return weaponSprites;
    }

    
    public void setState(State newState) {
        this.currentState = newState;
    }

    public State getState() {
        return currentState;
    }
}

