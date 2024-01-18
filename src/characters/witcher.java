package characters;

import java.util.Scanner;

import weapons.*;

public class witcher extends character {

    private static final int IDLE_FRAME_COUNT = 4;
    private static final int RUN_FRAME_COUNT = 6;
    private static final int DEATH_FRAME_COUNT = 6;

    public witcher() {
        super(100, 5, 0, 0, 10, 0, 0, 10, "Magicien", 1, 100, 3); 
        // si le joueur choisit batôn normal
        // setIdleSheet("../../ressources/sprites/Heroes/Wizzard/Idle/Idle-Sheet-Wand.png", 32, 32);
        // setRunSheet("../../ressources/sprites/Heroes/Wizzard/Run/Run-Sheet-Wand.png", 64, 64);
        // setDeathSheet("../../ressources/sprites/Heroes/Wizzard/Death/Death-Sheet-Wand.png", 64, 32);
        // si le joueur choisit grand baton
        setIdleSheet("../../ressources/sprites/Heroes/Wizzard/Idle/Idle-Sheet-Big-Wand.png", 32, 32);
        setRunSheet("../../ressources/sprites/Heroes/Wizzard/Run/Run-Sheet-Big-Wand.png", 64, 64);
        setDeathSheet("../../ressources/sprites/Heroes/Wizzard/Death/Death-Sheet-Big-Wand.png", 64, 32);
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
