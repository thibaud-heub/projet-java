package characters.abstractFactory.monsterType.Ogre;
import characters.MonsterGame.monsterStats;
import characters.abstractFactory.monsterType.Monster;

/**
 *implémentation de la classe ogre, extension de la classe Monster
 */
public class Ogre extends Monster{

    /** 
 * surchage du constructeur avec les stats du ogre en appelant le constructeur du parent
 */
    public Ogre () 
    {
       super(monsterType.COMMON, monsterStats.getStats("Ogre"));

       String[] idlePaths = {
        "../../../../../ressources/sprites/Monster/Ogre/Idle_1.png",
        "../../../../../ressources/sprites/Monster/Ogre/Idle_2.png",
        "../../../../../ressources/sprites/Monster/Ogre/Idle_3.png",
        "../../../../../ressources/sprites/Monster/Ogre/Idle_4.png",
    };
    setIdleSprites(idlePaths);

    String[] walkPaths = {
        "../../../../../ressources/sprites/Monster/Ogre/Run_1.png",
        "../../../../../ressources/sprites/Monster/Ogre/Run_2.png",
        "../../../../../ressources/sprites/Monster/Ogre/Run_3.png",
        "../../../../../ressources/sprites/Monster/Ogre/Run_4.png",
    };
    setWalkSprites(walkPaths);

    String[] DeathPaths = {
        "../../../../../ressources/sprites/Monster/Ogre/Death_1.png",
    };
    setDeathSprites(DeathPaths);
    };
    

    public void attack (Monster other_monster) 
    {
        System.out.println("Ogre attack");
        this.attack(other_monster);
    }

    @Override
    public void print() 
    {
        System.out.println("\nJe suis un Ogre");
        super.print();
    }
}
