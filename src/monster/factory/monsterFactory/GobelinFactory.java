package monster.factory.monsterFactory;
import monster.factory.monsterType.*;

public class GobelinFactory extends MonsterFactory{
    public MonsterShare createMonster()
    {
        return new Gobelin();
    }
}
