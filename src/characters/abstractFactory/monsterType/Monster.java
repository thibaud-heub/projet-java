package characters.abstractFactory.monsterType;

import characters.character;
import characters.entity;
import characters.typeDamage;

import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.awt.image.BufferedImage;


import javax.imageio.ImageIO;

public abstract class Monster extends entity {

    public enum monsterType {COMMON, ELITE, BOSS}
    public enum State {IDLE, WALK, ATTACK, DEATH}
    
    protected BufferedImage[] idleSprites;
    protected BufferedImage[] walkSprites;
    protected BufferedImage[] deathSprites;
    protected BufferedImage[] attackSprites;

    private State state = State.WALK;
    private int id = -1;
    private double X;
    private double Y;
    private monsterType monsterType; //indique si le monstre est common ou elite
    private int difficulty;
    private double speed;

    // Pour l'IA
    private long lastAttackTime = 0;
    // Distance après laquelle le monstre s'arrête
    private static final int STOP_DISTANCE = 50; 
    // Enumération des directions
    private enum Direction {
        NORTH, SOUTH, EAST, WEST
    };
    // Distance parcourue depuis le dernier arrêt
    private int distanceSinceLastStop = 0;
    private Random random = new Random();
    private Direction direction = chooseRandomDirection();
    private boolean runningLeft;
    private int adjustedWidth;
    private double maxPV;

/**
 * Constructeur de la classe monstre, permet de créer un monstre en définissant tous ses paramètres
 * @param monsterStats : Les stats du monstre que l'on souhaite créer, issu de la classe monsterStats
 * @param Type : Type du monstre : commun ou elite
 */
    public Monster (monsterType Type, Map<String, Integer> monsterStats, int difficulty, double speed, int adjustedWidth)
    {
        super(
            monsterStats.get("PV"), 
            monsterStats.get("FireResistance"), 
            monsterStats.get("PhysicResistance"), 
            monsterStats.get("MagicResistance"), 
            monsterStats.get("FireDamage"), 
            monsterStats.get("PhysicDamage"), 
            monsterStats.get("MagicDamage")
        );
        this.monsterType = Type;
        this.attackSpeed = monsterStats.get("AttackSpeed");
        this.maxPV = monsterStats.get("PV");
        this.difficulty = difficulty;
        this.speed = speed;
        this.adjustedWidth = adjustedWidth;
    }

    /**
     * Affiche les données du monstre
     */
    public void print ()
    {
        System.out.println("Id : " + this.id);
        super.print();
        System.out.println("coordonée X = " + this.X + " Y = " + this.Y);
        System.out.println("Type : " + monsterType + "\n");
    }

    /**
     * Attaque le joueur 
     * @param Player Le joueur attaqué
     */
    public void attack(entity Player) {           

        typeDamage damage = this.getDamage();
        // Attaque le joueur
        Player.take_damage(damage);
    }  

    public int isDead(){
        // Si le monstre est mort, transformer la difficulté en XP
        if (!this.getAlive()){
            this.setState(Monster.State.DEATH);
            return this.difficulty;
        }
        else return 0;
    }
    
    // Setters pour définir l'id, les coordonnées l'état et les sprites du monstre

    public void setId(int id)
    {
        this.id = id;
    }

    public void setXY (double x, double y)
    {
        this.X = x;
        this.Y = y;
    }


    public void setState(State state)
    {
        this.state = state;
    }

