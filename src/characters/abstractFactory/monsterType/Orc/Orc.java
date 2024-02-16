package characters.abstractFactory.monsterType.Orc;
import characters.MonsterGame.monsterStats;
import characters.abstractFactory.monsterType.Monster;

/**
 *implémentation de la classe Orc, extension de la classe Monster
 */
public class Orc extends Monster {
    public Orc () 
    {
       super(monsterType.COMMON, monsterStats.getStats("Orc"), 10, 0.9,8);

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

    public void attack (Monster other_monster) 
    {
        System.out.println("Orc attack");
        this.attack(other_monster);
    }
    
    @Override
    public void print() 
    {
        System.out.println("\nJe suis un Orc");
        super.print();
    }
}
