package weapons;

public class katana extends weapon {

    public katana() {
        this.name = "Houe";
        this.damage = 10;
        this.manaUsed = 5;
        this.durability = 100;

        String[] weaponPaths = {
            "../../ressources/sprites/Weapons/Rogue/katana/katana_1.png",
            "../../ressources/sprites/Weapons/Rogue/katana/katana_2.png",
            "../../ressources/sprites/Weapons/Rogue/katana/katana_3.png",
            "../../ressources/sprites/Weapons/Rogue/katana/katana_4.png",
        };
        setWeaponSprites(weaponPaths);
    }

    public int getOffsetWeaponX(){
        return 10;
    }

    public int getOffsetWeaponY(){
        return -2;
    }
}
