package game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import characters.character;
import characters.Drawing.DrawCharacters;
import characters.Drawing.DrawMonsters;
import characters.MonsterGame.monsterManager;
import characters.abstractFactory.monsterType.Monster;
import tile.TileManager;
import weapons.weapon;
import weapons.Drawing.DrawWeapons;


public class GamePanel extends JPanel implements KeyListener {
    private GameLoop gameLoop;
    // private HUDPanel hudPanel;
    private character currentCharacter;
    private weapon currentWeapon;
    private Monster[] monsters;
    private TileManager tileM = new TileManager(this);

    private int xPos = 100;
    private int yPos = 100;

    private int[] monsterXPositions;
    private int[] monsterYPositions;


    private int spriteIndex = 0;
    private int weaponSpriteIndex = 0;
    private int monsterSpriteIndex[];


    private boolean runningLeft = false;
    private int weaponYAdjustment = 0;

    private weapon.State currentWeaponState;
    private character.State currentState;
    private boolean deathAnimationPlayed = false;
    private int AnimationDelay = 0;
    private int AnimationMonsterDelay = 0;
    private int AnimationMonsterDeathDelay = 0;
    private boolean isAttacking = false;
    private final int DEATH_ANIMATION_SPEED = 8; // plus c'est grand plus c'est lent
    private final int ANIMATION_SPEED = 3;
    private final int ANIMATION_MONSTER_SPEED = 3;
    private int attackSpeed;
    private int attackDelay = 0;
    private int speed;
    private Set<Integer> pressedKeys = new HashSet<>();



