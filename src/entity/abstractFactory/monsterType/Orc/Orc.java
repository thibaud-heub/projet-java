package entity.abstractFactory.monsterType.Orc;
import entity.MonsterGame.monsterStats;
import entity.abstractFactory.monsterType.Monster;

/**
 *implémentation de la classe Orc, extension de la classe Monster
 */
public class Orc extends Monster {
    public Orc () 
    {
       super(monsterType.COMMON, monsterStats.getStats("Orc"), 10, 1,8);

    // Chemins des sprites    
    String[] idlePaths = {
        "/ressources/sprites/Monster/Orc/Idle_1.png",
        "/ressources/sprites/Monster/Orc/Idle_2.png",
        "/ressources/sprites/Monster/Orc/Idle_3.png",
        "/ressources/sprites/Monster/Orc/Idle_4.png",
    };
    setIdleSprites(idlePaths);

    String[] walkPaths = {
        "/ressources/sprites/Monster/Orc/Run_1.png",
        "/ressources/sprites/Monster/Orc/Run_2.png",
        "/ressources/sprites/Monster/Orc/Run_3.png",
        "/ressources/sprites/Monster/Orc/Run_4.png",
    };
    setWalkSprites(walkPaths);

    String[] DeathPaths = {
        "/ressources/sprites/Monster/Orc/Death_1.png",
        "/ressources/sprites/Monster/Orc/Death_2.png",
        "/ressources/sprites/Monster/Orc/Death_3.png",
        "/ressources/sprites/Monster/Orc/Death_4.png",
    };
    setDeathSprites(DeathPaths);

    String[] attackPaths = {
        "/ressources/sprites/Monster/Orc/Attack_1.png",
        "/ressources/sprites/Monster/Orc/Attack_2.png",
        "/ressources/sprites/Monster/Orc/Attack_3.png",
    };
    setAttackSprites(attackPaths);
    
    };

    // Getters pour la vitesse

    public int getSpeed(){
        return speed;
    }
}
