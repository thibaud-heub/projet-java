package characters.abstractFactory.monsterType.DarkWizard;
import characters.MonsterGame.monsterStats;
import characters.abstractFactory.monsterType.Monster;

/**
 *implémentation de la classe Dark Wizard Elite, extension de la classe Monster
 */
public class EliteDarkWizard extends Monster{
    public EliteDarkWizard () 
    {
       super(monsterType.ELITE, monsterStats.elite(monsterStats.getStats("DarkWizard")));
    };

    public void attack (Monster other_monster) 
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
