package monster.monsterFactory;

import java.util.Random;

import monster.Game;
import monster.monsterType.*;

public class Factory {
    //tableau contenant les monstres du tour, généré par generateMonster
    public static MonsterShare monsters[];


//génére un tableau de monstre aléatoire, de taille nbMonster
    public void generateMonster(int nbMonster) 
    {
        monsters = new MonsterShare[nbMonster];
        
        for (int i = 0; i<monsters.length; i++)
        {
            monsters[i] = sortMonster();
        }
    }

//place un monstre dans un tableau
    public void putMonster (MonsterShare tab[], MonsterShare monster)
    {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == null) {
                tab[i] = monster;
            }
        }
    }



    //tire un monstre au hasard avec différentes chances d'apparition des monstres (la somme des proba doit être egal à 1)
    public MonsterShare sortMonster() 
    {   
        MonsterFactory factory; 
        Random random = new Random();
        double nbRandom = random.nextDouble();
        double sumProb = Game.probDarkWizard + Game.probGobelin + Game.probMudPile + Game.probMudPile + Game.probOrc + Game.probSkeleton;
        
        //si la somme des proba n'est pas égal à 1, renvoie une erreur
        if (sumProb != 1) throw new IllegalStateException("La somme des probabilités n'est pas égale à 100%");        

        System.out.println(sumProb);

        sumProb = 0;

        //pour chaque monstre compare la proba d'apparition avec la somme des proba précédente et créer la farbique correspondante
        
        if (nbRandom <= (sumProb += Game.probDarkWizard)) factory = new DarkWizardFactory();

        else if (nbRandom <= (sumProb += Game.probGobelin)) factory = new GobelinFactory();

        else if (nbRandom <= (sumProb += Game.probOrc)) factory = new OrcFactory();
        
        else if (nbRandom <= (sumProb += Game.probSkeleton)) factory = new SkeletonFactory();

        else factory = new MudPileFactory();

        System.out.println(sumProb);
        //à l'aide de la fabrique on créer et retourne le monstre correspondant
        return factory.createMonster();
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
}