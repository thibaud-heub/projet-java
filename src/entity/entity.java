package entity;

/**
 * classe abstraite qui définit une entité (monster ou character) définie les méthodes commune : attack, takeDamage ...
 */
public abstract class entity {
    private double PV;
    protected int attackSpeed;
    private Boolean Alive; //indique si le monstre est en vie ou mort
    private typeDamage resistance;
    private typeDamage damage;

    /**
     * Constructeur de la classe entity
     * @param PV : Nombre de points de vie 
     * @param Rfire : Résistance au feu
     * @param Rphysic : Résistance physique
     * @param Rmagic : Résistance magique
     * @param Dfire : Dégâts de feu
     * @param Dphysic : Dégâts physiques
     * @param Dmagic : Dégâts magiques
     */
    public entity(double PV, int Rfire, int Rphysic, int Rmagic, int Dfire, int Dphysic, int Dmagic)
    {
        this.PV = PV;
        this.Alive = true;
        this.damage = new typeDamage(Dfire, Dphysic, Dmagic);
        this.resistance = new typeDamage(Rfire, Rphysic, Rmagic);
    }

    /**
     * Retourne les dégats réel reçus, en fonction de la résistance
     * @param damage : Les dégâts de l'ennemi
     * @return : Entier représentant les dégâts réels
     */
    private double realDamage(typeDamage damage)
    {
        double fire = 0, physic = 0, magic = 0;

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
     * Reçoit une quantité définie (entier) de dégats, qui va modifier la vie de l'entité
     * @param ennemyDamage : Les dégats de l'ennemi
     * @return : Un booléen indiquant si l'entité est en vie ou morte
     */
    public Boolean take_damage (typeDamage weaponDamage) 
    {
        double damage = realDamage(weaponDamage);
        // Si les dégats dépasse la vie actuelle, ses PV tombent à 0 et il meurt
        if ((this.PV - damage)< 0) {
            this.PV = 0;
            this.Alive = false;
        }
    // Sinon on réduit ses points de vies
        else {
            this.PV -= damage;
        }
        return this.Alive;
    }



    /**
     * Méthode pour print les caractéristiques de l'entité
     */
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

    // Setters pour damage et resistance

    public void setDamage(typeDamage newDamage){
        this.damage = newDamage;
    }

    public void setResistance(typeDamage newResistance){
        this.resistance = newResistance;
    }

    public void setPV(double newPV){
        if(this.PV < 100){
            this.PV += newPV;
        }
    }


    // Getters pour les dégats, la résistance, les PV et l'état de l'entité

    public typeDamage getDamage ()
    {
        return this.damage;
    }

    public typeDamage getResistance ()
    {
        return this.resistance;
    }

    public double getPV()
    {
        return this.PV;
    }

    public boolean getAlive()
    {
        return this.Alive;
    }
     
    public int getAttackSpeed()
    {
        return this.attackSpeed;
    }

}