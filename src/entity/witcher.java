package entity;



public class witcher extends character {

    
    public witcher() {
        // Appel du constructeur de la classe Entity avec les paramètres nécessaires
        super(100, 1, 1, 10, 1, 1, 10, "Magicien", 3); 
        

        // Initialisation des sprites
        String[] idlePaths = {
            "/ressources/sprites/Heroes/Witcher/Idle_1.png",
            "/ressources/sprites/Heroes/Witcher/Idle_2.png",
            "/ressources/sprites/Heroes/Witcher/Idle_3.png",
            "/ressources/sprites/Heroes/Witcher/Idle_4.png",
        };
        setIdleSprites(idlePaths);

        String[] runPaths = {
            "/ressources/sprites/Heroes/Witcher/Run_1.png",
            "/ressources/sprites/Heroes/Witcher/Run_2.png",
            "/ressources/sprites/Heroes/Witcher/Run_3.png",
            "/ressources/sprites/Heroes/Witcher/Run_4.png",
        };
        setRunSprites(runPaths);

        String[] DeathPaths = {
            "/ressources/sprites/Heroes/Witcher/Death_1.png",
        };
        setDeathSprites(DeathPaths);
       
    }

    // Getters pour la vitesse

    public int getSpeed(){
        return speed;
    }
}
