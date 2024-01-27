package characters.abstractFactory.monsterType.Ogre;
import characters.MonsterGame.monsterStats;
import characters.abstractFactory.monsterType.Monster;

/**
 * Implémentation de la classe OgreElite Elite, extension de la classe Monster
 */
public class EliteOgre extends Monster{
    public EliteOgre () 
    {
       super(monsterType.ELITE, monsterStats.elite(monsterStats.getStats("EliteOgre")), 40);

    // Chemins des sprites
    String[] idlePaths = {
        "../../../../../ressources/sprites/Monster/EliteOgre/Idle_1.png",
        "../../../../../ressources/sprites/Monster/EliteOgre/Idle_2.png",
        "../../../../../ressources/sprites/Monster/EliteOgre/Idle_3.png",
        "../../../../../ressources/sprites/Monster/EliteOgre/Idle_4.png",
    };
    setIdleSprites(idlePaths);

    String[] walkPaths = {
        "../../../../../ressources/sprites/Monster/EliteOgre/Run_1.png",
        "../../../../../ressources/sprites/Monster/EliteOgre/Run_2.png",
        "../../../../../ressources/sprites/Monster/EliteOgre/Run_3.png",
        "../../../../../ressources/sprites/Monster/EliteOgre/Run_4.png",
    };
    setWalkSprites(walkPaths);

    String[] DeathPaths = {
        "../../../../../ressources/sprites/Monster/EliteOgre/Death_1.png",
        "../../../../../ressources/sprites/Monster/EliteOgre/Death_2.png",
        "../../../../../ressources/sprites/Monster/EliteOgre/Death_3.png",
    };
    setDeathSprites(DeathPaths);

    String[] attackPaths = {
        "../../../../../ressources/sprites/Monster/EliteOgre/Attack_1.png",
        "../../../../../ressources/sprites/Monster/EliteOgre/Attack_2.png",
        "../../../../../ressources/sprites/Monster/EliteOgre/Attack_3.png",
    };
    setAttackSprites(attackPaths);
    };

    public void attack (Monster other_monster) 
    {
        System.out.println("Ogre elite attack");
        this.attack(other_monster);
    }

    @Override
    public void print() 
    {
        System.out.println("\nJe suis un Ogre élite");
        super.print();
    }
}
