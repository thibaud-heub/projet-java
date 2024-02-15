package characters.abstractFactory.monsterType;
import characters.MonsterGame.monsterStats;

public class Boss extends Monster{
    
    public Boss()
    {
        super(monsterType.BOSS, monsterStats.getStats("Boss"), 100, 1);

        // Chemins des sprites
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
            "../../../../ressources/sprites/Monster/Boss/Death_2.png",
            "../../../../ressources/sprites/Monster/Boss/Death_3.png",
            "../../../../ressources/sprites/Monster/Boss/Death_4.png",
        };
        setDeathSprites(DeathPaths);

        String[] attackPaths = {
            "../../../../ressources/sprites/Monster/Boss/Attack_1.png",
            "../../../../ressources/sprites/Monster/Boss/Attack_2.png",
            "../../../../ressources/sprites/Monster/Boss/Attack_3.png",
            "../../../../ressources/sprites/Monster/Boss/Attack_4.png",
            "../../../../ressources/sprites/Monster/Boss/Attack_5.png",
            "../../../../ressources/sprites/Monster/Boss/Attack_6.png",
        };
        setAttackSprites(attackPaths);
    }
}
