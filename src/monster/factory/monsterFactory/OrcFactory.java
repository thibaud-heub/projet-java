package monster.factory.monsterFactory;
import monster.factory.monsterType.*;

public class OrcFactory extends MonsterFactory{
    public MonsterShare createMonster()
    {
        return new Orc();
    }
}
