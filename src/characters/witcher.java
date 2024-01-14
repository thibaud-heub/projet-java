package characters;

import java.util.Scanner;

import weapons.*;

public class witcher extends character {

    public witcher() {
        super(100, 5, 0, 0, 10, 0, 0, 10, "Magicien", 1, 100, 3); 
    }

    public weapon chooseWeapon(Scanner scanner) {
        System.out.println("Choisissez une arme pour votre magicien :");
        System.out.println("1. Bâton magique + livre de sort");
        System.out.println("2. Grand bâton magique");

        System.out.print("Entrez le numéro de votre choix : ");
        int chooseWeapon = scanner.nextInt();

        switch (chooseWeapon) {
            case 1:
                return new magicWand();
            case 2:
                return new bigMagicWand();
            default:
                System.out.println("Choix invalide.");
                System.exit(0);
                return null;
        }
    }
}
