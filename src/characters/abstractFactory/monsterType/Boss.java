package characters.abstractFactory.monsterType;
import characters.MonsterGame.monsterStats;

public class Boss extends Monster{
    
    public Boss()
    {
        super(monsterType.BOSS, monsterStats.getStats("Boss"));

        String[] idlePaths = {
            "../../../../ressources/sprites/Monster/Boss/Idle_1.png",
            "../../../../ressources/sprites/Monster/Boss/Idle_2.png",
            "../../../../ressources/sprites/Monster/Boss/Idle_3.png",
            "../../../../ressources/sprites/Monster/Boss/Idle_4.png",
        };
        setIdleSprites(idlePaths);
    
        String[] walkPaths = {
            "../../../../ressources/sprites/Monster/Boss/Run_1.png",
            "../../../../ressources/sprites/Monster/Boss/Run_2.png",
            "../../../../ressources/sprites/Monster/Boss/Run_3.png",
            "../../../../ressources/sprites/Monster/Boss/Run_4.png",
        };
        setWalkSprites(walkPaths);
    
        String[] DeathPaths = {
            "../../../../ressources/sprites/Monster/Boss/Death_1.png",
        };
        setDeathSprites(DeathPaths);
    }
}
