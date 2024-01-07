package monster.abstractFactory.monsterType.Skeleton;
import monster.abstractFactory.monsterType.Monster;
import monster.game.monsterStats;

/**
 *implémentation de la classe Skeleton, extension de la classe Monster
 */
public class Skeleton extends Monster {
    
    public Skeleton () 
    {
       super(monsterType.COMMON, monsterStats.getStats("Skeleton"));
    };

    public void attack (Monster other_monster) 
    {
        System.out.println("Skeleton attack");
        this.attack(other_monster);
    }

    @Override
    public void print() 
    {
        System.out.println("\nJe suis un squellete");
        super.print();
    }
}
