package weapons;


public class bigSword extends weapon {
    public bigSword() {
        this.name = "Grande épée";
        this.damage = 50;
        this.manaUsed = 20;
        this.durability = 100;
        this.attackSpeed = 20;

        // Chargement des sprites
        String[] weaponPaths = {
            "../../ressources/sprites/Weapons/Warrior/bigSword/bigSword_1.png",
            "../../ressources/sprites/Weapons/Warrior/bigSword/bigSword_2.png",
            "../../ressources/sprites/Weapons/Warrior/bigSword/bigSword_3.png",
            "../../ressources/sprites/Weapons/Warrior/bigSword/bigSword_4.png",
            
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
       return 11;
    }

    public int getOffsetWeaponY(){
        return 0;
    }
}