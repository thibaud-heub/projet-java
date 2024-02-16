package weapons;

public class bigMagicWand extends weapon {

    public bigMagicWand() {
        this.name = "Grand bâton magique";
        this.manaUsed = 5;
        this.durability = 100;
        this.attackSpeed = 15;
        this.range = 20.0;
        damage.setPhysic(5);
        damage.setFire(0);
        damage.setMagic(25);

        // Chargement des sprites
        String[] weaponPaths = {
            "/ressources/sprites/Weapons/Witcher/bigMagicWand/bigMagicWand_1.png",
            "/ressources/sprites/Weapons/Witcher/bigMagicWand/bigMagicWand_2.png",
            "/ressources/sprites/Weapons/Witcher/bigMagicWand/bigMagicWand_3.png",
            "/ressources/sprites/Weapons/Witcher/bigMagicWand/bigMagicWand_4.png",
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