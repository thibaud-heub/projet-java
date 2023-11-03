package characters;

import java.util.Scanner;

import weapons.*;

public class hunter extends character {

    public hunter() {
        this.name = "Chasseur";
        this.pv = 100;
        this.level = 1;
        this.mana = 100;
        this.speed = 5;
    }

    public weapon chooseWeapon(Scanner scanner) {
        System.out.println("Choisissez une arme pour votre chasseur :");
        System.out.println("1. Dague");
        System.out.println("2. Arc");

        System.out.print("Entrez le numéro de votre choix : ");
        int chooseWeapon = scanner.nextInt();

        switch (chooseWeapon) {
            case 1:
                return new spike();
            case 2:
                return new bow();
            default:
                System.out.println("Choix invalide.");
                System.exit(0);
                return null;
        }
    }
}
