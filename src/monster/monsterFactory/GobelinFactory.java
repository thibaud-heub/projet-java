package monster.monsterFactory;
import monster.monsterType.*;


public class GobelinFactory extends MonsterFactory{
    public MonsterShare createMonster()
    {
        return new Gobelin();
    }
}
