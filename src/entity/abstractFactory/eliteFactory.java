package entity.abstractFactory;

import entity.abstractFactory.monsterType.Monster;
import entity.abstractFactory.monsterType.Gobelin.EliteGobelin;
import entity.abstractFactory.monsterType.Ogre.EliteOgre;
import entity.abstractFactory.monsterType.Orc.EliteOrc;
import entity.abstractFactory.monsterType.Skeleton.EliteSkeleton;

/**
 * Implémente la fabrique de monstre d'élites
 */
public class eliteFactory implements AbstractFactory{
    public Monster createOgre()
    {
        return new EliteOgre();
    }
    public Monster createGobelin()
    {
        return new EliteGobelin();
    }
    public Monster createOrc()
    {
        return new EliteOrc();
    }
    public Monster createSkeleton()
    {
        return new EliteSkeleton();
    }
}
