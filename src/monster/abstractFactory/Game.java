package monster.abstractFactory;



public class Game {
    private int nbMonsterTurn = 10; //nombre de monstre pour chaque tour
    private int turn = 1; //indique le tour en cours

    ManageMonster manager = new ManageMonster();

    //probabilité dapparation des monstres
    public static double probGobelin = 0.3;
    public static double probDarkWizard = 0.2;
    public static double probOrc =0.1;
    public static double probSkeleton =0.4;
    public static double probMudPile = 0;
    
    //probabilité d'un monstre elite
    public static double probElite = 0.05;

    public void level ()
    {
        int nbLevel = 10;
        int nbMonsterLevel =10;

        for (int i = 1; i<=nbLevel; i++)
        {
            manager.generateMonster(nbMonsterLevel);
            while (!levelEnd())
            {

            }
                
        }
    }
//renvoie si le tour est fini : tous les monstres ont été tué
    public boolean levelEnd() {
        boolean end = false;
        int cpt = 0;

        while ((!end) && (cpt >= manager.monsters.length)){

            if (!manager.monsters[cpt].getAlive()) end = true;
            cpt++;
        }

            return end;
    }
}
