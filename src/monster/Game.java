package monster;

import monster.monsterFactory.Factory;

public class Game {
    private int nbMonsterTurn = 10;
    private int turn = 1; 
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
//renvoie si le tour est fini : tout les monstres ont été tué
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
