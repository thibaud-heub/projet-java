package characters.abstractFactory.monsterType.Gobelin;
import characters.MonsterGame.monsterStats;
import characters.abstractFactory.monsterType.Monster;

/**
 * Implémentation de la classe gobelin, extension de la classe Monster
 */
public class EliteGobelin extends Monster{

    public EliteGobelin () 
    {
       super(monsterType.ELITE, monsterStats.elite(monsterStats.getStats("Gobelin")), 20);

       String[] idlePaths = {
        "../../../../../ressources/sprites/Monster/EliteGoblin/Idle_1.png",
        "../../../../../ressources/sprites/Monster/EliteGoblin/Idle_2.png",
        "../../../../../ressources/sprites/Monster/EliteGoblin/Idle_3.png",
        "../../../../../ressources/sprites/Monster/EliteGoblin/Idle_4.png",
    };
    setIdleSprites(idlePaths);

    String[] walkPaths = {
        "../../../../../ressources/sprites/Monster/EliteGoblin/Run_1.png",
        "../../../../../ressources/sprites/Monster/EliteGoblin/Run_2.png",
        "../../../../../ressources/sprites/Monster/EliteGoblin/Run_3.png",
        "../../../../../ressources/sprites/Monster/EliteGoblin/Run_4.png",
    };
    setWalkSprites(walkPaths);

    String[] DeathPaths = {
        "../../../../../ressources/sprites/Monster/EliteGoblin/Death_1.png",
        "../../../../../ressources/sprites/Monster/EliteGoblin/Death_2.png",
        "../../../../../ressources/sprites/Monster/EliteGoblin/Death_3.png",
    };
    setDeathSprites(DeathPaths);

    String[] attackPaths = {
        "../../../../../ressources/sprites/Monster/EliteGoblin/Attack_1.png",
        "../../../../../ressources/sprites/Monster/EliteGoblin/Attack_2.png",
        "../../../../../ressources/sprites/Monster/EliteGoblin/Attack_3.png",
    };
    setAttackSprites(attackPaths);
    }

    @Override
    public void print() 
    {
        System.out.println("\nJe suis un Gobelin elite");
        super.print();
    }
}
