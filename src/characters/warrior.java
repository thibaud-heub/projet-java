package characters;



import weapons.*;

public class warrior extends character {
    private static final int IDLE_FRAME_COUNT = 4;
    private static final int RUN_FRAME_COUNT = 6;
    private static final int DEATH_FRAME_COUNT = 6;
    private static final int ATTACK_FRAME_COUNT = 4;
    private static final int DEFENSE_FRAME_COUNT = 4;
    private weapon chosenWeapon;

    /* L'attaque avec la grande épée se fait en 4 frames ou bien avec les frames (2-3-4) */
    /* L'attaque avec la petite épée se fait en 4 frames ou bien avec les frames (1-2-3) */

    /*La défense se fait en 4 frames ou bien avec les frames (1-2-3) */

    
    public warrior(weapon chosenWeapon) {
    super(100, 5, 0, 10, 0, 0, 10, 0, "Guerrier", 1, 100, 1);
        this.chosenWeapon = chosenWeapon;
        // si le choix de l'utilisateur est shield sword =>
        if (chosenWeapon instanceof sword){
            setIdleSheet("../../ressources/sprites/Heroes/Knight/Idle/Idle-Sheet-Shield-Sword.png", 32, 32);
            setRunSheet("../../ressources/sprites/Heroes/Knight/Run/Run-Sheet-Shield-Sword.png", 64, 64);
            setDeathSheet("../../ressources/sprites/Heroes/Knight/Death/Death-Sheet-Shield-Sword.png", 48, 32);
            setAttackSheet("../../ressources/sprites/Heroes/Knight/Attack/Attack-Sheet-Shield-Sword.png", 64, 64);
            setDefenseSheet("../../ressources/sprites/Heroes/Knight/Defense/Defense-Sheet-Shield-Sword.png", 32, 32);
        }
        // si le choix de l'utilisateur est sword =>
        else if (chosenWeapon instanceof bigSword){
            setIdleSheet("../../ressources/sprites/Heroes/Knight/Idle/Idle-Sheet-Big-Sword.png", 32, 32);
            setRunSheet("../../ressources/sprites/Heroes/Knight/Run/Run-Sheet-Big-Sword.png", 64, 64);
            setDeathSheet("../../ressources/sprites/Heroes/Knight/Death/Death-Sheet-Big-Sword.png", 48, 32);
            setAttackSheet("../../ressources/sprites/Heroes/Knight/Attack/Attack-Sheet-Big-Sword.png", 64, 64);
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

    public int getAttackFrameCount() {
        return ATTACK_FRAME_COUNT;
    }

    public int getDefenseFrameCount(){
        return DEFENSE_FRAME_COUNT;
    }

    public String getWeapon(){
        return chosenWeapon.getName();
    }

    public int getSpeed(){
        return speed;
    }

    public int getAttackSpeed(){
        if (chosenWeapon instanceof sword){
            attackSpeed = 10;
        }
        else if (chosenWeapon instanceof bigSword){
            attackSpeed = 20;
        }
        return attackSpeed;
    }
}
