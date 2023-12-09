package monster.abstractFactory.monsterType;

public class MonsterShare implements Monster {
    private int mPV;
    private int mDamage;
    private double mAttackSpeed;
    private int mArmor;
    private DamageType mResistance; //le monstre peut être résistant à un élèment
    private monsterType mMonsterType; //indique si le monstre est common ou elite
    private Boolean Alive; //indique si le monstre est en vie ou mort

//caractéristique partagées par tout les monstre
    public MonsterShare (int PV, int damage, double attack_speed, int armor, DamageType resistance, monsterType Type)
    {
        this.mPV = PV;
        this.mDamage = damage;
        this.mArmor = armor;
        this.mAttackSpeed = attack_speed;
        this.mResistance = resistance;
        this.mMonsterType = Type;
        this.Alive = true; 
    };

    //recevoir une quantité définie (entier) de dégats, qui va modifier la vide du monstre
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


    public void attack (Monster other_monster) 
    {
        other_monster.take_damage(mDamage);
    }

    public void print ()
    {
        System.out.println("Vie : " + mPV);
        System.out.println("Degats : " + mDamage);
        System.out.println("Vitesse d'attaque : " + mAttackSpeed);
        System.out.println("Armur : " + mArmor);
        System.out.println("Resistance : " + mResistance);
        System.out.println("Type : " + mMonsterType + "\n");

    }

    public int getDamage ()
    {
        return mDamage;
    }

    public double getAttackSpeed()
    {
        return mAttackSpeed;
    }

    public int getPV()
    {
        return mPV;
    }

    public int getArmor()
    {
        return mArmor;
    }

    public DamageType getResistance()
    {
        return mResistance;
    }

    public boolean getAlive()
    {
        return Alive;
    }
}

