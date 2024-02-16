package entity.abstractFactory.monsterType.Gobelin;
import entity.MonsterGame.monsterStats;
import entity.abstractFactory.monsterType.Monster;

/**
 *implémentation de la classe gobelin, extension de la lasse Monster
 */
public class Gobelin extends Monster{

/** 
 * on utilise le construire du parent (Monster) pour implémenter le gobelin avec ses spécificité
 */    
    public Gobelin () 
    {
       super(monsterType.COMMON, monsterStats.getStats("Gobelin"), 10, 1.2,8);

       String[] idlePaths = {
        "/ressources/sprites/Monster/Goblin/Idle_1.png",
        "/ressources/sprites/Monster/Goblin/Idle_2.png",
        "/ressources/sprites/Monster/Goblin/Idle_3.png",
        "/ressources/sprites/Monster/Goblin/Idle_4.png",
    };
    setIdleSprites(idlePaths);

    String[] walkPaths = {
        "/ressources/sprites/Monster/Goblin/Run_1.png",
        "/ressources/sprites/Monster/Goblin/Run_2.png",
        "/ressources/sprites/Monster/Goblin/Run_3.png",
        "/ressources/sprites/Monster/Goblin/Run_4.png",
    };
    setWalkSprites(walkPaths);

    String[] DeathPaths = {
        "/ressources/sprites/Monster/Goblin/Death_1.png",
        "/ressources/sprites/Monster/Goblin/Death_2.png",
        "/ressources/sprites/Monster/Goblin/Death_3.png",
        "/ressources/sprites/Monster/Goblin/Death_4.png",
    };
    setDeathSprites(DeathPaths);

    String[] attackPaths = {
        "/ressources/sprites/Monster/Goblin/Attack_1.png",
        "/ressources/sprites/Monster/Goblin/Attack_2.png",
        "/ressources/sprites/Monster/Goblin/Attack_3.png",
    };
    setAttackSprites(attackPaths);
    
    }
    /**
     * redéfinition de la méthode afin de l'adapter au gobelin
     */
    @Override
    public void print() 
    {
        System.out.println("\nJe suis un Gobelin");
        super.print();
    }
}
