package monster.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * genere la probabilité d'apparition pour chaque monstre, la somme des probabilités d'apparition est égal à 1
 * @return un hashmap contenant pour chaque monstre une biclé avec le nom du monstre auquel on associe sa proba d'apparition
 */
public class proba {
    
    static Map<String, Double> sortProb(Double probElite)
    {
        /** 
         *les probabilité d'apparition des montres seront stockés dans un hashmap
         *hashmap est une sorte de tableau de biclé, on a une valeur string (le nom du monstre) à laquelle on associe un double (proba d'apparition du mosntre)
         */
        Map<String, Double> monstersProb = new HashMap<>();
        Random random = new Random();
        Double mProb, sum = 0.0;

        monstersProb.put("Gobelin", 0.0);
        monstersProb.put("Darkwizard", 0.0);
        monstersProb.put("Skeleton", 0.0);
        monstersProb.put("Orc", 0.0);
        monstersProb.put("Elite", probElite);

/** pour chaque valeur du hash map, on tire une value aléatoire entre 0 et 1 (pour chaque monstre on tire sa proba d'apparition) */
        for (String cle : monstersProb.keySet()) 
        {
            if (cle != "Elite")
            {
                mProb = random.nextDouble();
                sum += mProb;
                monstersProb.put(cle, mProb);
            }
        }

        /** on normalise les probabilités des monstres afin que leur somme soit égal à 1 */
        if(sum!=1)
        {
            for (String cle : monstersProb.keySet()) 
            {
                if (cle != "Elite")
                {
                    Double value = monstersProb.get(cle);
                    monstersProb.put(cle, value/sum);
                }
            }
        }

        return monstersProb;
    }

/**
 * affiche les donnnées contenu dans le bitmap 
 * @param monstersProb hashmap des probabilités d'apparition des monstres
 */
    static void printProb(Map<String, Double> monstersProb)
    {
        System.out.println("\nProbabilités d'apparitions des monstres :\n");
        for (String cle : monstersProb.keySet() )
        {
            if(cle != "Elite")
            {
            System.out.println(cle);
            System.out.println(monstersProb.get(cle) + "\n");
            }
        }
        System.out.println("Elite");
        System.out.println(monstersProb.get("Elite") + "\n");
    }
}
