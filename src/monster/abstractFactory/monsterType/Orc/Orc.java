package monster.abstractFactory.monsterType.Orc;
import monster.abstractFactory.monsterType.Monster;

public class Orc extends Monster {
    public Orc () 
    {
       super(10, 1, 1.2 , 0, DamageType.FIRE, monsterType.COMMON);
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
