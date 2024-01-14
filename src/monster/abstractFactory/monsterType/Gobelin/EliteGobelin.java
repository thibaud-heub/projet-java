package monster.abstractFactory.monsterType.Gobelin;
import monster.MonsterGame.monsterStats;
import monster.abstractFactory.monsterType.Monster;

/**
 *implémentation de la classe gobelin, extension de la lasse Monster
 */
public class EliteGobelin extends Monster{

/** 
 * surchage du constructeur avec les stats du gobelin élite en appelant le constructeur du parent
 */
    public EliteGobelin () 
    {
       super(monsterType.ELITE, monsterStats.elite(monsterStats.getStats("Gobelin")));
    }

/** 
 * rédifinition de la méthode attaque en réutilisant la méthode de la class parente
 */
    public void attack (Monster other_monster) 
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
