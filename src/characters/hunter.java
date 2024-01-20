package characters;

import java.util.Scanner;
import weapons.*;

public class hunter extends character {
    private static final int IDLE_FRAME_COUNT = 4;
    private static final int RUN_FRAME_COUNT = 6;
    private static final int DEATH_FRAME_COUNT = 6;

    public hunter(weapon chosenWeapon) {
        super(100, 10, 0, 5, 0, 0, 10, 0, "Chasseur", 1, 100, 5);
       
        /* L'attaque avec les spikes se fait en 3 frames ou bien avec les frames (2-3) */
        /* L'attaque avec le katana se fait en 4 frames ou bien avec les frames (2-3-4) */
        

        // si le joueur choisit dagues
        if(chosenWeapon instanceof spike){
            setIdleSheet("../../ressources/sprites/Heroes/Rogue/Idle/Idle-Sheet-Spikes.png", 32, 32);
            setRunSheet("../../ressources/sprites/Heroes/Rogue/Run/Run-Sheet-Spikes.png", 64, 64);
            setDeathSheet("../../ressources/sprites/Heroes/Rogue/Death/Death-Sheet-Spikes.png", 64, 32);
        }
        // si le joueur choisit la houe
        if(chosenWeapon instanceof katana)
        {setIdleSheet("../../ressources/sprites/Heroes/Rogue/Idle/Idle-Sheet-Katana.png", 32, 32);
        setRunSheet("../../ressources/sprites/Heroes/Rogue/Run/Run-Sheet-Katana.png", 64, 64);
        setDeathSheet("../../ressources/sprites/Heroes/Rogue/Death/Death-Sheet-Katana.png", 64, 32);}
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
