package monster.monsterFactory;
import monster.monsterType.*;

public class MudPileFactory extends MonsterFactory {
    public MonsterShare createMonster()
    {
        return new MudPile();
    }
}
