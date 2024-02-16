package entity.abstractFactory.monsterType.Skeleton;
import entity.MonsterGame.monsterStats;
import entity.abstractFactory.monsterType.Monster;

/**
 *implémentation de la classe Skeleton, extension de la classe Monster
 */
public class Skeleton extends Monster {
    
    public Skeleton () 
    {
       super(monsterType.COMMON, monsterStats.getStats("Skeleton"), 8, 1.1, 8);

    // Chemins des sprites    
    String[] idlePaths = {
        "/ressources/sprites/Monster/Skeleton/Idle_1.png",
        "/ressources/sprites/Monster/Skeleton/Idle_2.png",
        "/ressources/sprites/Monster/Skeleton/Idle_3.png",
        "/ressources/sprites/Monster/Skeleton/Idle_4.png",
    };
    setIdleSprites(idlePaths);

    String[] walkPaths = {
        "/ressources/sprites/Monster/Skeleton/Run_1.png",
        "/ressources/sprites/Monster/Skeleton/Run_2.png",
        "/ressources/sprites/Monster/Skeleton/Run_3.png",
        "/ressources/sprites/Monster/Skeleton/Run_4.png",
    };
    setWalkSprites(walkPaths);

    String[] DeathPaths = {
        "/ressources/sprites/Monster/Skeleton/Death_1.png",
        "/ressources/sprites/Monster/Skeleton/Death_2.png",
        "/ressources/sprites/Monster/Skeleton/Death_3.png",
        "/ressources/sprites/Monster/Skeleton/Death_4.png",
    };
    setDeathSprites(DeathPaths);

    String[] attackPaths = {
        "/ressources/sprites/Monster/Skeleton/Attack_1.png",
        "/ressources/sprites/Monster/Skeleton/Attack_2.png",
        "/ressources/sprites/Monster/Skeleton/Attack_3.png",
    };

    setAttackSprites(attackPaths);
    };

    @Override
    public void print() 
    {
        System.out.println("\nJe suis un squellete");
        super.print();
    }
}
