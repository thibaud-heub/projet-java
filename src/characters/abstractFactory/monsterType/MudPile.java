package characters.abstractFactory.monsterType;
import characters.MonsterGame.monsterStats;

/*
 * Implémente le tas de boue
 */
public class MudPile extends Monster{
    public MudPile () 
    {
       super(monsterType.COMMON, monsterStats.getStats("MudPile"), 5);
       // Chemins des sprites
    String[] idlePaths = {
        "../../../../ressources/sprites/Monster/Muddy/Idle_1.png",
    };
    setIdleSprites(idlePaths);

    String[] walkPaths = {
        "../../../../ressources/sprites/Monster/Muddy/Run_1.png",
        "../../../../ressources/sprites/Monster/Muddy/Run_2.png",
        "../../../../ressources/sprites/Monster/Muddy/Run_3.png",
        "../../../../ressources/sprites/Monster/Muddy/Run_4.png",
    };
    setWalkSprites(walkPaths);

    String[] DeathPaths = {
        "../../../../ressources/sprites/Monster/Muddy/Death_1.png",
        "../../../../ressources/sprites/Monster/Muddy/Death_2.png",
        "../../../../ressources/sprites/Monster/Muddy/Death_3.png",
    };
    setDeathSprites(DeathPaths);
    };

    @Override
    public void print() 
    {
        System.out.println("\nJe suis un tas de boue");
        super.print();
    }

}
