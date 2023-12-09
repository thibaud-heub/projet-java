package monster.abstractFactory.monsterType.Gobelin;
import monster.abstractFactory.monsterType.MonsterShare;;

//implementation de la classe gobelin elite, fille de la classe monstre
public class EliteGobelin extends MonsterShare{

//surchage du constructeur avec les stats du gobelin
    public EliteGobelin () 
    {
       super(10, 1, 1.2 , 0, DamageType.NOTHING, monsterType.ELITE);
    }

//rédifinition de la méthode attaque en réutilisant la méthode de la class parente
    public void attack (MonsterShare other_monster) 
    {
        System.out.println("Gobelin elite attack");
        super.attack(other_monster);
    }

    @Override
    public void print() 
    {
        System.out.println("\nJe suis un Gobelin elite");
        super.print();
    }
}
