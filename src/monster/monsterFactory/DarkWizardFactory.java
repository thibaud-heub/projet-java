package monster.monsterFactory;
import monster.monsterType.*;

public class DarkWizardFactory extends MonsterFactory {
    public MonsterShare createMonster()
    {
        return new DarkWizard();
    }
}
