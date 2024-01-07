package monster.trash.factory.monsterType;


//implementation de la classe gobelin, fille de la classe monstre
public class Gobelin extends MonsterShare{

//surchage du constructeur avec les stats du gobelin
    public Gobelin () 
    {
       super(10, 1, 1.2 , 0, DamageType.NOTHING);
    }

//rédifinition de la méthode attaque en réutilisant la méthode de la class parente
    public void attack (MonsterShare other_monster) 
    {
        System.out.println("Gobelin attack");
        super.attack(other_monster);
    }

    @Override
    public void print() 
    {
        System.out.println("\nJe suis un Gobelin");
        super.print();
    }
}
