package entity;


/**
 * Classe qui permet de définir les type de dégats, que ce soit en résistance ou en attaque. 
 * Implémente les fonctions de manipulation des attributs de la classe
 */
public class typeDamage {
    private double fire;
    private double physic;
    private double magic;

    /**
     * Constructeur de la classe typeDamage
     * @param fire : Dégâts de feu
     * @param physic : Dégâts physiques
     * @param magic : Dégâts magiques
     */
    public typeDamage (double fire, double physic, double magic)
    {
        this.fire = fire;
        this.physic = physic;
        this.magic = magic;
    }
    
    // Getters pour le feu, la physique et la magie

    public double getFire ()
    {
        return this.fire;
    }

    public double getPhysic ()
    {
        return this.physic;
    } 

    public double getMagic()
    {
        return this.magic;
    }

    // Setters les dégâts de feu, de physique et de magie

    public void setFire (double fire)
    {
        this.fire=fire;
    }

    public void setPhysic (double physic)
    {
        this.physic = physic;
    }

    public void setMagic (double magic)
    {
        this.magic = magic;
    }

    public void increaseDamage (double value){
        this.magic = Math.ceil(this.magic * value); // on arrondit au supérieur
        this.fire = Math.ceil(this.fire * value);
        this.physic = Math.ceil(this.physic * value);
    }

    
    // Méthode pour afficher les dégâts
    public void print()
    {
        System.out.println("Fire : " + fire);
        System.out.println("Physic : " + physic);
        System.out.println("Magic : " + magic);
    }
}
