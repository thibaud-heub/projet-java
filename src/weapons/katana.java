package weapons;

public class katana extends weapon {

    public katana() {
        this.name = "Katana";
        this.manaUsed = 5;
        this.durability = 100;
        this.attackSpeed = 10;
        this.range = 12.0;
        damage.setPhysic(15);
        damage.setFire(0);
        damage.setMagic(0);

        // Chargement des sprites
        String[] weaponPaths = {
            "../../ressources/sprites/Weapons/Rogue/katana/katana_1.png",
            "../../ressources/sprites/Weapons/Rogue/katana/katana_2.png",
            "../../ressources/sprites/Weapons/Rogue/katana/katana_3.png",
            "../../ressources/sprites/Weapons/Rogue/katana/katana_4.png",
        };
        setWeaponSprites(weaponPaths);
    }
    
    // Getters pour repositionner l'arme

    public int getOffsetWeaponX(){
        return 10;
    }

    public int getOffsetWeaponY(){
        return -2;
    }
}