    protected void setIdleSprites(String[] paths) {
    idleSprites = new BufferedImage[paths.length];
    for (int i = 0; i < paths.length; i++) {
        try {
            idleSprites[i] = ImageIO.read(getClass().getResourceAsStream(paths[i]));
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
    }

    protected void setWalkSprites(String[] paths) {
        walkSprites = new BufferedImage[paths.length];
        for (int i = 0; i < paths.length; i++) {
            try {
                walkSprites[i] = ImageIO.read(getClass().getResourceAsStream(paths[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void setDeathSprites(String[] paths) {
        deathSprites = new BufferedImage[paths.length];
        for (int i = 0; i < paths.length; i++) {
            try {
                deathSprites[i] = ImageIO.read(getClass().getResourceAsStream(paths[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void setAttackSprites(String[] paths) {
        attackSprites = new BufferedImage[paths.length];
        for (int i = 0; i < paths.length; i++) {
            try {
                attackSprites[i] = ImageIO.read(getClass().getResourceAsStream(paths[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLastAttackTime(long lastAttackTime) {
        this.lastAttackTime = lastAttackTime;
    }

    // Getters pour obtenir les sprites, l'id, les coordonnées et l'état du monstre


    public double getMaxPV()
    {
        return maxPV;

    }
    public long getLastAttackTime() {
        return lastAttackTime;
    }

    public int getId() {
        return id;
    }

    public double getX()
    {
        return this.X;
    }

    public double getY()
    {
        return this.Y;
    }

    public State getState()
    {
        return this.state;
    }

    public int getAttackSpeed()
    {
        return this.attackSpeed;
    }

    public double getSpeed()
    {
        return this.speed;
    }

    public int getAdjustedWidth() {
        return adjustedWidth;
    }

    public BufferedImage[] getIdleSprites() {
        return idleSprites;
    }
    public BufferedImage[] getWalkSprites() {
        return walkSprites;
    }
    public BufferedImage[] getDeathSprites() {
        return deathSprites;
    }
    public BufferedImage[] getAttackSprites() {
        return attackSprites;
    }


    
    /**
     * Méthode qui permet de définir le comportement du monstre
     * @param monster Le monstre en question
     * @param player Le joueur actuel
     */
    public void IA(Monster monster, character player) {
        if (monster.getState() == State.DEATH) {
            return; 
        }
        double distance = isPlayerNear(monster, player);
        if (distance > 8 && distance < 100) {
            moveToPlayer(monster, player);
        } else if (distance <= 10) {
            attackPlayer(monster, player);
        } 
        else {
            ride_monster(monster);
        }
    }


    /**
     * Méthode pour déplacer le monstre vers le joueur
     * @param monster Le monstre en question
     * @param player Le joueur actuel
     */
    private void moveToPlayer(Monster monster, character player) {
        // Récupérer les positions actuelles
        double monsterX = monster.getX();
        double monsterY = monster.getY();
        double playerX = player.getX();
        double playerY = player.getY();
        
        // Calculer la différence de position pour déterminer la direction
        double dx = playerX - monsterX;
        double dy = playerY - monsterY;

        double distance = Math.sqrt(dx * dx + dy * dy);
        // Normaliser le vecteur de direction pour s'assurer que le monstre se déplace à une vitesse constante
        double normalizedDx = dx / distance;
        double normalizedDy = dy / distance;
        
        // Définir une vitesse de déplacement pour le monstre
        double speed = monster.getSpeed(); 
        
        // Calculer les nouvelles positions basées sur la direction et la vitesse
        double newX = monsterX + normalizedDx * speed ;
        double newY = monsterY + normalizedDy * speed;
        
        monster.setXY(newX, newY);
    }
    


    /**
     * Méthode pour vérifier si le joueur est proche du monstre
     * @param monster Le monstre en question
     * @param player Le joueur actuel
     * @param radius Le rayon de détection
     * @return La distance entre les 2 entités
     */
    private double isPlayerNear(Monster monster, character player) {
        double monsterX = monster.getX();
        double monsterY = monster.getY();
        double playerX = player.getX();
        double playerY = player.getY();

        // Distance entre le monstre et le joueur
        double distance = Math.sqrt(Math.pow(monsterX - playerX, 2) + Math.pow(monsterY - playerY, 2));

        // On retourne la distance
        return distance;
    }

    /**
     * Méthode pour attaquer le joueur
     * @param monster Le monstre en question
     * @param player Le joueur actuel
     */
    private void attackPlayer(Monster monster, character player) {
        long currentTime = System.currentTimeMillis(); 
        long timeSinceLastAttack = currentTime - monster.getLastAttackTime();
    
        long attackDelay = (21 - monster.getAttackSpeed()) * 500;
        if(monster.getAlive()){
            if (timeSinceLastAttack >= attackDelay && monster.getState() != Monster.State.DEATH) {
                monster.setState(Monster.State.ATTACK);
                monster.attack(player);
                monster.setLastAttackTime(currentTime); // Mise à jour du temps de la dernière attaque pour ce monstre
            }
            else if(monster.getState() != Monster.State.DEATH){
                monster.setState(Monster.State.IDLE);
            }
        }
    }
    

    /**
     * Méthode pour faire bouger le monstre
     * @param monster Le monstre en question
     */
    public void ride_monster(Monster monster) {
        if(monster.getState() != Monster.State.DEATH){
            monster.setState(State.WALK);
        }
        // Si un mur est proche, on inverse la direction
        if (isWallAhead(monster, direction)) {
            direction = reverseDirection(direction);
        }

        // Si le monstre a parcouru une certaine distance, on l'arrête et on change de direction
        if (distanceSinceLastStop >= STOP_DISTANCE) {
                direction = chooseRandomDirection();
                distanceSinceLastStop = 0;
        } 
        // Sinon on continue de bouger dans la direction actuelle, et on incrémente la distance parcourure depuis le dernier arrêt
        else {
            moveMonster(monster, direction);
            distanceSinceLastStop += 1 ;
        }
        moveMonster(monster, direction);
    }


    /**
     * Méthode pour choisir une direction aléatoire
     * @return La direction choisie
     */
    private Direction chooseRandomDirection() {
        // Génère un nombre aléatoire entre 0 et 3
        int directionIndex = random.nextInt(4); 
        switch (directionIndex) {
            case 0: return Direction.NORTH;
            case 1: return Direction.SOUTH;
            case 2: return Direction.EAST;
            case 3: return Direction.WEST;
            default: return Direction.NORTH; 
        }
    }


    /**
     * Méthode pour vérifier si un mur est proche
     * @param monster Le monstre en question
     * @param direction La direction actuelle du monstre
     * @return Vrai si un mur est proche, faux sinon
     */
    private boolean isWallAhead(Monster monster, Direction direction) {
        return false;
    }
    

    /**
     * Méthode pour inverser la direction
     * @param direction La direction actuelle du monstre
     * @return La direction opposée
     */
    private Direction reverseDirection(Direction direction) {
        switch (direction) {
            case NORTH: return Direction.SOUTH;
            case SOUTH: return Direction.NORTH;
            case EAST:  return Direction.WEST;
            case WEST:  return Direction.EAST;
        }
        return direction; 
    }

    /**
     * Méthode pour déplacer le monstre dans une direction donnée
     * @param monster Le monstre en question
     * @param direction La direction actuelle du monstre
     */
    private void moveMonster(Monster monster, Direction direction) {
        if(monster.getState() != Monster.State.DEATH){
            monster.setState(State.WALK);
        }
        double speed = monster.getSpeed();

        // Récupérer les positions actuelles
        double monsterX = monster.getX();
        double monsterY = monster.getY();
    
        // Déplacer le monstre en fonction de la direction
        switch (direction) {
            case NORTH:
                monster.setXY(monsterX, monsterY - speed);
                break;
            case SOUTH:
                monster.setXY(monsterX, monsterY + speed);
                break;
            case EAST:
                monster.setXY(monsterX + speed, monsterY);
                setRunningLeft(false);
                break;
            case WEST:
                monster.setXY(monsterX - speed, monsterY);
                setRunningLeft(true);
                break;
        }
    }

    private void setRunningLeft(boolean runningLeft) {
        this.runningLeft = runningLeft;
    }

    public boolean getRunningLeft() {
        return runningLeft;
    }
}


