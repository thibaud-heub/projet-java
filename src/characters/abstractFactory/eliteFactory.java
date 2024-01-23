package characters.abstractFactory;

import characters.abstractFactory.monsterType.Monster;
import characters.abstractFactory.monsterType.DarkWizard.EliteDarkWizard;
import characters.abstractFactory.monsterType.Gobelin.EliteGobelin;
import characters.abstractFactory.monsterType.Orc.EliteOrc;
import characters.abstractFactory.monsterType.Skeleton.EliteSkeleton;

/**
 * implémente la fabrique de monstre d'élites
 */
public class eliteFactory implements AbstractFactory{
    public Monster createDarkWizard()
    {
        return new EliteDarkWizard();
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
