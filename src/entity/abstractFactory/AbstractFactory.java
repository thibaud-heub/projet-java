package entity.abstractFactory;
import entity.abstractFactory.monsterType.Monster;

/** 
 * Interface des fabriques de monstre, une de monstres elites et l'autres de monstre commun
 */
public interface AbstractFactory {
    Monster createOgre();
    Monster createGobelin();
    Monster createOrc();
    Monster createSkeleton();
}