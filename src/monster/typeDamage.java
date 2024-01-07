package monster;

/**
 * classe qui permet de définir les type de dégats, que ce soit en resistance ou en attaque. Implémente les fonctions de manipulation des attributs de la classe
 */
public class typeDamage {
    private int fire;
    private int physic;
    private int magic;

    public typeDamage (int fire, int physic, int magic)
    {
        this.fire = fire;
        this.physic = physic;
        this.magic = magic;
    }
    
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

    public void changeFire (int fire)
    {
        this.fire=fire;
    }

    public void changePhysic (int physic)
    {
        this.physic = physic;
    }

    public void changeMagic (int magic)
    {
        this.magic = magic;
    }

    public void print()
    {
        System.out.println("Fire : " + fire);
        System.out.println("Physic : " + physic);
        System.out.println("Magic : " + magic);
    }
}

