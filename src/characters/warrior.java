package characters;

import java.util.Scanner;

import weapons.*;

public class warrior extends character {

    public warrior() {
        super(100, 5, 0, 10, 0, 0, 10, 0, "Guerrier", 1, 100, 1);
    }

    public weapon chooseWeapon(Scanner scanner) {
        System.out.println("Choisissez une arme pour votre guerrier :");
        System.out.println("1. Épée et Bouclier");
        System.out.println("2. Hache de Guerre");

        System.out.print("Entrez le numéro de votre choix : ");
        int chooseWeapon = scanner.nextInt();

        switch (chooseWeapon) {
            case 1:
                return new sword();
            case 2:
                return new warAxe();
            default:
                System.out.println("Choix invalide.");
                System.exit(0);
                return null;
        }
    }
}
