import weapons.*;

import java.util.Scanner;

import characters.*;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choisissez votre personnage :");
        System.out.println("1. Guerrier");
        System.out.println("2. Magicien");
        System.out.println("3. Chasseur");
        
        System.out.print("Entrez le numéro de votre choix : ");
        int chooseCharacter = scanner.nextInt();

        character character = null;
        switch (chooseCharacter) {
            case 1:
                character = new warrior();
                break;
            case 2:
                character = new witcher();
                break;
            case 3:
                character = new hunter();
                break;
            default:
                System.out.println("Choix invalide.");
                System.exit(0);
        }
        
        weapon weapon = character.chooseWeapon(scanner);
        
    }
}
