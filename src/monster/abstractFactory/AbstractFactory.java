package monster.abstractFactory;
import monster.abstractFactory.monsterType.Monster;

/** 
 * interface des fabriques de monstre, une de monstres elites et l'autres de monstre commun
 */
public interface AbstractFactory {
    Monster createDarkWizard();
    Monster createGobelin();
    Monster createOrc();
    Monster createSkeleton();
    
}