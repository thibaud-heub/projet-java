package monster.abstractFactory.monsterType;

import monster.entity;

public abstract class Monster extends entity {

    public enum DamageType {NOTHING, FIRE, MAGIC, PHYSIC}
    public enum monsterType {COMMON, ELITE}
    
    private double mAttackSpeed;
    private int mArmor;
    private DamageType mResistance; //le monstre peut être résistant à un élèment
    private monsterType mMonsterType; //indique si le monstre est common ou elite

/**
 * constructeur de la classe monstre, permet de créer un monstre en définissant tous ses paremètres
 * @param PV le nombre de point de vie du monstre
 * @param damage dégats du monstre
 * @param attack_speed : vitesse d'attaque
 * @param armor : armor du monstre
 * @param resistance : résistance a un type de dégat
 * @param Type : type du monstre : commun ou elite
 */
    public Monster (int PV, int damage, double attack_speed, int armor, DamageType resistance, monsterType Type)
    {
        super(PV, damage, true);
        this.mArmor = armor;
        this.mAttackSpeed = attack_speed;
        this.mResistance = resistance;
        this.mMonsterType = Type;
    };

    public void print ()
    {
        super.print();
        System.out.println("Vitesse d'attaque : " + mAttackSpeed);
        System.out.println("Armur : " + mArmor);
        System.out.println("Resistance : " + mResistance);
        System.out.println("Type : " + mMonsterType + "\n");
    }
    
    public double getAttackSpeed()
    {
        return mAttackSpeed;
    }

    public int getArmor()
    {
        return mArmor;
    }

    public DamageType getResistance()
    {
        return mResistance;
    }
}

