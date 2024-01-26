package characters;

import weapons.*;

public class hunter extends character {
    private weapon chosenWeapon;
    
    public hunter(weapon chosenWeapon) {
        
        // Appel du constructeur de la classe Entity avec les paramètres nécessaires
        super(100, 0, 5, 0, 0, 10, 0, "Chasseur", 1, 100, 5);
        this.chosenWeapon = chosenWeapon;
       


        // Initialisation des sprites
        String[] idlePaths = {
            "../../ressources/sprites/Heroes/Rogue/Idle_1.png",
            "../../ressources/sprites/Heroes/Rogue/Idle_2.png",
            "../../ressources/sprites/Heroes/Rogue/Idle_3.png",
            "../../ressources/sprites/Heroes/Rogue/Idle_4.png",
        };
        setIdleSprites(idlePaths);
        String[] runPaths = {
            "../../ressources/sprites/Heroes/Rogue/Run_1.png",
            "../../ressources/sprites/Heroes/Rogue/Run_2.png",
            "../../ressources/sprites/Heroes/Rogue/Run_3.png",
            "../../ressources/sprites/Heroes/Rogue/Run_4.png",
        };
        setRunSprites(runPaths);

        String[] DeathPaths = {
            "../../ressources/sprites/Heroes/Rogue/Death_1.png",
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
