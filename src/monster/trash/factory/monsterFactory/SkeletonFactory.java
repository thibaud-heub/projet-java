package monster.trash.factory.monsterFactory;
import monster.trash.factory.monsterType.*;

public class SkeletonFactory extends MonsterFactory {
    
    public MonsterShare createMonster()
    {
        return new Skeleton();
    }
}
