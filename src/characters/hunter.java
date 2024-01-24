package characters;

import weapons.*;

public class hunter extends character {
    private weapon chosenWeapon;
    private int offsetWeaponX;
    private int offsetWeaponY;

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

        // String[] DeathPaths = {
        //     "../../ressources/sprites/Heroes/Rogue/Death_1.png",
        //     "../../ressources/sprites/Heroes/Rogue/Death_2.png",
        //     "../../ressources/sprites/Heroes/Rogue/Death_3.png",
        //     "../../ressources/sprites/Heroes/Rogue/Death_4.png",
        // };
        // setDeathSprites(DeathPaths);
        String[] AttackPaths = {
            "../../ressources/sprites/Heroes/Rogue/Hit.png"
        };
        setAttackSprites(AttackPaths);

        // si le joueur choisit dagues
        if(chosenWeapon instanceof spike){
            String[] weaponPaths = {
                "../../ressources/sprites/Weapons/Rogue/spike/spike_1.png",
                "../../ressources/sprites/Weapons/Rogue/spike/spike_2.png",
                "../../ressources/sprites/Weapons/Rogue/spike/spike_3.png",
            };
        setWeaponSprites(weaponPaths);
        }
        // si le joueur choisit le katana
        if(chosenWeapon instanceof katana){
            String[] weaponPaths = {
                "../../ressources/sprites/Weapons/Rogue/katana/katana_1.png",
                "../../ressources/sprites/Weapons/Rogue/katana/katana_2.png",
                "../../ressources/sprites/Weapons/Rogue/katana/katana_3.png",
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
        if (chosenWeapon instanceof spike){
            attackSpeed = 5;
        }
        else if (chosenWeapon instanceof katana){
            attackSpeed = 10;
        }
        return attackSpeed;
    }

    public int getOffsetWeaponX(){
        if (chosenWeapon instanceof spike){
            offsetWeaponX = 12;
        }
        else if (chosenWeapon instanceof katana){
            offsetWeaponX = 10;
        }
        return offsetWeaponX;
    }

    public int getOffsetWeaponY(){
        if (chosenWeapon instanceof spike){
            offsetWeaponY = 13;
        }
        else if (chosenWeapon instanceof katana){
            offsetWeaponY = -2;
        }
        return offsetWeaponY;
    }
}
