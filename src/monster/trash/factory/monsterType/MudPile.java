package monster.trash.factory.monsterType;

public class MudPile extends MonsterShare{
    public MudPile () 
    {
       super(5, 0, 0 , 0, DamageType.NOTHING);
    };

    @Override
    public void print() 
    {
        System.out.println("\nJe suis un tas de boue");
        super.print();
    }

}
