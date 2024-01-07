package monster.trash.factory.monsterFactory;
import monster.trash.factory.monsterType.*;


public class DarkWizardFactory extends MonsterFactory {
    public MonsterShare createMonster()
    {
        return new DarkWizard();
    }
}
