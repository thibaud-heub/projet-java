package monster.factory;

import monster.factory.monsterFactory.*;

public class Game {
    private int nbMonsterTurn = 10; //nombre de monstre pour chaque tour
    private int turn = 1; //indique le tour en cours
    private Factory factory = new Factory();

    //probabilité dapparation des monstres
    public static double probGobelin = 0.3;
    public static double probDarkWizard = 0.2;
    public static double probOrc =0.1;
    public static double probSkeleton =0.4;
    public static double probMudPile = 0;
    
    public void level ()
    {
        int nbLevel = 10;
        int nbMonsterLevel =10;

        for (int i = 1; i<=nbLevel; i++)
        {
            factory.generateMonster(nbMonsterLevel);
            while (!levelEnd())
            {

            }
                
        }
    }
//renvoie si le tour est fini : tous les monstres ont été tué
    public boolean levelEnd() {
        boolean end = false;
        int cpt = 0;

        while ((!end) && (cpt >= factory.monsters.length)){

            if (!factory.monsters[cpt].getAlive()) end = true;
            cpt++;
        }

            return end;
    }
}
