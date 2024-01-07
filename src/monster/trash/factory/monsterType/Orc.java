package monster.trash.factory.monsterType;

public class Orc extends MonsterShare {
    public Orc () 
    {
       super(10, 1, 1.2 , 0, DamageType.FIRE);
    };

    public void attack (MonsterShare other_monster) 
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
