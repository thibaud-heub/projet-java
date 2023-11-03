package weapons;

public abstract class weapon {
    protected String name;
    protected int damage;
    protected int durability;
    protected int mana_used;


    public String getName() {
        return name;
    }

    public void attack() {
        System.out.println("Attaque avec " + name + " pour " + damage + " points de dégâts" + " et -" + mana_used + " points de mana !");
    }
}

