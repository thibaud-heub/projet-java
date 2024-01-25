import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import characters.*;
import weapons.*;
import characters.abstractFactory.monsterType.Monster;
import weapons.Drawing.DrawWeapons;
import characters.Drawing.*;
import characters.MonsterGame.probaMonster;
import characters.MonsterGame.monsterManager;


class GamePanel extends JPanel implements ActionListener, KeyListener {
    private character currentCharacter;
    private weapon currentWeapon;
    private Monster[] monsters;

    private int xPos = 100;
    private int yPos = 100;

    private int monsterXPos = 100;
    private int monsterYPos = 100;


    private int spriteIndex = 0;
    private int weaponSpriteIndex = 0;
    private int monsterSpriteIndex = 0;


    private final int DELAY = 1000 / 30; // fps
    private Timer timer; // la boucle
    private boolean runningLeft = false;
    private int speed;
    private int attackSpeed;
    private int attackDelay = 0;
    private boolean deathAnimationPlayed = false;
    private int AnimationDelay = 0;
    private boolean isAttacking = false;
    private final int DEATH_ANIMATION_SPEED = 8; // plus c'est grand plus c'est lent
    private final int ANIMATION_SPEED = 3;
    private int weaponYAdjustment = 0;
    private character.State currentState;
    private weapon.State currentWeaponState;
    private Monster.State currentMonsterState;
    private Set<Integer> pressedKeys = new HashSet<>();


    public GamePanel(character chosenCharacter, Monster[] monsters) {
        this.currentCharacter = chosenCharacter;
        this.monsters = monsters;
        currentState = currentCharacter.getState();
        speed = currentCharacter.getSpeed();
        attackSpeed = currentCharacter.getAttackSpeed();
        currentWeapon = currentCharacter.getWeapon();
        currentWeaponState = currentWeapon.getState();

        for (int i = 0; i < monsters.length; i++){
            currentMonsterState = monsters[i].getState();
        }

        timer = new Timer(DELAY, this);
        timer.start();
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // put the background in black
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        // draw the character
        DrawCharacters drawer = new DrawCharacters(currentCharacter, xPos, yPos, spriteIndex, runningLeft, this);
        // draw the weapon
        DrawWeapons weaponDrawer = new DrawWeapons(currentWeapon, currentCharacter, xPos, yPos, weaponSpriteIndex, runningLeft, weaponYAdjustment, this);
        // draw the monsters
        for (int i = 0; i < monsters.length; i++) {
            DrawMonsters monsterDrawer = new DrawMonsters(monsters[i], monsterXPos + i*10, monsterYPos + i*3, monsterSpriteIndex, runningLeft, this);
            monsterDrawer.draw(g);
        }

        drawer.draw(g);
        weaponDrawer.draw(g);
        }

    
    


    @Override
    public void actionPerformed(ActionEvent e) {
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
                break;
            }
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
                break;     
            }
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
                    // délai de chaque arme
                    } else if (attackDelay++ >= attackSpeed) {
                        isAttacking = false;    
                        attackDelay = 0;
                        weaponSpriteIndex = 0; 
                        currentWeaponState = weapon.State.IDLE;
                        currentWeapon.setState(weapon.State.IDLE);
                    }
                break;  

                case IDLE:
                // idle weapon
                    if(!isAttacking){
                        weaponSpriteIndex = 0;
                    }
                    break;
            }

            switch(currentMonsterState){
                case IDLE:
                if (AnimationDelay++ >= ANIMATION_SPEED) {
                    AnimationDelay = 0; 
                    for (int i = 0; i < monsters.length; i++){
                        Monster currentMonster = monsters[i];
                        monsterSpriteIndex = (monsterSpriteIndex + 1) % currentMonster.getIdleSprites().length;
                    }
                }
                break;
                case WALK:
                    monsterSpriteIndex++;
                break;
                case DEATH:
                break;
                case ATTACK:
                break;
            }
        repaint();
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
        boolean isMoving = false;
        if (pressedKeys.contains(KeyEvent.VK_A) && !isAttacking) {
            // Commencer l'attaque
            isAttacking = true;
            currentWeaponState = weapon.State.ATTACK;
            currentWeapon.setState(weapon.State.ATTACK);
            weaponSpriteIndex = 0;
            attackDelay = 0;
        }
        
        if (pressedKeys.contains(KeyEvent.VK_RIGHT)) {
            // Déplacer vers la droite
            currentState = character.State.RUNNING;
            currentCharacter.setState(character.State.RUNNING);
            runningLeft = false;
            xPos += speed;
            isMoving = true;
        }
        if (pressedKeys.contains(KeyEvent.VK_LEFT)) {
            // Déplacer vers la gauche
            currentState = character.State.RUNNING;
            currentCharacter.setState(character.State.RUNNING);
            runningLeft = true;
            xPos -= speed;
            isMoving = true;
        }
        if (pressedKeys.contains(KeyEvent.VK_UP)) {
            // Déplacer vers le haut
            currentState = character.State.RUNNING;
            currentCharacter.setState(character.State.RUNNING);
            yPos -= speed;
            isMoving = true;
        }
        if (pressedKeys.contains(KeyEvent.VK_DOWN)) {
            // Déplacer vers le bas
            currentState = character.State.RUNNING;
            currentCharacter.setState(character.State.RUNNING);
            yPos += speed;
            isMoving = true;
        }
        if (pressedKeys.contains(KeyEvent.VK_U)) {
            // Mourir
            currentState = character.State.DEATH;
            currentCharacter.setState(character.State.DEATH);
        }
        if (!isMoving) {
            // Arrêter le personnage
            currentState = character.State.IDLE;
            currentCharacter.setState(character.State.IDLE);
        }
    }
}

public class Game extends JFrame {
    private Monster[] monsters;
    private GamePanel gamePanel;
    public Game(character chosenCharacter) {
        setTitle("DnD");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        monsterManager manager = new monsterManager();
        monsters = manager.monstersLevel(false); // Générer les monstres (false pour un niveau non final)

        gamePanel = new GamePanel(chosenCharacter, monsters); // Passer les monstres à GamePanel
        add(gamePanel);
    }
}
