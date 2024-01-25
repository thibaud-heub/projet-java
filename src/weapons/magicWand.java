package weapons;

public class magicWand extends weapon {

    public magicWand() {
        this.name = "Baton magique";
        this.damage = 15;
        this.manaUsed = 5;
        this.durability = 100;

        String[] weaponPaths = {
            "../../ressources/sprites/Weapons/Witcher/magicWand/magicWand_1.png",
            "../../ressources/sprites/Weapons/Witcher/magicWand/magicWand_2.png",
            "../../ressources/sprites/Weapons/Witcher/magicWand/magicWand_3.png",
            "../../ressources/sprites/Weapons/Witcher/magicWand/magicWand_4.png",
        };
    setWeaponSprites(weaponPaths);
    }

    public int getOffsetWeaponX(){
        return 10;
    }

    public int getOffsetWeaponY(){
        return -3;
    }
}
