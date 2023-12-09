package monster.factory.monsterType;

public class Skeleton extends MonsterShare {
    
    public Skeleton () 
    {
       super(10, 1, 1.2 , 0, DamageType.FIRE);
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
