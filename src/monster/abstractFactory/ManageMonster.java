package monster.abstractFactory;

import java.util.Random;

import monster.abstractFactory.monsterType.Monster;

public class ManageMonster {

    
    //tableau contenant les monstres du tour, généré par generateMonster
    public static Monster monsters[];


//génére un tableau de monstre aléatoire, de taille nbMonster
    public void generateMonster(int nbMonster) 
    {
        monsters = new Monster[nbMonster];
        
        for (int i = 0; i<monsters.length; i++)
        {
            monsters[i] = sortMonster();
        }
    }

    //tire un monstre au hasard avec différentes chances d'apparition des monstres (la somme des proba doit être egal à 1)
    public Monster sortMonster() 
    {   

        AbstractFactory common = new commonFactory();
        AbstractFactory elite= new eliteFactory();

        Random random = new Random();
        //tirage de la probabilité du type de monstre
        double nbRandom = random.nextDouble();
        //tirage de la probabilité d'un monstre élite
        double eliteRandom = random.nextDouble();
        System.out.println(eliteRandom);

        double sumProb = Game.probDarkWizard + Game.probGobelin + Game.probMudPile + Game.probOrc + Game.probSkeleton;
        
        //si la somme des proba n'est pas égal à 1, renvoie une erreur
        if (sumProb != 1) throw new IllegalStateException("La somme des probabilités n'est pas égale à 100%");        

        sumProb = 0;

        //pour chaque monstre compare la proba d'apparition avec la somme des proba précédente et créer la farbique correspondante
        
        if (nbRandom <= (sumProb += Game.probDarkWizard)) 
        {
            // pour chaque génération de mpnstre, il y'a une probabilité que cle monstre généré soit élite
            if (eliteRandom <= Game.probElite)return elite.createDarkWizard();
            else return common.createDarkWizard();
        }
        else if (nbRandom <= (sumProb += Game.probGobelin))
        {
            if (eliteRandom <= Game.probElite) return elite.createGobelin();
            else return common.createGobelin();
        }

        else if (nbRandom <= (sumProb += Game.probOrc))
        {
            if (eliteRandom <= Game.probElite) return elite.createOrc();
            else return common.createOrc();
        }
        else 

        //sinon retourner un squellette
        {
            if (eliteRandom <= Game.probElite) return elite.createSkeleton();
            else return common.createSkeleton();
        }
}



//affiche les monstre VIVANT présent dans le tableau de monstres
    public void printMonsters ()
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

    //place un monstre au premier emplacement libre d'un tableau
    public void putMonster (Monster tab[], Monster monster)
    {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == null) {
                tab[i] = monster;
            }
        }
    }
}

