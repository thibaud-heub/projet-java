package entity.abstractFactory;

import entity.abstractFactory.monsterType.Monster;
import entity.abstractFactory.monsterType.MudPile;
import entity.abstractFactory.monsterType.Gobelin.Gobelin;
import entity.abstractFactory.monsterType.Ogre.Ogre;
import entity.abstractFactory.monsterType.Orc.Orc;
import entity.abstractFactory.monsterType.Skeleton.Skeleton;


/** 
 * Implémente une factory de monstre commun, chaque méthode retourne le type de monstre souhaité
 */
public class commonFactory implements AbstractFactory {
    public Monster createOgre() 
    {
        return new Ogre(); 
    }

    public Monster createGobelin()
    {
        return new Gobelin();
    }
    public Monster createMudpile()
    {
        return new MudPile();
    }
    public Monster createOrc()
    {
        return new Orc();
    }
    public Monster createSkeleton()
    {
        return new Skeleton();
    }
}
