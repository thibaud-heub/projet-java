package characters.abstractFactory.monsterType.Skeleton;

import characters.MonsterGame.monsterStats;
import characters.abstractFactory.monsterType.Monster;

/**
 *implémentation de la classe Skeleton Elite, extension de la classe Monster
 */
public class EliteSkeleton extends Monster {
    
    public EliteSkeleton () 
    {
       super(monsterType.ELITE, monsterStats.elite(monsterStats.getStats("Skeleton")));
    };


    @Override
    public void print() 
    {
        System.out.println("\nJe suis un squellete elite");
        super.print();
    }
}
