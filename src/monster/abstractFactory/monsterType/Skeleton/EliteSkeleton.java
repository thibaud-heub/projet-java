package monster.abstractFactory.monsterType.Skeleton;
import monster.abstractFactory.monsterType.MonsterShare;

public class EliteSkeleton extends MonsterShare {
    
    public EliteSkeleton () 
    {
       super(10, 1, 1.2 , 0, DamageType.FIRE, monsterType.ELITE);
    };

    public void attack (MonsterShare other_monster) 
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
