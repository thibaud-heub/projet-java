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
    * Génére un tableau de monstres aléatoires, de taille nbMonster
    * @param nbMonster : Nombre de monstres souhaité
    * @param probMonster : Probabilité d'apparition des monstres
    * @return Retourne un tableau de monstres de taille nbMonster
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
    * Tire un monstre au hasard avec différentes chances d'apparition des monstres (la somme des proba doit être egal à 1)
    * @param monstersProb : Map contenant les probabilités d'apparition des monstres
    * @return Un monstre tiré au sort, avec une probabilité qu'il soit élite
    */
    public Monster sortMonster(Map<String, Double> monstersProb) 
    {   
        AbstractFactory common = new commonFactory();
        AbstractFactory elite= new eliteFactory();

        Random random = new Random();
        // Tirage de la probabilité du type de monstre
        double nbRandom = random.nextDouble();
        // Tirage de la probabilité d'un monstre élite
        double eliteRandom = random.nextDouble();

        Double sumProb = 0.0;
        
        Double probElite = monstersProb.get("Elite");
        
        // Pour chaque monstre compare la proba d'apparition avec la somme des proba précédente et créer la fabrique correspondante
        if (nbRandom <= (sumProb += monstersProb.get("Ogre"))) 
        {
            // Pour chaque génération de monstre, il y a une probabilité que le monstre généré soit élite
            if (eliteRandom <= probElite)return elite.createOgre();
            else return common.createOgre();
        }
    
        else if (nbRandom <= (sumProb += monstersProb.get("Gobelin"))) 
        {
            // Pour chaque génération de monstre, il y a une probabilité que le monstre généré soit élite
            if (eliteRandom <= probElite) return elite.createGobelin();
            else return common.createGobelin();
        }

        else if (nbRandom <= (sumProb += monstersProb.get("Orc")))
        {
            if (eliteRandom <= probElite) return elite.createOrc();
            else return common.createOrc();
        }
        else 

        // Sinon retourner un squelette
        {
            if (eliteRandom <= probElite) return elite.createSkeleton();
            else return common.createSkeleton();
        }
    }
    /**
     * Génere un boss
     * @return Le boss
     */
    public Monster[] generateBoss ()
    {
        Monster[] boss = new Monster[1];
        putMonster(boss, new Boss());

        return boss;
    }


    /**
     * Affiche les monstres vivants du tableau de monstres
     * @param monsters : le tableau de monstres
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
     * Place un monstre au premier emplacement libre du tableau de monstres
     * @param tab : Le tableau de monstres
     * @param monster : Le monstre a placé dans le tableau
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
     * Création et gestion des monstres d'un nouveau level, 
     * chaque nouveau level généré a des monstres plus fort que le level précédent. 
     * Si le level est le dernier, génere un tableau contenant juste un boss
     * @param endLevel : Booléen indiquant si c'est le dernier level
     * @return Un tableau contenenant les monstres du level
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
     * Affiche la variable prob contenant les proba d'apparition des monstres
     */
    public void printProb()
    {
        probaMonster probaMonster = new probaMonster();
        probaMonster.printProb(this.prob);
    }
}

