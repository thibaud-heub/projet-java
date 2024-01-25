package weapons;

public class spike extends weapon {

    public spike() {
        this.name = "Dague";
        this.damage = 10;
        this.manaUsed = 2;
        this.durability = 100;

        String[] weaponPaths = {
            "../../ressources/sprites/Weapons/Rogue/spike/spike_1.png",
            "../../ressources/sprites/Weapons/Rogue/spike/spike_2.png",
            "../../ressources/sprites/Weapons/Rogue/spike/spike_3.png",
            "../../ressources/sprites/Weapons/Rogue/spike/spike_4.png",
        };
    setWeaponSprites(weaponPaths);
    }

    public int getOffsetWeaponX(){
        return 12;
    }

    public int getOffsetWeaponY(){
        return 13;
    }
}
