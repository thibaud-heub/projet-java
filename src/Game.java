import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import characters.*;

class GamePanel extends JPanel implements ActionListener, KeyListener {
    private character currentCharacter;
    private int xPos = 100;
    private int yPos = 100;
    private int spriteIndex = 0;
    private final int DELAY = 1000 / 30; // fps
    private Timer timer; // la boucle
    private boolean runningLeft = false;
    private int speed;
    private int attackSpeed;
    private int attackDelay = 0;
    private boolean deathAnimationPlayed = false;
    private int AnimationDelay = 0;
    private boolean isAttacking = false;
    private boolean isDefending = false;
    private String chosenWeapon;
    private final int DEATH_ANIMATION_SPEED = 8; // plus c'est grand plus c'est lent
    private final int ANIMATION_SPEED = 3;
    private int weaponYAdjustment = 0;
    private int amountToAdjust;

    private enum State { IDLE, RUNNING, DEATH, ATTACK }
    private State currentState = State.IDLE;

    public GamePanel(character chosenCharacter) {
        this.currentCharacter = chosenCharacter;
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

        
        BufferedImage[] sprites;
        BufferedImage[] weaponSprites;
        Image sprite;
        Image weaponSprite;
        speed = currentCharacter.getSpeed();
        attackSpeed = currentCharacter.getAttackSpeed();
        chosenWeapon = currentCharacter.getWeapon();
        int spriteWidth;
        int spriteHeight;
        int weaponWidth;
        int weaponHeight;

        weaponSprites = currentCharacter.getWeaponSprites();
        weaponSprite = weaponSprites[0];


        switch (currentState) {
            case RUNNING:
                sprites = currentCharacter.getRunSprites();
                break;
            // case DEATH:
            //     sprites = currentCharacter.getDeathSprites();
            //     break;
            case IDLE:
            default:
                sprites = currentCharacter.getIdleSprites();
                break;
            case ATTACK:
                sprites = currentCharacter.getIdleSprites();
                weaponSprite = weaponSprites[spriteIndex];
                break;
        }

        sprite = sprites[spriteIndex];

        int drawX = xPos;
        int drawY = yPos;
        int offsetWeaponX = currentCharacter.getOffsetWeaponX();
        int offsetWeaponY = currentCharacter.getOffsetWeaponY();
        int weaponX = xPos + offsetWeaponX;
        int weaponY = yPos + offsetWeaponY;
        amountToAdjust = 32;

        spriteWidth = sprite.getWidth(null);
        weaponWidth = weaponSprite.getWidth(null);
        spriteHeight = sprite.getHeight(null);
        weaponHeight = weaponSprite.getHeight(null);

        int weaponYAdjusted = weaponY + weaponYAdjustment;

        if (currentState == State.RUNNING) {
            weaponYAdjusted -= 2; 
        }
        



        if (runningLeft) {
            // inversion de l'image du sprite pour courir vers la gauche
            g.drawImage(weaponSprite, drawX + spriteWidth - weaponWidth - offsetWeaponX + amountToAdjust, weaponYAdjusted, -weaponWidth, weaponHeight, this);
            g.drawImage(sprite, drawX + spriteWidth, drawY, -spriteWidth, spriteHeight, this);
        } else {
            g.drawImage(weaponSprite, weaponX, weaponYAdjusted, this);
            g.drawImage(sprite, drawX, drawY, spriteWidth, spriteHeight, this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (currentState) {
            case RUNNING:
            if (AnimationDelay++ >= ANIMATION_SPEED) {
                AnimationDelay = 0; 
                spriteIndex = (spriteIndex + 1) % currentCharacter.getRunSprites().length;
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
            if (AnimationDelay++ >= ANIMATION_SPEED) {
                AnimationDelay = 0; 
                spriteIndex = (spriteIndex + 1) % currentCharacter.getIdleSprites().length;
                if (spriteIndex % 2 == 0) { 
                if (weaponYAdjustment == 0) {
                    weaponYAdjustment = 1;
                } else {
                    weaponYAdjustment = 0; 
                }
            }
                break;
                
            }
            // case DEATH:
            // // implémentation d'un autre délai pour que ça aille plus lentement
            // if (AnimationDelay++ >= DEATH_ANIMATION_SPEED) {
            //     AnimationDelay = 0; 
            //     if (spriteIndex < currentCharacter.getDeathSprites().length - 1) {
            //         spriteIndex++; 
            //         deathAnimationPlayed = true;
            //     }
            // }
            // break;
            case ATTACK:
                if (spriteIndex < currentCharacter.getWeaponSprites().length - 1) {
                    spriteIndex++;
                } else  {
                    spriteIndex = 0; 
                    currentState = State.IDLE;
                }

            if (attackDelay++ >= attackSpeed) {
                isAttacking = false;    
                attackDelay = 0;
            }
            break;
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            currentState = State.RUNNING;
            runningLeft = false;
            xPos += speed;
        } else if (key == KeyEvent.VK_LEFT) {
            currentState = State.RUNNING;
            runningLeft = true;
            xPos -= speed;
        } else if (key == KeyEvent.VK_UP) {
            currentState = State.RUNNING;
            yPos -= speed;
        } else if (key == KeyEvent.VK_DOWN) {
            currentState = State.RUNNING;
            yPos += speed;
        }

        if (key == KeyEvent.VK_U) {
            currentState = State.DEATH;
        }

        
        if (key == KeyEvent.VK_A && !isAttacking) {
            isAttacking = true;
            currentState = State.ATTACK;
            spriteIndex = 0; 
            attackDelay = 0; 
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_D) {
            currentState = State.IDLE;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}

public class Game extends JFrame {
    public Game(character chosenCharacter) {
        add(new GamePanel(chosenCharacter));
        setTitle("DnD");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
