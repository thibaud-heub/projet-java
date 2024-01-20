package monster.abstractFactory.monsterType;
import monster.MonsterGame.monsterStats;

public class Boss extends Monster{
    
    public Boss()
    {
        super(monsterType.BOSS, monsterStats.getStats("Boss"));
    }
}
