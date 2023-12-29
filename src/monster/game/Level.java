package monster.game;

import java.util.Map;
import monster.abstractFactory.monsterType.Monster;
import monster.list.*;

public class Level extends tree{

    static int difficulty = 0;

    public enum typeLevel {SALER, CHEST, }
    
    private int levelID;
    private Map<String, Double> probMonsters;
    Monster[] monsters;
    private int nbMonster;

    public Level(int nbM)
    {
        this.nbMonster = nbM;
        probMonsters = proba.sortProb(difficulty/10.0);
        monsters = ManageMonster.generateMonster(nbMonster, probMonsters);
    }
}
