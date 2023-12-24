package monster.abstractFactory.monsterType;

public class MudPile extends Monster{
    public MudPile () 
    {
       super(5, 0, 0 , 0, DamageType.NOTHING, monsterType.COMMON);
    };

    @Override
    public void print() 
    {
        System.out.println("\nJe suis un tas de boue");
        super.print();
    }

}
