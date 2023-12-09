package monster.factory.monsterFactory;
import monster.factory.monsterType.*;

public class MudPileFactory extends MonsterFactory {
    public MonsterShare createMonster()
    {
        return new MudPile();
    }
}
