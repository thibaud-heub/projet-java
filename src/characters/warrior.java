package characters;



import weapons.*;

public class warrior extends character {
    private weapon chosenWeapon;
    private int offsetWeaponX;
    private int offsetWeaponY;
    
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

        // String[] DeathPaths = {
        //     "../../ressources/sprites/Heroes/Warrior/Death_1.png",
        //     "../../ressources/sprites/Heroes/Warrior/Death_2.png",
        //     "../../ressources/sprites/Heroes/Warrior/Death_3.png",
        //     "../../ressources/sprites/Heroes/Warrior/Death_4.png",
        // };
        // setDeathSprites(DeathPaths);


        String[] AttackPaths = {
            "../../ressources/sprites/Heroes/Warrior/Hit.png"
        };
        setAttackSprites(AttackPaths);

        // si le joueur choisit la petite épée
        if(chosenWeapon instanceof sword){
            String[] weaponPaths = {
                "../../ressources/sprites/Weapons/Warrior/sword/sword_1.png",
                "../../ressources/sprites/Weapons/Warrior/sword/sword_2.png",
                "../../ressources/sprites/Weapons/Warrior/sword/sword_3.png",
            };
        setWeaponSprites(weaponPaths);
        }
        // si le joueur choisit la grande épée
        if(chosenWeapon instanceof bigSword){
            String[] weaponPaths = {
                "../../ressources/sprites/Weapons/Warrior/bigSword/bigSword_1.png",
                "../../ressources/sprites/Weapons/Warrior/bigSword/bigSword_2.png",
                "../../ressources/sprites/Weapons/Warrior/bigSword/bigSword_3.png",
            };
            setWeaponSprites(weaponPaths);
        }
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

    public int getOffsetWeaponX(){
        if (chosenWeapon instanceof bigSword){
            offsetWeaponX = 11;
        }
        else if (chosenWeapon instanceof sword){
            offsetWeaponX = 11;
        }
        return offsetWeaponX;
    }

    public int getOffsetWeaponY(){
        if (chosenWeapon instanceof bigSword){
            offsetWeaponY = 0;
        }
        else if (chosenWeapon instanceof sword){
            offsetWeaponY = 7;
        }
        return offsetWeaponY;
    }
}
