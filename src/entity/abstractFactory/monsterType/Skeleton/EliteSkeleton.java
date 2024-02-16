package entity.abstractFactory.monsterType.Skeleton;

import entity.MonsterGame.monsterStats;
import entity.abstractFactory.monsterType.Monster;

/**
 *implémentation de la classe Skeleton Elite, extension de la classe Monster
 */
public class EliteSkeleton extends Monster {
    
    public EliteSkeleton () 
    {
       super(monsterType.ELITE, monsterStats.elite(monsterStats.getStats("Skeleton")), 16, 1.1,8);

    // Chemins des sprites
    String[] idlePaths = {
        "/ressources/sprites/Monster/EliteSkeleton/Idle_1.png",
        "/ressources/sprites/Monster/EliteSkeleton/Idle_2.png",
        "/ressources/sprites/Monster/EliteSkeleton/Idle_3.png",
        "/ressources/sprites/Monster/EliteSkeleton/Idle_4.png",
    };
    setIdleSprites(idlePaths);

    String[] walkPaths = {
        "/ressources/sprites/Monster/EliteSkeleton/Run_1.png",
        "/ressources/sprites/Monster/EliteSkeleton/Run_2.png",
        "/ressources/sprites/Monster/EliteSkeleton/Run_3.png",
        "/ressources/sprites/Monster/EliteSkeleton/Run_4.png",
    };
    setWalkSprites(walkPaths);

    String[] DeathPaths = {
        "/ressources/sprites/Monster/EliteSkeleton/Death_1.png",
        "/ressources/sprites/Monster/EliteSkeleton/Death_2.png",
        "/ressources/sprites/Monster/EliteSkeleton/Death_3.png",
        "/ressources/sprites/Monster/EliteSkeleton/Death_4.png",
    };
    setDeathSprites(DeathPaths);

    String[] attackPaths = {
        "/ressources/sprites/Monster/EliteSkeleton/Attack_1.png",
        "/ressources/sprites/Monster/EliteSkeleton/Attack_2.png",
        "/ressources/sprites/Monster/EliteSkeleton/Attack_3.png",
    };
    setAttackSprites(attackPaths);
    };

    
    
    
    @Override
    public void print() 
    {
        System.out.println("\nJe suis un squellete elite");
        super.print();
    }
}
