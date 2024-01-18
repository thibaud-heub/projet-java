package characters;

import java.util.Scanner;


import weapons.*;

public class warrior extends character {
    private static final int IDLE_FRAME_COUNT = 4;
    private static final int RUN_FRAME_COUNT = 6;
    private static final int DEATH_FRAME_COUNT = 6;
    

    public warrior() {
        super(100, 5, 0, 10, 0, 0, 10, 0, "Guerrier", 1, 100, 1);
        // si le choix de l'utilisateur est shield sword =>
        // setIdleSheet("../../ressources/sprites/Heroes/Knight/Idle/Idle-Sheet-Shield-Sword.png", 32, 32);
        // setRunSheet("../../ressources/sprites/Heroes/Knight/Run/Run-Sheet-Shield-Sword.png", 64, 64);
        // setDeathSheet("../../ressources/sprites/Heroes/Knight/Death/Death-Sheet-Shield-Sword.png", 48, 32);
        // si le choix de l'utilisateur est big sword =>
        setIdleSheet("../../ressources/sprites/Heroes/Knight/Idle/Idle-Sheet-Big-Sword.png", 32, 32);
        setRunSheet("../../ressources/sprites/Heroes/Knight/Run/Run-Sheet-Big-Sword.png", 64, 64);
        setDeathSheet("../../ressources/sprites/Heroes/Knight/Death/Death-Sheet-Big-Sword.png", 48, 32);
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

    public int getIdleFrameCount() {
        return IDLE_FRAME_COUNT;
    }

    public int getRunFrameCount() {
        return RUN_FRAME_COUNT;
    }

    public int getDeathFrameCount() {
        return DEATH_FRAME_COUNT;
    }

    public int getSpeed(){
        return speed;
    }
}
