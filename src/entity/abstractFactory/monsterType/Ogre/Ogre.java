package entity.abstractFactory.monsterType.Ogre;
import entity.MonsterGame.monsterStats;
import entity.abstractFactory.monsterType.Monster;

/**
 * Implémentation de la classe ogre, extension de la classe Monster
 */
public class Ogre extends Monster{

    public Ogre () 
    {
       super(monsterType.COMMON, monsterStats.getStats("Ogre"), 20, 1,16);

    // Chemins des sprites    
    String[] idlePaths = {
        "/ressources/sprites/Monster/Ogre/Idle_1.png",
        "/ressources/sprites/Monster/Ogre/Idle_2.png",
        "/ressources/sprites/Monster/Ogre/Idle_3.png",
        "/ressources/sprites/Monster/Ogre/Idle_4.png",
    };
    setIdleSprites(idlePaths);

    String[] walkPaths = {
        "/ressources/sprites/Monster/Ogre/Run_1.png",
        "/ressources/sprites/Monster/Ogre/Run_2.png",
        "/ressources/sprites/Monster/Ogre/Run_3.png",
        "/ressources/sprites/Monster/Ogre/Run_4.png",
    };
    setWalkSprites(walkPaths);

    String[] DeathPaths = {
        "/ressources/sprites/Monster/Ogre/Death_1.png",
        "/ressources/sprites/Monster/Ogre/Death_2.png",
        "/ressources/sprites/Monster/Ogre/Death_3.png",
        "/ressources/sprites/Monster/Ogre/Death_4.png",

    };
    setDeathSprites(DeathPaths);

    String[] attackPaths = {
        "/ressources/sprites/Monster/Ogre/Attack_1.png",
        "/ressources/sprites/Monster/Ogre/Attack_2.png",
        "/ressources/sprites/Monster/Ogre/Attack_3.png",
        "/ressources/sprites/Monster/Ogre/Attack_4.png",
        "/ressources/sprites/Monster/Ogre/Attack_5.png",
        "/ressources/sprites/Monster/Ogre/Attack_6.png"
    };
    setAttackSprites(attackPaths);
    };
    

    // Getters pour la vitesse

    public int getSpeed(){
        return speed;
    }
}