    public GamePanel(HUDPanel hudPanel, character currentCharacter, weapon currentWeapon) {
        this.currentCharacter = currentCharacter;
        this.currentWeapon = currentWeapon;
        // this.hudPanel = hudPanel;
        
        currentState = currentCharacter.getState();
        speed = currentCharacter.getSpeed();
        attackSpeed = currentWeapon.getSpeedAttack();
        currentWeaponState = currentWeapon.getState();
        currentCharacter.setChosenWeapon(currentWeapon);
        monsterManager manager = new monsterManager();
        monsters = manager.monstersLevel(false);
        monsterSpriteIndex = new int[monsters.length];
        for (int i = 0; i < monsters.length; i++) {
            monsterSpriteIndex[i] = 0;
        }
        
        setFocusable(true);
        addKeyListener(this);
        gameLoop = new GameLoop(this, hudPanel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        tileM.draw(g);

        if (monsterXPositions == null || monsterYPositions == null) {
            initializeMonsterPositions();
        }

        // draw the monsters
        for (int i = 0; i < monsters.length; i++) {
            if(monsters[i]!=null){
                monsterXPositions[i] = (int) monsters[i].getX();
                monsterYPositions[i] = (int) monsters[i].getY();

                // Dessiner la barre de vie
                int healthWidth = 30; // Largeur de la barre de vie
                int healthHeight = 5; // Hauteur de la barre de vie
                int healthX =  monsterXPositions[i] - (healthWidth / 2) + monsters[i].getAdjustedWidth(); 
                int healthY = monsterYPositions[i] - 5; //Barre un peu au-dessus du monstre

                double healthPercentage = monsters[i].getPV() / monsters[i].getMaxPV();
                int currentHealthWidth = (int) (healthWidth * healthPercentage);

                // Dessiner le fond de la barre de vie
                g.setColor(Color.RED);
                g.fillRect(healthX, healthY, healthWidth, healthHeight);

                // Dessiner la barre de vie actuelle
                g.setColor(Color.GREEN);
                g.fillRect(healthX, healthY, currentHealthWidth, healthHeight);

                monsters[i].IA(monsters[i], currentCharacter);
                
                DrawMonsters monsterDrawer = new DrawMonsters(monsters[i], monsterXPositions[i], monsterYPositions[i], monsterSpriteIndex[i], monsters[i].getRunningLeft(), this);
                monsterDrawer.draw(g);
            }
        }


        // draw the character
        currentCharacter.setXY(xPos, yPos);
        DrawCharacters drawer = new DrawCharacters(currentCharacter, xPos, yPos, spriteIndex, runningLeft, this);
        drawer.draw(g);


        // draw the weapon
        if (!deathAnimationPlayed){
            DrawWeapons weaponDrawer = new DrawWeapons(currentWeapon, currentCharacter, xPos, yPos, weaponSpriteIndex, runningLeft, weaponYAdjustment, this);
            weaponDrawer.draw(g);
        }   

        

    }

    public void initializeMonsterPositions() {
        Random random = new Random();
        monsterXPositions = new int[monsters.length];
        monsterYPositions = new int[monsters.length];
        
        for (int i = 0; i < monsters.length; i++) {
            monsters[i].setXY(random.nextInt(getWidth() - 32), random.nextInt(getHeight() - 32));
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
        updateState();   
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
        updateState();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void updateState() {
        boolean isMoving = pressedKeys.stream().anyMatch(key -> key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_A);
        if (pressedKeys.contains(KeyEvent.VK_A) && !isAttacking && currentCharacter.attack(monsters)) {
            // Commencer l'attaque
            isAttacking = true;
            currentWeaponState = weapon.State.ATTACK;
            currentWeapon.setState(weapon.State.ATTACK);
            weaponSpriteIndex = 0;
        }
        
        if (pressedKeys.contains(KeyEvent.VK_RIGHT)) {
            // Déplacer vers la droite
            currentState = character.State.RUNNING;
            currentCharacter.setState(character.State.RUNNING);
            runningLeft = false;
            xPos += speed;
        }
        if (pressedKeys.contains(KeyEvent.VK_LEFT)) {
            // Déplacer vers la gauche
            currentState = character.State.RUNNING;
            currentCharacter.setState(character.State.RUNNING);
            runningLeft = true;
            xPos -= speed;
        }
        if (pressedKeys.contains(KeyEvent.VK_UP)) {
            // Déplacer vers le haut
            currentState = character.State.RUNNING;
            currentCharacter.setState(character.State.RUNNING);
            yPos -= speed;
        }
        if (pressedKeys.contains(KeyEvent.VK_DOWN)) {
            // Déplacer vers le bas
            currentState = character.State.RUNNING;
            currentCharacter.setState(character.State.RUNNING);
            yPos += speed;
        }
        if (pressedKeys.contains(KeyEvent.VK_U)) {
            // Mourir
            currentState = character.State.DEATH;
            currentCharacter.setState(character.State.DEATH);
        }
        if (!isMoving && !isAttacking) {
            // Arrêter le personnage
            currentState = character.State.IDLE;
            currentCharacter.setState(character.State.IDLE);
        }
    }

    public void updateGame() {
        switch (currentState) {
            case RUNNING:
            // running animation
            if (AnimationDelay++ >= ANIMATION_SPEED) {
                AnimationDelay = 0; 
                spriteIndex = (spriteIndex + 1) % currentCharacter.getRunSprites().length;
                // pour que l'arme bouge avec le personnage
                if (spriteIndex % 2 == 0) { 
                    if (weaponYAdjustment == 0) {
                        weaponYAdjustment = 1; 
                    } else {
                        weaponYAdjustment = 0; 
                    }
                }
            }
            break;
            case IDLE:
            // idle animation
            if (AnimationDelay++ >= ANIMATION_SPEED) {
                AnimationDelay = 0; 
                spriteIndex = (spriteIndex + 1) % currentCharacter.getIdleSprites().length;
                // pour que l'arme bouge avec le personnage
                if (spriteIndex % 2 == 0) { 
                    if (weaponYAdjustment == 0) {
                        weaponYAdjustment = 1;
                    } else {
                        weaponYAdjustment = 0; 
                    }
                }
            }
            break;     
            case DEATH:
            // implémentation d'un autre délai pour que ça aille plus lentement
            if (AnimationDelay++ >= DEATH_ANIMATION_SPEED) {
                AnimationDelay = 0; 
                if (spriteIndex < currentCharacter.getDeathSprites().length - 1) {
                    spriteIndex++; 
                    deathAnimationPlayed = true;
                }
            }
            
            break;
        }
    
            switch(currentWeaponState){
                case ATTACK:
                // attack weapon
                    if (weaponSpriteIndex < currentWeapon.getWeaponSprites().length - 1) {
                        weaponSpriteIndex++;
                    } 
                    else {
                        if (attackDelay++ >= attackSpeed) {
                            // Réinitialise l'état d'attaque et les paramètres associés
                            isAttacking = false;
                            attackDelay = 0;
                            weaponSpriteIndex = 0; 
                            currentWeaponState = weapon.State.IDLE;
                            currentWeapon.setState(weapon.State.IDLE);
                        }
                    }
                break;  
    
                case IDLE:
                // idle weapon
                    if(!isAttacking){
                        weaponSpriteIndex = 0;
                    }
                    break;
            }
            
            for (int i = 0; i < monsters.length; i++){
                if(monsters[i] != null){
                    switch(monsters[i].getState()) {
                        default:
                        case WALK:
                            if (AnimationMonsterDelay++ >= ANIMATION_MONSTER_SPEED) {
                                AnimationMonsterDelay = 0; 
                                monsterSpriteIndex[i] = (monsterSpriteIndex[i] + 1) % monsters[i].getWalkSprites().length;
                            }
                            break;
                        case ATTACK:
                            monsterSpriteIndex[i] = (monsterSpriteIndex[i] + 1) % monsters[i].getAttackSprites().length;
                            break;

                        case DEATH:
                            if(monsterSpriteIndex[i] < monsters[i].getDeathSprites().length - 1){
                                if(AnimationMonsterDeathDelay++ >= DEATH_ANIMATION_SPEED){
                                    AnimationMonsterDeathDelay = 0;
                                    monsterSpriteIndex[i] = monsterSpriteIndex[i] + 1;
                                }
                            }else{
                                // Logique pour remove le monstre du tableau de monstres et du tableau des index
                                Monster[] arr_new = new Monster[monsters.length-1];
                                int[] newMonsterSpriteIndex = new int[monsterSpriteIndex.length - 1];
                                for(int j=0, k=0;j<monsters.length;j++){
                                    if(j!=i){
                                        arr_new[k]=monsters[j];
                                        newMonsterSpriteIndex[k] = monsterSpriteIndex[j];
                                        k++;
                                    }
                                }   
                                monsters = arr_new;
                                monsterSpriteIndex = newMonsterSpriteIndex;
                            }                        
                            break;
                        case IDLE:
                        if (AnimationMonsterDelay++ >= ANIMATION_MONSTER_SPEED) {
                            AnimationMonsterDelay = 0; 
                            monsterSpriteIndex[i] = (monsterSpriteIndex[i] + 1) % monsters[i].getIdleSprites().length;
                            break;
                        }
                    }
                }
            }

        if(!currentCharacter.getAlive()){
            gameLoop.stop();
            SwingUtilities.getWindowAncestor(this).dispose();
        }
        currentCharacter.setMana(0.2);
        currentCharacter.setPV(0.02);
        repaint();
    }

    public character getCurrentCharacter() {
        return currentCharacter;
    }
    public weapon getCurrentWeapon(){
        return currentWeapon;
    }

}
