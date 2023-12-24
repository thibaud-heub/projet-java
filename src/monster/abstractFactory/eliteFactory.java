package monster.abstractFactory;

import monster.abstractFactory.monsterType.Monster;
import monster.abstractFactory.monsterType.DarkWizard.EliteDarkWizard;
import monster.abstractFactory.monsterType.Gobelin.EliteGobelin;
import monster.abstractFactory.monsterType.Orc.EliteOrc;
import monster.abstractFactory.monsterType.Skeleton.EliteSkeleton;

//implémente la fabrique de monstre d'élites
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
