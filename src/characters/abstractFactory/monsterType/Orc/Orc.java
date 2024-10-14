package characters.abstractFactory.monsterType.Orc;
import characters.MonsterGame.monsterStats;
import characters.abstractFactory.monsterType.Monster;

/**
 *implémentation de la classe Orc, extension de la classe Monster
 */
public class Orc extends Monster {
    public Orc () 
    {
       super(monsterType.COMMON, monsterStats.getStats("Orc"));
    };

    public void attack (Monster other_monster) 
    {
        System.out.println("Orc attack");
        this.attack(other_monster);
    }
    
    @Override
    public void print() 
    {
        System.out.println("\nJe suis un Orc");
        super.print();
    }
}
