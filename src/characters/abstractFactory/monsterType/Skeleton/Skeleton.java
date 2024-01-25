package characters.abstractFactory.monsterType.Skeleton;
import characters.MonsterGame.monsterStats;
import characters.abstractFactory.monsterType.Monster;

/**
 *implémentation de la classe Skeleton, extension de la classe Monster
 */
public class Skeleton extends Monster {
    
    public Skeleton () 
    {
       super(monsterType.COMMON, monsterStats.getStats("Skeleton"));


       String[] idlePaths = {
        "../../../../../ressources/sprites/Monster/Skeleton/Idle_1.png",
        "../../../../../ressources/sprites/Monster/Skeleton/Idle_2.png",
        "../../../../../ressources/sprites/Monster/Skeleton/Idle_3.png",
        "../../../../../ressources/sprites/Monster/Skeleton/Idle_4.png",
    };
    setIdleSprites(idlePaths);

    String[] walkPaths = {
        "../../../../../ressources/sprites/Monster/Skeleton/Run_1.png",
        "../../../../../ressources/sprites/Monster/Skeleton/Run_2.png",
        "../../../../../ressources/sprites/Monster/Skeleton/Run_3.png",
        "../../../../../ressources/sprites/Monster/Skeleton/Run_4.png",
    };
    setWalkSprites(walkPaths);

    String[] DeathPaths = {
        "../../../../../ressources/sprites/Monster/Skeleton/Death_1.png",
    };
    setDeathSprites(DeathPaths);


    };

    @Override
    public void print() 
    {
        System.out.println("\nJe suis un squellete");
        super.print();
    }
}
