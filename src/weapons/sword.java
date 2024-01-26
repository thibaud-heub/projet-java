package weapons;

public class sword extends weapon {

    public sword() {
        this.name = "Epee";
        this.damage = 25;
        this.manaUsed = 5;
        this.durability = 100;
        this.attackSpeed = 10;


        // Chargement des sprites
        String[] weaponPaths = {
            "../../ressources/sprites/Weapons/Warrior/sword/sword_1.png",
            "../../ressources/sprites/Weapons/Warrior/sword/sword_2.png",
            "../../ressources/sprites/Weapons/Warrior/sword/sword_3.png",
            "../../ressources/sprites/Weapons/Warrior/sword/sword_4.png",
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
         return 7;
     }
}
