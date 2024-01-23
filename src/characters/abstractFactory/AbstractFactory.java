package characters.abstractFactory;
import characters.abstractFactory.monsterType.Monster;

/** 
 * interface des fabriques de monstre, une de monstres elites et l'autres de monstre commun
 */
public interface AbstractFactory {
    Monster createDarkWizard();
    Monster createGobelin();
    Monster createOrc();
    Monster createSkeleton();
    
}