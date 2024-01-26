package characters;



import weapons.*;

public class warrior extends character {
    private weapon chosenWeapon;

    
    public warrior(weapon chosenWeapon) {
            
        // Appel du constructeur de la classe Entity avec les paramètres nécessaires
        super(100, 0, 10, 0, 0, 10, 0, "Guerrier", 1, 100, 1);
        this.chosenWeapon = chosenWeapon;

        // Initialisation des sprites
        String[] idlePaths = {
            "../../ressources/sprites/Heroes/Warrior/Idle_1.png",
            "../../ressources/sprites/Heroes/Warrior/Idle_2.png",
            "../../ressources/sprites/Heroes/Warrior/Idle_3.png",
            "../../ressources/sprites/Heroes/Warrior/Idle_4.png",
        };
        
        setIdleSprites(idlePaths);
        String[] runPaths = {
            "../../ressources/sprites/Heroes/Warrior/Run_1.png",
            "../../ressources/sprites/Heroes/Warrior/Run_2.png",
            "../../ressources/sprites/Heroes/Warrior/Run_3.png",
            "../../ressources/sprites/Heroes/Warrior/Run_4.png",
        };
        setRunSprites(runPaths);

        String[] DeathPaths = {
            "../../ressources/sprites/Heroes/Warrior/Death_1.png",
            // "../../ressources/sprites/Heroes/Warrior/Death_2.png",
            // "../../ressources/sprites/Heroes/Warrior/Death_3.png",
            // "../../ressources/sprites/Heroes/Warrior/Death_4.png",
        };
        setDeathSprites(DeathPaths);      
    }


    // Getters pour l'arme, la vitesse

    public weapon getWeapon(){
        return chosenWeapon;
    }

    public int getSpeed(){
        return speed;
    }
}
