package weapons;

public class sword extends weapon {

    public sword() {
        this.name = "Epee";
        this.manaUsed = 5;
        this.durability = 100;
        this.attackSpeed = 10;
        this.range = 10.0;
        damage.setPhysic(20);
        damage.setFire(0);
        damage.setMagic(0);


        // Chargement des sprites
        String[] weaponPaths = {
            "/ressources/sprites/Weapons/Warrior/sword/sword_1.png",
            "/ressources/sprites/Weapons/Warrior/sword/sword_2.png",
            "/ressources/sprites/Weapons/Warrior/sword/sword_3.png",
            "/ressources/sprites/Weapons/Warrior/sword/sword_4.png",
        };
        setWeaponSprites(weaponPaths);
    }

    // Getters pour repositionner l'arme

    public int getOffsetWeaponX(){
        return 11;
     }
 
     public int getOffsetWeaponY(){
         return 7;
     }
}
