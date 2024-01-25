package weapons;


public class bigSword extends weapon {
    public bigSword() {
        this.name = "Hache de guerre";
        this.damage = 50;
        this.manaUsed = 20;
        this.durability = 100;

        String[] weaponPaths = {
            "../../ressources/sprites/Weapons/Warrior/bigSword/bigSword_1.png",
            "../../ressources/sprites/Weapons/Warrior/bigSword/bigSword_2.png",
            "../../ressources/sprites/Weapons/Warrior/bigSword/bigSword_3.png",
            "../../ressources/sprites/Weapons/Warrior/bigSword/bigSword_4.png",
            
        };
        setWeaponSprites(weaponPaths);
    }

    public int getOffsetWeaponX(){
       return 11;
    }

    public int getOffsetWeaponY(){
        return 0;
    }
}