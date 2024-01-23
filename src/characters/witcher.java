package characters;


import weapons.*;

public class witcher extends character {

    private static final int IDLE_FRAME_COUNT = 4;
    private static final int RUN_FRAME_COUNT = 6;
    private static final int DEATH_FRAME_COUNT = 6;
    private static final int ATTACK_FRAME_COUNT = 4;
    private static final int DEFENSE_FRAME_COUNT = 0;
    private weapon chosenWeapon;

    public witcher(weapon chosenWeapon) {
        super(100, 5, 0, 0, 10, 0, 0, 10, "Magicien", 1, 100, 3); 
       
        this.chosenWeapon = chosenWeapon;
        
        /* L'attaque avec le baton ou le grand baton se fait en 4 frames */

        // si le joueur choisit batôn normal
        if(chosenWeapon instanceof magicWand){
            setIdleSheet("../../ressources/sprites/Heroes/Wizzard/Idle/Idle-Sheet-Wand.png", 32, 32);
            setRunSheet("../../ressources/sprites/Heroes/Wizzard/Run/Run-Sheet-Wand.png", 64, 64);
            setDeathSheet("../../ressources/sprites/Heroes/Wizzard/Death/Death-Sheet-Wand.png", 64, 32);
            setAttackSheet("../../ressources/sprites/Heroes/Wizzard/Attack/Attack-Sheet-Wand.png", 32, 32);
        }
        // si le joueur choisit grand baton
        if(chosenWeapon instanceof bigMagicWand)
        setIdleSheet("../../ressources/sprites/Heroes/Wizzard/Idle/Idle-Sheet-Big-Wand.png", 32, 32);
        setRunSheet("../../ressources/sprites/Heroes/Wizzard/Run/Run-Sheet-Big-Wand.png", 64, 64);
        setDeathSheet("../../ressources/sprites/Heroes/Wizzard/Death/Death-Sheet-Big-Wand.png", 64, 32);
        setAttackSheet("../../ressources/sprites/Heroes/Wizzard/Attack/Attack-Sheet-Big-Wand.png", 32, 32);
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

    public int getSpeed(){
        return speed;
    }

    public String getWeapon(){
        return chosenWeapon.getName();
    }

    public int getAttackSpeed(){
        if (chosenWeapon instanceof magicWand){
            attackSpeed = 10;
        }
        else if (chosenWeapon instanceof bigMagicWand){
            attackSpeed = 15;
        }
        return attackSpeed;
    }
}
