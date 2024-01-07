package monster.trash.factory.monsterFactory;
import monster.trash.factory.monsterType.*;

public class MudPileFactory extends MonsterFactory {
    public MonsterShare createMonster()
    {
        return new MudPile();
    }
}
