package weapons;

public class spike extends weapon {

    public spike() {
        this.name = "Dague";
        this.damage = 10;
        this.manaUsed = 2;
        this.durability = 100;
        this.attackSpeed = 5;

        // Chargement des sprites
        String[] weaponPaths = {
            "../../ressources/sprites/Weapons/Rogue/spike/spike_1.png",
            "../../ressources/sprites/Weapons/Rogue/spike/spike_2.png",
            "../../ressources/sprites/Weapons/Rogue/spike/spike_3.png",
            "../../ressources/sprites/Weapons/Rogue/spike/spike_4.png",
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
        return 12;
    }

    public int getOffsetWeaponY(){
        return 13;
    }
}
