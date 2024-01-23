package characters.abstractFactory.monsterType.DarkWizard;
import characters.MonsterGame.monsterStats;
import characters.abstractFactory.monsterType.Monster;

/**
 *implémentation de la classe Dark Wizard, extension de la classe Monster
 */
public class DarkWizard extends Monster{

    /** 
 * surchage du constructeur avec les stats du Dark Wizard en appelant le constructeur du parent
 */
    public DarkWizard () 
    {
       super(monsterType.COMMON, monsterStats.getStats("DarkWizard"));
    }

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
