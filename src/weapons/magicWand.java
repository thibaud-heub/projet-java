package weapons;

public class magicWand extends weapon {

    public magicWand() {
        this.name = "Baton magique";
        this.damage = 15;
        this.manaUsed = 5;
        this.durability = 100;
        this.attackSpeed = 10;

        // Chargement des sprites
        String[] weaponPaths = {
            "../../ressources/sprites/Weapons/Witcher/magicWand/magicWand_1.png",
            "../../ressources/sprites/Weapons/Witcher/magicWand/magicWand_2.png",
            "../../ressources/sprites/Weapons/Witcher/magicWand/magicWand_3.png",
            "../../ressources/sprites/Weapons/Witcher/magicWand/magicWand_4.png",
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
        return -3;
    }
}
