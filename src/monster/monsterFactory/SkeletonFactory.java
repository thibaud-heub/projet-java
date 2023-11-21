package monster.monsterFactory;
import monster.monsterType.*;

public class SkeletonFactory extends MonsterFactory {
    
    public MonsterShare createMonster()
    {
        return new Skeleton();
    }
}
