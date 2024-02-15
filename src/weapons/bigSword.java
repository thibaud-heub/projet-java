package weapons;


public class bigSword extends weapon {
    public bigSword() {
        this.name = "Grande épée";
        this.manaUsed = 20;
        this.durability = 100;
        this.attackSpeed = 20;
        this.range = 14.0;
        damage.setPhysic(25);
        damage.setFire(0);
        damage.setMagic(0);

        // Chargement des sprites
        String[] weaponPaths = {
            "../../ressources/sprites/Weapons/Warrior/bigSword/bigSword_1.png",
            "../../ressources/sprites/Weapons/Warrior/bigSword/bigSword_2.png",
            "../../ressources/sprites/Weapons/Warrior/bigSword/bigSword_3.png",
            "../../ressources/sprites/Weapons/Warrior/bigSword/bigSword_4.png",
            
        };
        setWeaponSprites(weaponPaths);
    }
    
    // Getters pour repositionner l'arme
    
    public int getOffsetWeaponX(){
       return 11;
    }

    public int getOffsetWeaponY(){
        return 0;
    }
}