package monster.monsterFactory;
import monster.monsterType.*;


public class OrcFactory extends MonsterFactory{
    public MonsterShare createMonster()
    {
        return new Orc();
    }
}
