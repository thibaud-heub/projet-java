package characters.MonsterGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Classe de définition et centralisation des statistiques des monstres
 * Les statistiques sont définies dans des HashMaps, un pour chaque monstre
 */

public final class monsterStats {
    // Pourcentage de supériorité des monstres élites, les monstres élites ont des stats n fois supérieur à celle des monstres communs
    static double elite = 2.0;

    static double probaElite =0.2;
    static double upProbaElite = 0.05;

    // Permet d'implémenter des niveaux de difficulté
    static double difficulty = 1;

    static int nbMonsterLevel = 10;
    static int variationNbMonster = 4;


//-----Facteur d'augmentation des stats-------
    private static Map<String, Double> upgrade = new HashMap<>();

    static{
        upgrade.put("PV", 0.0);
        upgrade.put("AttackSpeed", 0.0);

        upgrade.put("FireResistance", 1.2);
        upgrade.put("PhysicResistance", 1.2);
        upgrade.put("MagicResistance", 1.2);

        upgrade.put("FireDamage", 1.2);
        upgrade.put("PhysicDamage", 1.2);
        upgrade.put("MagicDamage", 1.2);
    }

//--------------Gobelin----------------------

    private static Map<String, Integer> gobStats = new HashMap<>();

    static {
        gobStats.put("PV", 50);
        gobStats.put("AttackSpeed", 15);

        gobStats.put("FireResistance", 0);
        gobStats.put("PhysicResistance", 3);
        gobStats.put("MagicResistance", 2);

        gobStats.put("FireDamage", 4);
        gobStats.put("PhysicDamage", 8);
        gobStats.put("MagicDamage", 4);
    }


//--------------Ogre-------------------
    private static Map<String, Integer> ogreStats = new HashMap<>();

    static {
        ogreStats.put("PV", 75);
        ogreStats.put("AttackSpeed", 8);

        ogreStats.put("FireResistance", 0);
        ogreStats.put("PhysicResistance", 6);
        ogreStats.put("MagicResistance", 0);

        ogreStats.put("FireDamage", 0);
        ogreStats.put("PhysicDamage", 15);
        ogreStats.put("MagicDamage", 0);
    }


// -----------------Orc------------------------
    private static Map<String, Integer> orcStats = new HashMap<>();

    static {
        orcStats.put("PV", 50);
        orcStats.put("AttackSpeed", 12);

        orcStats.put("FireResistance", 5);
        orcStats.put("PhysicResistance", 5);
        orcStats.put("MagicResistance", 0);

        orcStats.put("FireDamage", 5);
        orcStats.put("PhysicDamage", 5);
        orcStats.put("MagicDamage", 0);        
    }


//---------------Squelette--------------------
    private static Map<String, Integer> skeletonStats = new HashMap<>();
    
    static{
        skeletonStats.put("PV", 40);
        skeletonStats.put("AttackSpeed", 12);

        skeletonStats.put("FireResistance", 5);
        skeletonStats.put("PhysicResistance", 3);
        skeletonStats.put("MagicResistance", 0);

        skeletonStats.put("FireDamage", 0);
        skeletonStats.put("PhysicDamage", 5);
        skeletonStats.put("MagicDamage", 3);
    }

//---------------Tas de boue--------------------
    private static Map<String, Integer> mudPileStats = new HashMap<>();

    static{
        mudPileStats.put("PV", 50);
        mudPileStats.put("AttackSpeed", 0);

        mudPileStats.put("FireResistance", 0);
        mudPileStats.put("PhysicResistance", 0);
        mudPileStats.put("MagicResistance", 0);

        mudPileStats.put("FireDamage", 0);
        mudPileStats.put("PhysicDamage", 0);
        mudPileStats.put("MagicDamage", 0);
    }


//---------------Boss------------------

    private static Map<String, Integer> bossStats = new HashMap<>();

    static{
        mudPileStats.put("PV", 250);
        mudPileStats.put("AttackSpeed", 10);

        mudPileStats.put("FireResistance", 10);
        mudPileStats.put("PhysicResistance", 10);
        mudPileStats.put("MagicResistance", 10);

        mudPileStats.put("FireDamage", 10);
        mudPileStats.put("PhysicDamage", 10);
        mudPileStats.put("MagicDamage", 10);
    }

// Place les stats des monstres dans un hashmap pour la gestion
    static Map<String, Map<String, Integer>> monster = new HashMap<>();
    static
    {
        monster.put("Gobelin", gobStats);
        monster.put("Ogre", ogreStats);
        monster.put("Orc", orcStats);
        monster.put("Skeleton", skeletonStats);
        monster.put("MudPile", mudPileStats);
        monster.put("Boss", bossStats);
    }

    /**
     * Augmente les statistiques d'un monstre selectionné
     * @param monster : Monstre que l'on veut améliorer
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
     * Augmente les stats de tous les monstres
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
     * Affiche les statistiques d'un monstre
     * @param monster : Monstre dont on veut afficher les stats
     */
    public static void printStat(Map<String, Integer> monster)
    {
        for(String cle : monster.keySet())
        {
            System.out.println(cle + " : " + monster.get(cle));
        }
    }

    /**
     * Affiche les stats de tous les monstres
     */
    public static void printAll()
    {  
        for(String cle : monster.keySet())
        {   
            System.out.println("\n" + cle);
            printStat(monster.get(cle));
        }
    }

    /**
     * Affiche les stats des monstres élites
     * @param monster : Monstre dont on veut afficher les stats
     */
    public static void printElite(Map<String, Integer> monster)
    {
        for(String cle : monster.keySet())
            {
                System.out.println(cle + " : " + (monster.get(cle)*elite));
            }
    }

    /**
     * Affiche les stats de tous les monstres élites
     */
    public static void printAllElite()
    {
        for(String cle : monster.keySet())
        {
            System.out.println("\n" + cle + " elite");
            printElite(monster.get(cle));
        }
    }


    /**
     * Renvoie les stats d'un monstre élite
     * @param monster : Monstre dont on veut les stats 
     * @return Les stats du monstre
     */
    public static Map<String,Integer> elite(Map<String, Integer> monster)
    {
        Map<String, Integer> eliteMonster = new HashMap<>();
        for (String cle : monster.keySet())
        {
            if(!cle.equals("AttackSpeed") && !cle.equals("PV")){
                int up = (int) Math.round(monster.get(cle)*elite);
                eliteMonster.put(cle, up);
            }
            else{
                eliteMonster.put(cle, monster.get(cle));
            }
        }
        return eliteMonster;
    }
    
    /**
     * Renvoie le monstre spécifié en paramètre
     * @param mons : Chaine de caractère, nom du monstre voulu
     * @return Le monstre correspondant
     */
    public static Map<String, Integer> getStats(String mons)
    {
        return monster.get(mons);
    }
}
