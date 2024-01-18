package characters;

import java.util.Scanner;
import weapons.*;

public class hunter extends character {
    private static final int IDLE_FRAME_COUNT = 4;
    private static final int RUN_FRAME_COUNT = 6;
    private static final int DEATH_FRAME_COUNT = 6;

    public hunter() {
        super(100, 10, 0, 5, 0, 0, 10, 0, "Chasseur", 1, 100, 5);
        setIdleSheet("../../ressources/sprites/Heroes/Rogue/Idle/Idle-Sheet.png", 32, 32);
        setRunSheet("../../ressources/sprites/Heroes/Rogue/Run/Run-Sheet.png", 64, 64);
        setDeathSheet("../../ressources/sprites/Heroes/Rogue/Death/Death-Sheet.png", 64, 32);
    }

    public weapon chooseWeapon(Scanner scanner) {
        System.out.println("Choisissez une arme pour votre chasseur :");
        System.out.println("1. Dague");
        System.out.println("2. Arc");

        System.out.print("Entrez le numéro de votre choix : ");
        int weaponChoice = scanner.nextInt();
        scanner.nextLine(); 

        switch (weaponChoice) {
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
