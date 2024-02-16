package weapons;

public class magicWand extends weapon {

    public magicWand() {
        this.name = "Baton magique";
        this.manaUsed = 5;
        this.durability = 100;
        this.attackSpeed = 10;
        this.range = 12.0;
        damage.setPhysic(0);
        damage.setFire(0);
        damage.setMagic(15);

        // Chargement des sprites
        String[] weaponPaths = {
            "/ressources/sprites/Weapons/Witcher/magicWand/magicWand_1.png",
            "/ressources/sprites/Weapons/Witcher/magicWand/magicWand_2.png",
            "/ressources/sprites/Weapons/Witcher/magicWand/magicWand_3.png",
            "/ressources/sprites/Weapons/Witcher/magicWand/magicWand_4.png",
        };
        setWeaponSprites(weaponPaths);
    }
    
    // Getters pour repositionner l'arme

    public int getOffsetWeaponX(){
        return 10;
    }

    public int getOffsetWeaponY(){
        return -3;
    }
}
