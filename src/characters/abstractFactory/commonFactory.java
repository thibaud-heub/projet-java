package characters.abstractFactory;

import characters.abstractFactory.monsterType.Monster;
import characters.abstractFactory.monsterType.DarkWizard.DarkWizard;
import characters.abstractFactory.monsterType.Gobelin.Gobelin;
import characters.abstractFactory.monsterType.Orc.Orc;
import characters.abstractFactory.monsterType.Skeleton.Skeleton;
import characters.abstractFactory.monsterType.MudPile;


/** 
 * implémente une factory de monstre commun, chaque méthode retourne le type de monstre souhaité
 */
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
