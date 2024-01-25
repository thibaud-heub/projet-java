package weapons;

public class bigMagicWand extends weapon {

    public bigMagicWand() {
        this.name = "Grand bâton magique";
        this.damage = 15;
        this.manaUsed = 5;
        this.durability = 100;

        String[] weaponPaths = {
            "../../ressources/sprites/Weapons/Witcher/bigMagicWand/bigMagicWand_1.png",
            "../../ressources/sprites/Weapons/Witcher/bigMagicWand/bigMagicWand_2.png",
            "../../ressources/sprites/Weapons/Witcher/bigMagicWand/bigMagicWand_3.png",
            "../../ressources/sprites/Weapons/Witcher/bigMagicWand/bigMagicWand_4.png",

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