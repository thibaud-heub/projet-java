package entity.MonsterGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Genere la probabilité d'apparition pour chaque monstre, la somme des probabilités d'apparition est égal à 1
 * @return Un hashmap contenant pour chaque monstre une biclé avec le nom du monstre auquel on associe sa proba d'apparition
 */
public class probaMonster {

    /**
     * Méthode qui tire au sort les probabilités d'apparition de chaque monstre, la somme des probabilités est égal à 1
     * @param probElite : La probabilité d'apparition des monstres élites (elle n'est as généré aléatoirement et évolue avec le niveau)
     * @return Une structure de donnée Map qui associe une chaine de caractère à un double (fonctionne comme un dictionnaire)
     */
    
    public Map<String, Double> sortProb(Double probElite)
    {
        /** 
         * Les probabilités d'apparition des montres seront stockés dans un hashmap
         * hashmap est une sorte de tableau de biclé, on a une valeur string (le nom du monstre) 
         * à laquelle on associe un double (proba d'apparition du monstre)
         * On peut accéder à la valeur du double en spécifiant seuelement le nom
         */
        Map<String, Double> monstersProb = new HashMap<>();
        Random random = new Random();
        Double mProb, sum = 0.0;

        monstersProb.put("Gobelin", 0.0);
        monstersProb.put("Ogre", 0.0);
        monstersProb.put("Skeleton", 0.0);
        monstersProb.put("Orc", 0.0);
        monstersProb.put("Elite", probElite);

        // Pour chaque valeur du hash map, on tire une value aléatoire entre 0 et 1 (pour chaque monstre on tire sa probabilité d'apparition) 
        for (String cle : monstersProb.keySet()) 
        {
            if (cle != "Elite")
            {
                mProb = random.nextDouble();
                sum += mProb;
                monstersProb.put(cle, mProb);
            }
        }

        // On normalise les probabilités des monstres afin que leur somme soit égal à 1 
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
 * Affiche les données contenu dans le hashmap, la chaîne de caractère et ensuite la valeur du double
 * @param monstersProb Hashmap des probabilités d'apparition des monstres
 */
    public void printProb(Map<String, Double> monstersProb)
    {
        System.out.println("\nProbabilités d'apparition des monstres :\n");
        for (String cle : monstersProb.keySet() )
        {
            if(cle != "Elite")
            {
            System.out.println(cle + " : " + (int) Math.round(monstersProb.get(cle)*100) + "%\n");
            }
        }
        System.out.println("Elite : " + monstersProb.get("Elite")*100 + "%\n");
    }
}
