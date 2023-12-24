package monster.abstractFactory.monsterType.Skeleton;
import monster.abstractFactory.monsterType.Monster;

public class Skeleton extends Monster {
    
    public Skeleton () 
    {
       super(10, 1, 1.2 , 0, DamageType.FIRE, monsterType.COMMON);
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
