package monster.trash.factory.monsterFactory;
import monster.trash.factory.monsterType.*;

public class GobelinFactory extends MonsterFactory{
    public MonsterShare createMonster()
    {
        return new Gobelin();
    }
}
