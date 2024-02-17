package entity;

public class hunter extends character {
    
    public hunter() {
        
        // Appel du constructeur de la classe Entity avec les paramètres nécessaires
        super(100, 0, 5, 3, 0, 10, 3, "Chasseur", 5);
       


        // Initialisation des sprites
        String[] idlePaths = {
            "/ressources/sprites/Heroes/Rogue/Idle_1.png",
            "/ressources/sprites/Heroes/Rogue/Idle_2.png",
            "/ressources/sprites/Heroes/Rogue/Idle_3.png",
            "/ressources/sprites/Heroes/Rogue/Idle_4.png",
        };
        setIdleSprites(idlePaths);
        String[] runPaths = {
            "/ressources/sprites/Heroes/Rogue/Run_1.png",
            "/ressources/sprites/Heroes/Rogue/Run_2.png",
            "/ressources/sprites/Heroes/Rogue/Run_3.png",
            "/ressources/sprites/Heroes/Rogue/Run_4.png",
        };
        setRunSprites(runPaths);

        String[] DeathPaths = {
            "/ressources/sprites/Heroes/Rogue/Death_1.png",
        };
        setDeathSprites(DeathPaths);
     }

     // Getters pour la vitesse

    public int getSpeed(){
        return speed;
    }
    
}
