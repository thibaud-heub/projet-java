package monster.abstractFactory.monsterType;
import monster.MonsterGame.monsterStats;

public class MudPile extends Monster{
    public MudPile () 
    {
       super(monsterType.COMMON, monsterStats.getStats("MudPile"));
    };

    @Override
    public void print() 
    {
        System.out.println("\nJe suis un tas de boue");
        super.print();
    }

}
