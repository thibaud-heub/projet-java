package monster.game;

import java.util.Map;
import monster.abstractFactory.monsterType.Monster;
import monster.abstractFactory.monsterType.MudPile;
import monster.abstractFactory.monsterType.DarkWizard.DarkWizard;
import monster.abstractFactory.monsterType.DarkWizard.EliteDarkWizard;
import monster.abstractFactory.monsterType.Gobelin.EliteGobelin;
import monster.abstractFactory.monsterType.Gobelin.Gobelin;
import monster.abstractFactory.monsterType.Monster.monsterType.*;
import monster.abstractFactory.monsterType.Orc.Orc;
import monster.abstractFactory.monsterType.Skeleton.Skeleton;
import monster.abstractFactory.monsterType.Monster;

public class Main {
    public static void main(String[] args) {
        Monster gobelin = new EliteGobelin();
        Monster DarkWizard = new DarkWizard();
        
        DarkWizard.print();
        gobelin.attack(DarkWizard);
        DarkWizard.print();
    }
}
