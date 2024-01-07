package monster.trash;
import java.util.Map;
import monster.abstractFactory.monsterType.Monster;
import monster.game.manageMonster;
import monster.game.monsterStats;
import monster.game.probaMonster;

public class manageMonster extends manageMonster {

    static probaMonster proba;

    public manageMonster ()
    {
        proba = new probaMonster();
    }


    public Monster[] newLevel(int level)
    {
        Map<String, Double> probMonster;
        Monster[] monsters;

        probMonster = proba.sortProb(monsterStats.probaElite);
        monsters = generate(monsterStats.nbMonsterLevel, probMonster);

        return monsters;
    }

    public void endLevel(boolean end)
    {
        if(!end){
            monsterStats.upgradeAllStats();
        }
    }
    
}
