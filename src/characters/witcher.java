package characters;


import weapons.*;

public class witcher extends character {

    private weapon chosenWeapon;
    private int offsetWeaponX;
    private int offsetWeaponY;

    public witcher(weapon chosenWeapon) {
        super(100, 5, 0, 0, 10, 0, 0, 10, "Magicien", 1, 100, 3); 
       
        this.chosenWeapon = chosenWeapon;
        
        String[] idlePaths = {
            "../../ressources/sprites/Heroes/Witcher/Idle_1.png",
            "../../ressources/sprites/Heroes/Witcher/Idle_2.png",
            "../../ressources/sprites/Heroes/Witcher/Idle_3.png",
            "../../ressources/sprites/Heroes/Witcher/Idle_4.png",
        };
        setIdleSprites(idlePaths);

        String[] runPaths = {
            "../../ressources/sprites/Heroes/Witcher/Run_1.png",
            "../../ressources/sprites/Heroes/Witcher/Run_2.png",
            "../../ressources/sprites/Heroes/Witcher/Run_3.png",
            "../../ressources/sprites/Heroes/Witcher/Run_4.png",
        };
        setRunSprites(runPaths);

        // String[] DeathPaths = {
        //     "../../ressources/sprites/Heroes/Witcher/Death_1.png",
        //     "../../ressources/sprites/Heroes/Witcher/Death_2.png",
        //     "../../ressources/sprites/Heroes/Witcher/Death_3.png",
        //     "../../ressources/sprites/Heroes/Witcher/Death_4.png",
        // };
        // setDeathSprites(DeathPaths);
        String[] AttackPaths = {
            "../../ressources/sprites/Heroes/Witcher/Hit.png"
        };
        setAttackSprites(AttackPaths);

        // si le joueur choisit le baton
        if(chosenWeapon instanceof magicWand){
            String[] weaponPaths = {
                "../../ressources/sprites/Weapons/Witcher/magicWand/magicWand_1.png",
                "../../ressources/sprites/Weapons/Witcher/magicWand/magicWand_2.png",
                "../../ressources/sprites/Weapons/Witcher/magicWand/magicWand_3.png",
            };
        setWeaponSprites(weaponPaths);
        }
        // si le joueur choisit le grand baton
        if(chosenWeapon instanceof bigMagicWand){
            String[] weaponPaths = {
                "../../ressources/sprites/Weapons/Witcher/bigMagicWand/bigMagicWand_1.png",
                "../../ressources/sprites/Weapons/Witcher/bigMagicWand/bigMagicWand_2.png",
                "../../ressources/sprites/Weapons/Witcher/bigMagicWand/bigMagicWand_3.png",
            };
            setWeaponSprites(weaponPaths);
        }
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

    public int getOffsetWeaponX(){
        if (chosenWeapon instanceof magicWand){
            offsetWeaponX = 10;
        }
        else if (chosenWeapon instanceof bigMagicWand){
            offsetWeaponX = 10;
        }
        return offsetWeaponX;
    }

    public int getOffsetWeaponY(){
        if (chosenWeapon instanceof magicWand){
            offsetWeaponY = -3;
        }
        else if (chosenWeapon instanceof bigMagicWand){
            offsetWeaponY = -3;
        }
        return offsetWeaponY;
    }
}
