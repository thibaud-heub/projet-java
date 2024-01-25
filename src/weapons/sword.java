package weapons;

public class sword extends weapon {

    public sword() {
        this.name = "Epee";
        this.damage = 25;
        this.manaUsed = 5;
        this.durability = 100;

        String[] weaponPaths = {
            "../../ressources/sprites/Weapons/Warrior/sword/sword_1.png",
            "../../ressources/sprites/Weapons/Warrior/sword/sword_2.png",
            "../../ressources/sprites/Weapons/Warrior/sword/sword_3.png",
            "../../ressources/sprites/Weapons/Warrior/sword/sword_4.png",
        };
    setWeaponSprites(weaponPaths);
    }

    public int getOffsetWeaponX(){
        return 11;
     }
 
     public int getOffsetWeaponY(){
         return 7;
     }
}
