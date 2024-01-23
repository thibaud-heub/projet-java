package characters.abstractFactory.monsterType;
import characters.MonsterGame.monsterStats;

public class Boss extends Monster{
    
    public Boss()
    {
        super(monsterType.BOSS, monsterStats.getStats("Boss"));
    }
}
