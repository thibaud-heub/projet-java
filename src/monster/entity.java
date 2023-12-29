package monster;

/**
 * classe abstraite qui définit une entité (monster ou character) définie les méthodes commune : attack, takeDamage ...
 */
public abstract class entity {
    private int mPV;
    private Boolean Alive; //indique si le monstre est en vie ou mort
    private int mDamage;

    public entity(int PV, int damage, boolean alive)
    {
        this.mPV = PV;
        this.mDamage = damage;
        this.Alive = alive;
    }

    /**
     * recevoir une quantité définie (entier) de dégats, qui va modifier la vie du monstre
     */
    public void take_damage (int damage) 
    {

        if ((mPV - damage)< 0) {//si les dégats dépasse la vie actuelle du monstre, ses PV tombent à 0 et il devient mort
            mPV = 0;
            Alive = false;
        }
    //sinon en réduit ses ppints de vies
        else {
            mPV -= damage;
        }
    }

/**
 * permet d'infliger des dégats à une autre entité en appelantla méthode takeDamage de l'autre entité
 * @param other_monster : entité à attaquer
 */
    public void attack (entity otherEntity) 
    {
        otherEntity.take_damage(mDamage);
    }

    public void print()
    {
        System.out.println("Vie : " + mPV);
        System.out.println("Degats : " + mDamage);
        System.out.println("En vie : " + Alive);
    }

    public int getDamage ()
    {
        return mDamage;
    }

    public int getPV()
    {
        return mPV;
    }


    public boolean getAlive()
    {
        return Alive;
    }

}
