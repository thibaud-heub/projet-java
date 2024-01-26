package weapons;

public class katana extends weapon {

    public katana() {
        this.name = "Katana";
        this.damage = 10;
        this.manaUsed = 5;
        this.durability = 100;
        this.attackSpeed = 10;

        // Chargement des sprites
        String[] weaponPaths = {
            "../../ressources/sprites/Weapons/Rogue/katana/katana_1.png",
            "../../ressources/sprites/Weapons/Rogue/katana/katana_2.png",
            "../../ressources/sprites/Weapons/Rogue/katana/katana_3.png",
            "../../ressources/sprites/Weapons/Rogue/katana/katana_4.png",
        };
        setWeaponSprites(weaponPaths);
    }


    // Setters pour la mana, les dégâts et la durabilité

    public int setDamage() {
        return this.damage;
    }

    public int setDurability() {
        return this.durability;
    }

    public int setMana() {
        return this.manaUsed;
    }

    
    // Getters pour repositionner l'arme

    public int getOffsetWeaponX(){
        return 10;
    }

    public int getOffsetWeaponY(){
        return -2;
    }
}
