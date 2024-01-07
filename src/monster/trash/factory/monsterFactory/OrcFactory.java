package monster.trash.factory.monsterFactory;
import monster.trash.factory.monsterType.*;

public class OrcFactory extends MonsterFactory{
    public MonsterShare createMonster()
    {
        return new Orc();
    }
}
