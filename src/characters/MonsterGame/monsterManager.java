package characters.MonsterGame;

import java.util.Map;
import java.util.Random;

import characters.abstractFactory.AbstractFactory;
import characters.abstractFactory.commonFactory;
import characters.abstractFactory.eliteFactory;
import characters.abstractFactory.monsterType.Boss;
import characters.abstractFactory.monsterType.Monster;

public class monsterManager {
     Map<String, Double> prob;

    /**
    * génére un tableau de monstre aléatoire, de taille nbMonster
    * @param nbMonster, nombre de monstre souhaité
    * @param probMonster : probabilité d'apparition des monstres
    * @return retourne un tableaud de Monstre de taille nbMonster
    */
    public Monster[] generateMonsters(int nbMonster, Map<String, Double> probMonster) 
    {
        Monster[] monsters = new Monster[nbMonster];
        
        for (int i = 0; i<monsters.length; i++)
        {
            monsters[i] = sortMonster(probMonster);
            monsters[i].setId(i);
        }
        return monsters;
    }

/**
 * tire un monstre au hasard avec différentes chances d'apparition des monstres (la somme des proba doit être egal à 1)
    * @return un monstre tiré au sort, avec une probabilité qu'il soit élite
*/
    
    public Monster sortMonster(Map<String, Double> monstersProb) 
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
        
        //pour chaque monstre compare la proba d'apparition avec la somme des proba précédente et créer la fabrique correspondante
        if (nbRandom <= (sumProb += monstersProb.get("Ogre"))) 
        {
            // pour chaque génération de monstre, il y'a une probabilité que le monstre généré soit élite
            if (eliteRandom <= probElite)return elite.createOgre();
            else return common.createOgre();
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
     * génere un boss
     * @return un boss
     */
    public Monster[] generateBoss ()
    {
        Monster[] boss = new Monster[1];
        putMonster(boss, new Boss());

        return boss;
    }


    /**
     * affiche les monstres VIVANT du tableau de monstres
     */
    public void printAliveMonsters (Monster[] monsters)
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
     * place un monstre au premier emplacement libre du tableau de monstres
     * @param tab : le tableau de monstres
     * @param monster : le monstre a placé dans le tableau
     */
    public void putMonster (Monster tab[], Monster monster)
    {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == null) {
                tab[i] = monster;
                tab[i].setId(i);
            }
        }
    }



    /**
     * création et gestion des monstres d'un nouveau level, chaque nouveau level généré a des monstres plus fort que le level précédent. Si le lvel est le dernier, génere un tableau contenant juste un boss
     * @param endLevel : booléen indiquant si c'est le dernier level
     * @return un tableau contenenant les monstres du level
     */
    public Monster[] monstersLevel(boolean endLevel)
    {
        Monster[] monsters;
        
        if(!endLevel){
            probaMonster probaMonster = new probaMonster();

            prob = probaMonster.sortProb(monsterStats.probaElite);

            monsters = generateMonsters(monsterStats.nbMonsterLevel, prob);

            monsterStats.upgradeAllStats();
        }
        else 
        {
            monsters = generateBoss();
        }
        return monsters;
    }

    /**
     * affiche la variable prob contenant les proba d'apparition des monstres
     */
    public void printProb()
    {
        probaMonster probaMonster = new probaMonster();
        probaMonster.printProb(this.prob);
    }
}

