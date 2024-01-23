package characters.abstractFactory.monsterType.Gobelin;
import characters.MonsterGame.monsterStats;
import characters.abstractFactory.monsterType.Monster;

/**
 *implémentation de la classe gobelin, extension de la lasse Monster
 */
public class Gobelin extends Monster{

/** 
 * on utilise le construire du parent (Monster) pour implémenter le gobelin avec ses spécificité
 */    
    public Gobelin () 
    {
       super(monsterType.COMMON, monsterStats.getStats("Gobelin"));
    }

/**
 * rédifinition de la méthode attaque en réutilisant la méthode de la class parente
 */
    public void attack (Monster other_monster) 
    {
        System.out.println("Gobelin attack");
        super.attack(other_monster);
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
