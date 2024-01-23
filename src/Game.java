import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

    private enum State { IDLE, RUNNING, DEATH, ATTACK, DEFENSE }
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

        
        Image sprite;
        int spriteWidth;
        int spriteHeight;
        speed = currentCharacter.getSpeed();
        attackSpeed = currentCharacter.getAttackSpeed();
        chosenWeapon = currentCharacter.getWeapon();

        
        switch (currentState) {
            case RUNNING:
                sprite = currentCharacter.getRunSprite(spriteIndex);
                break;
            case DEATH:
                sprite = currentCharacter.getDeathSprite(spriteIndex);
                break;
            case IDLE:
            default:
                sprite = currentCharacter.getIdleSprite(spriteIndex);
                break;
            case ATTACK:
                sprite = currentCharacter.getAttackSprite(spriteIndex);
                break;
            case DEFENSE:
                sprite = currentCharacter.getDefenseSprite(spriteIndex);
                break;
        }


        spriteWidth = sprite.getWidth(null);
        spriteHeight = sprite.getHeight(null);
        int drawX = xPos;
        int drawY = yPos;

        // logique pour rendre des sprites plus petits aussi grand que le 64x64
        if (spriteWidth < 64) {
            drawX += (64 - spriteWidth)/2;
        }
        if (spriteHeight < 64) {
            drawY += (64 - spriteHeight);
        }

        if (runningLeft) {
            // inversion de l'image du sprite pour courir vers la gauche
            g.drawImage(sprite, drawX + spriteWidth, drawY, -spriteWidth, spriteHeight, this);
        } else {
            g.drawImage(sprite, drawX, drawY, spriteWidth, spriteHeight, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (currentState) {
            case RUNNING:
            if (AnimationDelay++ >= ANIMATION_SPEED) {
                AnimationDelay = 0; 
                spriteIndex = (spriteIndex + 1) % currentCharacter.getRunFrameCount();
                break;
            }
                
                break;
            case IDLE:
            if (AnimationDelay++ >= ANIMATION_SPEED) {
                AnimationDelay = 0; 
                spriteIndex = (spriteIndex + 1) % currentCharacter.getIdleFrameCount();

                break;
            }
            case DEATH:
            // implémentation d'un autre délai pour que ça aille plus lentement
            if (AnimationDelay++ >= DEATH_ANIMATION_SPEED) {
                AnimationDelay = 0; 
                if (spriteIndex < currentCharacter.getDeathFrameCount() - 1) {
                    spriteIndex++; 
                    deathAnimationPlayed = true;
                }
            }
            break;
            case ATTACK:
            if (AnimationDelay++ >= ANIMATION_SPEED) {
                AnimationDelay = 0;
                if (spriteIndex < currentCharacter.getAttackFrameCount() - 1) {
                    spriteIndex++;
                } else if (attackDelay >= 20) {
                    spriteIndex = 0; 
                    currentState = State.IDLE;
                }
            }

            if (attackDelay++ >= attackSpeed) {
                isAttacking = false;    
                attackDelay = 0;
                currentState = State.IDLE;
            }
            break;
            case DEFENSE:
            if (AnimationDelay++ >= ANIMATION_SPEED) {
                AnimationDelay = 0;
                if (spriteIndex < currentCharacter.getDefenseFrameCount() - 1) {
                    spriteIndex++;
                } else {
                    spriteIndex = 0; 
                    currentState = State.IDLE;
                    isDefending = false;
                }
            }
            
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

        if (key == KeyEvent.VK_D && chosenWeapon == "Epee et bouclier"){
            isDefending = true;
            currentState = State.DEFENSE;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
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
