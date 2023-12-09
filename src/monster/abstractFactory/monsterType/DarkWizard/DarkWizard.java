package monster.abstractFactory.monsterType.DarkWizard;
import monster.abstractFactory.monsterType.MonsterShare;

public class DarkWizard extends MonsterShare{
    public DarkWizard () 
    {
       super(7, 2, 1, 0, DamageType.MAGIC, monsterType.COMMON);
    };

    public void attack (MonsterShare other_monster) 
    {
        System.out.println("Dark Wizard attack");
        this.attack(other_monster);
    }

    @Override
    public void print() 
    {
        System.out.println("\nJe suis un Mage noir");
        super.print();
    }
}
