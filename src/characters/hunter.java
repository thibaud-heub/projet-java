package characters;

import weapons.*;

public class hunter extends character {
    private weapon chosenWeapon;
    
    public hunter(weapon chosenWeapon) {
        
        super(100, 10, 0, 5, 0, 0, 10, 0, "Chasseur", 1, 100, 5);
        this.chosenWeapon = chosenWeapon;
       

        String[] idlePaths = {
            "../../ressources/sprites/Heroes/Rogue/Idle_1.png",
            "../../ressources/sprites/Heroes/Rogue/Idle_2.png",
            "../../ressources/sprites/Heroes/Rogue/Idle_3.png",
            "../../ressources/sprites/Heroes/Rogue/Idle_4.png",
        };
        
        setIdleSprites(idlePaths);
        String[] runPaths = {
            "../../ressources/sprites/Heroes/Rogue/Run_1.png",
            "../../ressources/sprites/Heroes/Rogue/Run_2.png",
            "../../ressources/sprites/Heroes/Rogue/Run_3.png",
            "../../ressources/sprites/Heroes/Rogue/Run_4.png",
        };
        setRunSprites(runPaths);

        String[] DeathPaths = {
            "../../ressources/sprites/Heroes/Rogue/Death_1.png",
        };
        setDeathSprites(DeathPaths);
        String[] AttackPaths = {
            "../../ressources/sprites/Heroes/Rogue/Hit.png"
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
        if (chosenWeapon instanceof spike){
            attackSpeed = 5;
        }
        else if (chosenWeapon instanceof katana){
            attackSpeed = 10;
        }
        return attackSpeed;
    }

}
