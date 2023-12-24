package monster.abstractFactory.monsterType.Orc;
import monster.abstractFactory.monsterType.Monster;

public class EliteOrc extends Monster {
    public EliteOrc () 
    {
       super(10, 1, 1.2 , 2, DamageType.FIRE, monsterType.ELITE);
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