package weapons;

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
    
    public int getManaUsed() {
        return this.manaUsed;
    }

    public void decreaseDurability() {
        this.durability -= 1; // Ou une autre logique pour la diminution de la durabilité
        if (this.durability <= 0) {
            System.out.println("L'arme " + this.name + " est cassée !");
            // Logique supplémentaire pour gérer une arme cassée
        }
    }
}

