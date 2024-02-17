package entity.abstractFactory.monsterType.Gobelin;
import entity.MonsterGame.monsterStats;
import entity.abstractFactory.monsterType.Monster;

/**
 * Implémentation de la classe gobelin, extension de la classe Monster
 */
public class EliteGobelin extends Monster{

    public EliteGobelin () 
    {
       super(monsterType.ELITE, monsterStats.elite(monsterStats.getStats("Gobelin")), 20, 2,8);

       String[] idlePaths = {
        "/ressources/sprites/Monster/EliteGoblin/Idle_1.png",
        "/ressources/sprites/Monster/EliteGoblin/Idle_2.png",
        "/ressources/sprites/Monster/EliteGoblin/Idle_3.png",
        "/ressources/sprites/Monster/EliteGoblin/Idle_4.png",
    };
    setIdleSprites(idlePaths);

    String[] walkPaths = {
        "/ressources/sprites/Monster/EliteGoblin/Run_1.png",
        "/ressources/sprites/Monster/EliteGoblin/Run_2.png",
        "/ressources/sprites/Monster/EliteGoblin/Run_3.png",
        "/ressources/sprites/Monster/EliteGoblin/Run_4.png",
    };
    setWalkSprites(walkPaths);

    String[] DeathPaths = {
        "/ressources/sprites/Monster/EliteGoblin/Death_1.png",
        "/ressources/sprites/Monster/EliteGoblin/Death_2.png",
        "/ressources/sprites/Monster/EliteGoblin/Death_3.png",
        "/ressources/sprites/Monster/EliteGoblin/Death_4.png",
    };
    setDeathSprites(DeathPaths);

    String[] attackPaths = {
        "/ressources/sprites/Monster/EliteGoblin/Attack_1.png",
        "/ressources/sprites/Monster/EliteGoblin/Attack_2.png",
        "/ressources/sprites/Monster/EliteGoblin/Attack_3.png",
    };
    setAttackSprites(attackPaths);
    }

    // Getters pour la vitesse

    public int getSpeed(){
        return speed;
    }
}
