package monster.abstractFactory.monsterType.Skeleton;

import monster.MonsterGame.monsterStats;
import monster.abstractFactory.monsterType.Monster;

/**
 *implémentation de la classe Skeleton Elite, extension de la classe Monster
 */
public class EliteSkeleton extends Monster {
    
    public EliteSkeleton () 
    {
       super(monsterType.ELITE, monsterStats.elite(monsterStats.getStats("Skeleton")));
    };

    public void attack (Monster other_monster) 
    {
        System.out.println("Skeleton elite attack");
        this.attack(other_monster);
    }

    @Override
    public void print() 
    {
        System.out.println("\nJe suis un squellete elite");
        super.print();
    }
}
