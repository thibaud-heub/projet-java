package monster.abstractFactory;

import monster.abstractFactory.monsterType.Monster;
import monster.abstractFactory.monsterType.DarkWizard.DarkWizard;
import monster.abstractFactory.monsterType.Gobelin.Gobelin;
import monster.abstractFactory.monsterType.Orc.Orc;
import monster.abstractFactory.monsterType.Skeleton.Skeleton;
import monster.abstractFactory.monsterType.MudPile;


//implémente une factory de monstre commun, chaque fonction retourner le type de monstre souhaite
public class commonFactory implements AbstractFactory {
    public Monster createDarkWizard() 
    {
        return new DarkWizard(); 
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
