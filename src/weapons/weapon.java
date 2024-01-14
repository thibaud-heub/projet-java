package weapons;

/**
 * Classe abstraite pour les armes
 */
public abstract class weapon {
    protected String name;
    protected int damage;
    protected int durability;
    protected int manaUsed;


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
}

