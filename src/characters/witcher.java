package characters;

import java.util.Scanner;

import weapons.*;

public class witcher extends character {

    private static final int IDLE_FRAME_COUNT = 4;
    private static final int RUN_FRAME_COUNT = 6;
    private static final int DEATH_FRAME_COUNT = 6;

    public witcher() {
        super(100, 5, 0, 0, 10, 0, 0, 10, "Magicien", 1, 100, 3); 
        setIdleSheet("../../ressources/sprites/Heroes/Wizzard/Idle/Idle-Sheet.png", 32, 32);
        setRunSheet("../../ressources/sprites/Heroes/Wizzard/Run/Run-Sheet.png", 64, 64);
        setDeathSheet("../../ressources/sprites/Heroes/Wizzard/Death/Death-Sheet.png", 64, 32);
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

    public int getIdleFrameCount() {
        return IDLE_FRAME_COUNT;
    }

    public int getRunFrameCount() {
        return RUN_FRAME_COUNT;
    }

    public int getDeathFrameCount() {
        return DEATH_FRAME_COUNT;
    }
}
