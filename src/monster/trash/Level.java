package monster.trash;

import java.util.Map;
import monster.abstractFactory.monsterType.Monster;
import monster.game.manageMonster;
import monster.game.probaMonster;
import monster.trash.*;

public class Level extends TreeNode{

    static int difficulty = 0;

    public enum typeLevel {SALER, CHEST, }
    
    private int levelID;
    private Map<String, Double> probMonsters;
    Monster[] monsters;
    private int nbMonster;

    public Level(int nbM)
    {
        this.nbMonster = nbM;
        probMonsters = probaMonster.sortProb(difficulty/10.0);
        monsters = manageMonster.generateMonster(nbMonster, probMonsters);
    }
}
