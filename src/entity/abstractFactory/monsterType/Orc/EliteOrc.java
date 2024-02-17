package entity.abstractFactory.monsterType.Orc;
import entity.MonsterGame.monsterStats;
import entity.abstractFactory.monsterType.Monster;

/**
 *implémentation de la classe Orc elite, extension de la classe Monster
 */
public class EliteOrc extends Monster {
    public EliteOrc () 
    {
       super(monsterType.ELITE, monsterStats.elite(monsterStats.getStats("Orc")), 20, 1,8);

    // Chemins des sprites    
    String[] idlePaths = {
        "/ressources/sprites/Monster/EliteOrc/Idle_1.png",
        "/ressources/sprites/Monster/EliteOrc/Idle_2.png",
        "/ressources/sprites/Monster/EliteOrc/Idle_3.png",
        "/ressources/sprites/Monster/EliteOrc/Idle_4.png",
    };
    setIdleSprites(idlePaths);

    String[] walkPaths = {
        "/ressources/sprites/Monster/EliteOrc/Run_1.png",
        "/ressources/sprites/Monster/EliteOrc/Run_2.png",
        "/ressources/sprites/Monster/EliteOrc/Run_3.png",
        "/ressources/sprites/Monster/EliteOrc/Run_4.png",
    };
    setWalkSprites(walkPaths);

    String[] DeathPaths = {
        "/ressources/sprites/Monster/EliteOrc/Death_1.png",
        "/ressources/sprites/Monster/EliteOrc/Death_2.png",
        "/ressources/sprites/Monster/EliteOrc/Death_3.png",
        "/ressources/sprites/Monster/EliteOrc/Death_4.png",
    };
    setDeathSprites(DeathPaths);

    String[] attackPaths = {
        "/ressources/sprites/Monster/EliteOrc/Attack_1.png",
        "/ressources/sprites/Monster/EliteOrc/Attack_2.png",
        "/ressources/sprites/Monster/EliteOrc/Attack_3.png",
    };
    setAttackSprites(attackPaths);

    };

    // Getters pour la vitesse

    public int getSpeed(){
        return speed;
    }
}