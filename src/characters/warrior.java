package characters;



import weapons.*;

public class warrior extends character {
    private weapon chosenWeapon;

    
    public warrior(weapon chosenWeapon) {
    super(100, 5, 0, 10, 0, 0, 10, 0, "Guerrier", 1, 100, 1);
        this.chosenWeapon = chosenWeapon;
        String[] idlePaths = {
            "../../ressources/sprites/Heroes/Warrior/Idle_1.png",
            "../../ressources/sprites/Heroes/Warrior/Idle_2.png",
            "../../ressources/sprites/Heroes/Warrior/Idle_3.png",
            "../../ressources/sprites/Heroes/Warrior/Idle_4.png",
        };
        
        setIdleSprites(idlePaths);
        String[] runPaths = {
            "../../ressources/sprites/Heroes/Warrior/Run_1.png",
            "../../ressources/sprites/Heroes/Warrior/Run_2.png",
            "../../ressources/sprites/Heroes/Warrior/Run_3.png",
            "../../ressources/sprites/Heroes/Warrior/Run_4.png",
        };
        setRunSprites(runPaths);

        String[] DeathPaths = {
            "../../ressources/sprites/Heroes/Warrior/Death_1.png",
        };
        setDeathSprites(DeathPaths);


        String[] AttackPaths = {
            "../../ressources/sprites/Heroes/Warrior/Hit.png"
        };
        setAttackSprites(AttackPaths);
    }

    public weapon getWeapon(){
        return chosenWeapon;
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
