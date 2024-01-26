package characters;


import weapons.*;

public class witcher extends character {

    private weapon chosenWeapon;
    
    public witcher(weapon chosenWeapon) {
        // Appel du constructeur de la classe Entity avec les paramètres nécessaires
        super(100, 0, 0, 10, 0, 0, 10, "Magicien", 1, 100, 3); 
        this.chosenWeapon = chosenWeapon;
        

        // Initialisation des sprites
        String[] idlePaths = {
            "../../ressources/sprites/Heroes/Witcher/Idle_1.png",
            "../../ressources/sprites/Heroes/Witcher/Idle_2.png",
            "../../ressources/sprites/Heroes/Witcher/Idle_3.png",
            "../../ressources/sprites/Heroes/Witcher/Idle_4.png",
        };
        setIdleSprites(idlePaths);

        String[] runPaths = {
            "../../ressources/sprites/Heroes/Witcher/Run_1.png",
            "../../ressources/sprites/Heroes/Witcher/Run_2.png",
            "../../ressources/sprites/Heroes/Witcher/Run_3.png",
            "../../ressources/sprites/Heroes/Witcher/Run_4.png",
        };
        setRunSprites(runPaths);

        String[] DeathPaths = {
            "../../ressources/sprites/Heroes/Witcher/Death_1.png",
        };
        setDeathSprites(DeathPaths);
       
    }

    // Getters pour l'arme, la vitesse

    public int getSpeed(){
        return speed;
    }

    public weapon getWeapon(){
        return chosenWeapon;
    }
}
