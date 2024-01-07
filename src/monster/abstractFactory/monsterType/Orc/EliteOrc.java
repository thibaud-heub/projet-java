package monster.abstractFactory.monsterType.Orc;
import monster.abstractFactory.monsterType.Monster;
import monster.game.monsterStats;

/**
 *implémentation de la classe Orc elite, extension de la classe Monster
 */
public class EliteOrc extends Monster {
    public EliteOrc () 
    {
       super(monsterType.ELITE, monsterStats.elite(monsterStats.getStats("Orc")));
    };

    public void attack (Monster other_monster) 
    {
        System.out.println("Orc elite attack");
        this.attack(other_monster);
    }

    @Override
    public void print() 
    {
        System.out.println("\nJe suis un Orc elite");
        super.print();
    }
}