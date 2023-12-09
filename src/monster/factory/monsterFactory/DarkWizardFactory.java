package monster.factory.monsterFactory;
import monster.factory.monsterType.*;


public class DarkWizardFactory extends MonsterFactory {
    public MonsterShare createMonster()
    {
        return new DarkWizard();
    }
}
