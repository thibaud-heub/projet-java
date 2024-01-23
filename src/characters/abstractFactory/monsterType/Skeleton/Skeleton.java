package characters.abstractFactory.monsterType.Skeleton;
import characters.MonsterGame.monsterStats;
import characters.abstractFactory.monsterType.Monster;

/**
 *implémentation de la classe Skeleton, extension de la classe Monster
 */
public class Skeleton extends Monster {
    
    public Skeleton () 
    {
       super(monsterType.COMMON, monsterStats.getStats("Skeleton"));
    };

    @Override
    public void print() 
    {
        System.out.println("\nJe suis un squellete");
        super.print();
    }
}
