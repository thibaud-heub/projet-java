package monster.factory.monsterFactory;
import monster.factory.monsterType.*;

public class SkeletonFactory extends MonsterFactory {
    
    public MonsterShare createMonster()
    {
        return new Skeleton();
    }
}
