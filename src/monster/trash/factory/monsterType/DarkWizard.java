package monster.trash.factory.monsterType;

public class DarkWizard extends MonsterShare{
    public DarkWizard () 
    {
       super(7, 2, 1, 0, DamageType.MAGIC);
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
