package monster.abstractFactory.monsterType.Skeleton;
import monster.abstractFactory.monsterType.MonsterShare;

public class Skeleton extends MonsterShare {
    
    public Skeleton () 
    {
       super(10, 1, 1.2 , 0, DamageType.FIRE, monsterType.COMMON);
    };

    public void attack (MonsterShare other_monster) 
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
