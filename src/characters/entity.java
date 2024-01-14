package characters;
/**
 * classe abstraite qui définit une entité (monster ou character) définie les méthodes commune : attack, takeDamage ...
 */
public abstract class entity {
    private int PV;
    private int attackSpeed;
    private Boolean Alive; //indique si le monstre est en vie ou mort
    private typeDamage resistance;
    private typeDamage damage;

    /**
     * constructeur de la classe entity
     * @param PV : entier nombr de point de vie 
     * @param attackSpeed : double vitesse d'attack
     * @param Rfire : resistance au feu
     * @param Rphysic : resistance physique
     * @param Rmagic : reistance magic
     * @param Dfire : degats de feu
     * @param Dphysic : degats physic
     * @param Dmagic : degats magic
     */
    public entity(int PV, int attackSpeed, int Rfire, int Rphysic, int Rmagic, int Dfire, int Dphysic, int Dmagic)
    {
        this.PV = PV;
        this.attackSpeed = attackSpeed;
        this.Alive = true;
        this.damage = new typeDamage(Dfire, Dphysic, Dmagic);
        this.resistance = new typeDamage(Rfire, Rphysic, Rmagic);
    }

/**
 * retoourne les dégats réel reçus, en fonction de la résistance
 * @param damage : les dégats de l'ennemie
 * @return : un entier représentant les dégats reel
 */
    private int realDamage(typeDamage damage)
    {
        int fire = 0, physic = 0, magic = 0;

        if( (fire = damage.getFire()-this.resistance.getFire()) < 0)
        {
            fire = 0;
        }

        if( (physic = damage.getPhysic()-resistance.getPhysic())< 0)
        {
            physic = 0;
        }

        if ((magic = damage.getMagic()-resistance.getMagic())<0)
        {
            magic = 0;
        }

        return fire + physic + magic;
    }

    /**
     * recevoir une quantité définie (entier) de dégats, qui va modifier la vie du monstre
     */
    public Boolean take_damage (typeDamage ennemyDamage) 
    {
        int damage = realDamage(ennemyDamage);
        if ((this.PV - damage)< 0) {//si les dégats dépasse la vie actuelle du monstre, ses PV tombent à 0 et il devient mort
            this.PV = 0;
            this.Alive = false;
        }
    //sinon en réduit ses points de vies
        else {
            this.PV -= damage;
        }
        return this.Alive;
    }

/**
 * permet d'infliger des dégats à une autre entité en appelantla méthode takeDamage de l'autre entité
 * @param other_monster : entité à attaquer
 */
    public void attack (entity otherEntity) 
    {
        otherEntity.take_damage(this.damage);
    }

    public void print()
    {
        System.out.println("Vie : " + PV);
        System.out.println("Vitesse d'attaque : " + attackSpeed);
        System.out.println("\nDegats :");
        damage.print();
        System.out.println("\nResistance :");
        resistance.print();
        System.out.println("\nEn vie : " + Alive);
    }

    public typeDamage getDamage ()
    {
        return this.damage;
    }

    public typeDamage getResistance ()
    {
        return this.resistance;
    }

    public int getPV()
    {
        return this.PV;
    }

    public boolean getAlive()
    {
        return this.Alive;
    }
     
    /**
     * renvoie la vitesse d'attaque du monstre
     * @return un double représentant la vitesse d'attaque
     */
    public int getAttackSpeed()
    {
        return this.attackSpeed;
    }

}