package characters;


/**
 * Classe qui permet de définir les type de dégats, que ce soit en résistance ou en attaque. 
 * Implémente les fonctions de manipulation des attributs de la classe
 */
public class typeDamage {
    private int fire;
    private int physic;
    private int magic;

    /**
     * Constructeur de la classe typeDamage
     * @param fire : Dégâts de feu
     * @param physic : Dégâts physiques
     * @param magic : Dégâts magiques
     */
    public typeDamage (int fire, int physic, int magic)
    {
        this.fire = fire;
        this.physic = physic;
        this.magic = magic;
    }
    
    // Getters pour le feu, la physique et la magie

    public int getFire ()
    {
        return this.fire;
    }

    public int getPhysic ()
    {
        return this.physic;
    } 

    public int getMagic()
    {
        return this.magic;
    }

    // Setters les dégâts de feu, de physique et de magie

    public void setFire (int fire)
    {
        this.fire=fire;
    }

    public void setPhysic (int physic)
    {
        this.physic = physic;
    }

    public void setMagic (int magic)
    {
        this.magic = magic;
    }


    // Méthode pour afficher les dégâts
    public void print()
    {
        System.out.println("Fire : " + fire);
        System.out.println("Physic : " + physic);
        System.out.println("Magic : " + magic);
    }
}
