package monster.game;

import java.util.Map;
import java.util.Random;

import monster.abstractFactory.AbstractFactory;
import monster.abstractFactory.commonFactory;
import monster.abstractFactory.eliteFactory;
import monster.abstractFactory.monsterType.Monster;

public class ManageMonster {

/**
    * génére un tableau de monstre aléatoire, de taille nbMonster
    * @param nbMonster, nombre de monstre souhaité
    * @param probMonster : probabilité d'apparition des monstres
    * @return retourne un tableaud de Monstre de taille nbMonster
*/
    static Monster[] generateMonster(int nbMonster, Map<String, Double> probMonster) 
    {
        Monster[] monsters = new Monster[nbMonster];
        
        for (int i = 0; i<monsters.length; i++)
        {
            monsters[i] = sortMonster(probMonster);
        }
        return monsters;
    }


/**
 * tire un monstre au hasard avec différentes chances d'apparition des monstres (la somme des proba doit être egal à 1)
    * @return un monstre tiré au sort, avec une probabilité qu'il soit élite
*/
    
    static Monster sortMonster(Map<String, Double> monstersProb) 
    {   

        AbstractFactory common = new commonFactory();
        AbstractFactory elite= new eliteFactory();

        Random random = new Random();
        //tirage de la probabilité du type de monstre
        double nbRandom = random.nextDouble();
        //tirage de la probabilité d'un monstre élite
        double eliteRandom = random.nextDouble();

        Double sumProb = 0.0;
        
        Double probElite = monstersProb.get("Elite");
        //si la somme des proba n'est pas égal à 1, renvoie une erreur
        //if (sumProb != 1) throw new IllegalStateException("La somme des probabilités n'est pas égale à 100%");        


        //pour chaque monstre compare la proba d'apparition avec la somme des proba précédente et créer la fabrique correspondante
        if (nbRandom <= (sumProb += monstersProb.get("Darkwizard"))) 
        {
            // pour chaque génération de monstre, il y'a une probabilité que le monstre généré soit élite
            if (eliteRandom <= probElite)return elite.createDarkWizard();
            else return common.createDarkWizard();
        }
    
        else if (nbRandom <= (sumProb += monstersProb.get("Gobelin"))) 
        {
            if (eliteRandom <= probElite) return elite.createGobelin();
            else return common.createGobelin();
        }

        else if (nbRandom <= (sumProb += monstersProb.get("Orc")))
        {
            if (eliteRandom <= probElite) return elite.createOrc();
            else return common.createOrc();
        }
        else 

        //sinon retourner un squellette
        {
            if (eliteRandom <= probElite) return elite.createSkeleton();
            else return common.createSkeleton();
        }
}

/**
 * affiche les monstres VIVANT du tableau de monstres
 */
    static void printAliveMonsters (Monster[] monsters)
    {
        for (int i =0; i<monsters.length; i++)
        {
            if (monsters[i].getAlive())
            {
                System.out.print("\nMonstre numéro : " + i);
            monsters[i].print();
            }
        }
    }

    /**
     * place un monstre au premier emplacement libr edu tableau de monstres
     * @param tab : le tableau de monstres
     * @param monster : le monstre a placé dans le tableau
     */
    public void putMonster (Monster tab[], Monster monster)
    {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == null) {
                tab[i] = monster;
            }
        }
    }
}

