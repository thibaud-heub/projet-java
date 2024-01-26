package characters.MonsterGame;

import characters.abstractFactory.monsterType.Monster;

import java.util.Random;

import characters.character;

public class monsterIA {
    // Distance après laquelle le monstre s'arrête
    private static final int STOP_DISTANCE = 50; 
    // Temps d'attente en millisecondes
    private static final long WAIT_TIME = 5000;
    // Enumération des directions
    private enum Direction {
        NORTH, SOUTH, EAST, WEST
    };
    // Direction actuelle du monstre
    private Direction currentDirection;
    // Distance parcourue depuis le dernier arrêt
    private int distanceSinceLastStop = 0;
    private Random random = new Random();



    /**
     * Méthode qui permet de définir le comportement du monstre
     * @param monster Le monstre en question
     * @param player Le joueur actuel
     */
    public void IA(Monster monster, character player) {
        if (isPlayerNear(monster, player, 100)) {
            moveToPlayer(monster, player);
        } else {
            ride_monster(monster);
        }
    }


    /**
     * Méthode pour déplacer le monstre vers le joueur
     * @param monster Le monstre en question
     * @param player Le joueur actuel
     */
    private void moveToPlayer(Monster monster, character player) {
        // Logique pour déplacer le monstre vers le joueur
    }


    /**
     * Méthode pour vérifier si le joueur est proche du monstre
     * @param monster Le monstre en question
     * @param player Le joueur actuel
     * @param radius Le rayon de détection
     * @return Vrai si le joueur est proche du monstre, faux sinon
     */
    private boolean isPlayerNear(Monster monster, character player, int radius) {
        double monsterX = monster.getX();
        double monsterY = monster.getY();
        double playerX = player.getX();
        double playerY = player.getY();

        // Distance entre le monstre et le joueur
        double distance = Math.sqrt(Math.pow(monsterX - playerX, 2) + Math.pow(monsterY - playerY, 2));

        // Distance est inférieure ou égale au rayon on retourne vraie sinon faux
        return distance <= radius;
    }


    /**
     * Méthode pour faire bouger le monstre
     * @param monster Le monstre en question
     */
    public void ride_monster(Monster monster) {
        Direction direction = chooseRandomDirection();

        // Si un mur est proche, on inverse la direction
        if (isWallAhead(monster, direction)) {
            direction = reverseDirection(direction);
        }

        // Si le monstre a parcouru une certaine distance, on l'arrête et on change de direction
        if (distanceSinceLastStop >= STOP_DISTANCE) {
            stopAndWait(monster);
            currentDirection = chooseRandomDirection();
            distanceSinceLastStop = 0;
        } 
        // Sinon on continue de bouger dans la direction actuelle, et on incrémente la distance parcourure depuis le dernier arrêt
        else {
            moveMonster(monster, currentDirection);
            distanceSinceLastStop += 1 ;
        }
        moveMonster(monster, direction);
    }

    /**
     * Méthode pour arrêter le monstre et attendre
     * @param monster
     */
    private void stopAndWait(Monster monster) {
        try {
            Thread.sleep(WAIT_TIME); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
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
        double monsterX = monster.getX();
        double monsterY = monster.getY();
        // Si(hitbox monstre touche hitbox mur) return true;
        // Sinon
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
        // Logique pour déplacer le monstre dans une direction donnée
    }   

    
}
