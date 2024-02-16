package weapons;

public class spike extends weapon {

    public spike() {
        this.name = "Dague";
        this.manaUsed = 2;
        this.durability = 100;
        this.attackSpeed = 5;
        this.range = 7.0;
        damage.setPhysic(7);
        damage.setFire(0);
        damage.setMagic(0);

        // Chargement des sprites
        String[] weaponPaths = {
            "/ressources/sprites/Weapons/Rogue/spike/spike_1.png",
            "/ressources/sprites/Weapons/Rogue/spike/spike_2.png",
            "/ressources/sprites/Weapons/Rogue/spike/spike_3.png",
            "/ressources/sprites/Weapons/Rogue/spike/spike_4.png",
        };
        setWeaponSprites(weaponPaths);
    }

    // Getters pour repositionner l'arme
    
    public int getOffsetWeaponX(){
        return 12;
    }

    public int getOffsetWeaponY(){
        return 13;
    }
}
