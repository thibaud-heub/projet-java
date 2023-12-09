package monster.abstractFactory.monsterType.Orc;
import monster.abstractFactory.monsterType.MonsterShare;

public class EliteOrc extends MonsterShare {
    public EliteOrc () 
    {
       super(10, 1, 1.2 , 2, DamageType.FIRE, monsterType.ELITE);
    };

    public void attack (MonsterShare other_monster) 
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