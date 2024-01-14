package monster.MonsterGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * class de définition et centralisation des statistiques des monstres, elle ne peut pa
 */

public final class monsterStats {
    //pourcentage de supériorité des monstres élites, les monstres élites ont juste des stats n fois supérieur à celle des monstres commun
    static double elite = 4.0;

    static double probaElite =0.2;
    static double upProbaElite = 0.05;

    //permet d'implémenter des niveaux de difficulté
    static double difficulty = 1;

    static int nbMonsterLevel = 10;
    static int variationNbMonster = 4;


//-----facteur d'augmentation des stats-------
    private static Map<String, Double> upgrade = new HashMap<>();

    static{
        upgrade.put("PV", 4.0);
        upgrade.put("AttackSpeed", 1.2);

        upgrade.put("FireResistance", 1.2);
        upgrade.put("PhysicResistance", 1.2);
        upgrade.put("MagicResistance", 1.2);

        upgrade.put("FireDamage", 1.2);
        upgrade.put("PhysicDamage", 1.2);
        upgrade.put("MagicDamage", 1.2);
    }

//--------------gobelin----------------------

    private static Map<String, Integer> gobStats = new HashMap<>();

    static {
        gobStats.put("PV", 100);
        gobStats.put("AttackSpeed", 10);

        gobStats.put("FireResistance", 8);
        gobStats.put("PhysicResistance", 25);
        gobStats.put("MagicResistance", 12);

        gobStats.put("FireDamage", 20);
        gobStats.put("PhysicDamage", 35);
        gobStats.put("MagicDamage", 15);
    }


//--------------dark wizard-------------------
    private static Map<String, Integer> darkWizardStats = new HashMap<>();

    static {
        darkWizardStats.put("PV", 100);
        darkWizardStats.put("AttackSpeed", 15);

        darkWizardStats.put("FireResistance", 20);
        darkWizardStats.put("PhysicResistance", 15);
        darkWizardStats.put("MagicResistance", 25);

        darkWizardStats.put("FireDamage", 30);
        darkWizardStats.put("PhysicDamage", 40);
        darkWizardStats.put("MagicDamage", 50);
    }


// -----------------orc------------------------
    private static Map<String, Integer> orcStats = new HashMap<>();

    static {
        orcStats.put("PV", 150);
        orcStats.put("AttackSpeed", 12);

        orcStats.put("FireResistance", 10);
        orcStats.put("PhysicResistance", 30);
        orcStats.put("MagicResistance", 15);

        orcStats.put("FireDamage", 25);
        orcStats.put("PhysicDamage", 40);
        orcStats.put("MagicDamage", 20);        
    }


//---------------skeleton--------------------
    private static Map<String, Integer> skeletonStats = new HashMap<>();
    
    static{
        skeletonStats.put("PV", 80);
        skeletonStats.put("AttackSpeed", 8);

        skeletonStats.put("FireResistance", 5);
        skeletonStats.put("PhysicResistance", 20);
        skeletonStats.put("MagicResistance", 10);

        skeletonStats.put("FireDamage", 15);
        skeletonStats.put("PhysicDamage", 30);
        skeletonStats.put("MagicDamage", 10);
    }

//---------------Mudpile--------------------
    private static Map<String, Integer> mudPileStats = new HashMap<>();

    static{
        mudPileStats.put("PV", 100);
        mudPileStats.put("AttackSpeed", 0);

        mudPileStats.put("FireResistance", 0);
        mudPileStats.put("PhysicResistance", 0);
        mudPileStats.put("MagicResistance", 0);

        mudPileStats.put("FireDamage", 0);
        mudPileStats.put("PhysicDamage", 0);
        mudPileStats.put("MagicDamage", 0);
    }

//place les states des monstres dans un hashmap pour la gestion
    static Map<String, Map<String, Integer>> monster = new HashMap<>();
    static
    {
        monster.put("Gobelin", gobStats);
        monster.put("DarkWizard", darkWizardStats);
        monster.put("Orc", orcStats);
        monster.put("Skeleton", skeletonStats);
        monster.put("MudPile", mudPileStats);
    }

    /**
     * augmente les statistiques d'un monstre selectionné
     * @param monster : monstre que l'on veut améliorer
     */

    public static void upgradeStats(Map<String, Integer> monster)
    {
        for (String cle : monster.keySet())
        {
            int statUp = (int) Math.round(monster.get(cle) * upgrade.get(cle));
            monster.put(cle, statUp);
        }

    }

    /**
     * augmente les stats de tous les monstres
     */
    public static void upgradeAllStats()
    {
        for(String cle : monster.keySet())
        {
            upgradeStats(monster.get(cle));
        }
        probaElite += upProbaElite;
        Random random = new Random();
        nbMonsterLevel += random.nextInt(variationNbMonster + 1);
    }

    /**
     * affiche les statistiques d'un monstre
     * @param monster : monstre dont on veut afficher les stats
     */
    public static void printStat(Map<String, Integer> monster)
    {
        for(String cle : monster.keySet())
        {
            System.out.println(cle + " : " + monster.get(cle));
        }
    }

    /**
     * affiche les stats de tous les monstres
     */
    public static void printAll()
    {  
        for(String cle : monster.keySet())
        {   
            System.out.println("\n" + cle);
            printStat(monster.get(cle));
        }
    }

    public static void printElite(Map<String, Integer> monster)
    {
        for(String cle : monster.keySet())
            {
                System.out.println(cle + " : " + (monster.get(cle)*elite));
            }
    }

    public static void printAllElite()
    {
        for(String cle : monster.keySet())
        {
            System.out.println("\n" + cle + " elite");
            printElite(monster.get(cle));
        }
    }


    public static Map<String,Integer> elite(Map<String, Integer> monster)
    {
        Map<String, Integer> eliteMonster = new HashMap<>();
        for (String cle : monster.keySet())
        {
            int up = (int) Math.round(monster.get(cle)*elite);
            eliteMonster.put(cle, up);
        }
        return eliteMonster;
    }
    
    /**
     * renvoie le monstre spécifié en paramètre
     * @param mons : chaine de caractère, nom du monstre voulue
     * @return le monstre correspondant
     */
    public static Map<String, Integer> getStats(String mons)
    {
        return monster.get(mons);
    }
}
