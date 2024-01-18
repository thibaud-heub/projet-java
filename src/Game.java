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
    private final int SPEED = 5;
    private final int DELAY = 1000 / 30; // fps
    private Timer timer; // la boucle
    private boolean runningLeft = false;
    private boolean deathAnimationPlayed = false;
    private int deathAnimationDelay = 0;
    private final int DEATH_ANIMATION_SPEED = 8; // plus c'est grand plus c'est lent

    private enum State { IDLE, RUNNING, DEATH }
    private State currentState = State.IDLE;

    public GamePanel() {
        currentCharacter = new hunter();
        timer = new Timer(DELAY, this);
        timer.start();
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image sprite;
        int spriteWidth;
        int spriteHeight;
        
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
                spriteIndex = (spriteIndex + 1) % currentCharacter.getRunFrameCount();
                break;
            case IDLE:
                spriteIndex = (spriteIndex + 1) % currentCharacter.getIdleFrameCount();
                break;
            case DEATH:
            // implémentation d'un délai pour que ça aille plus lentement
            if (deathAnimationDelay++ >= DEATH_ANIMATION_SPEED) {
                deathAnimationDelay = 0; 
                if (spriteIndex < currentCharacter.getDeathFrameCount() - 1) {
                    spriteIndex++; 
                    deathAnimationPlayed = true;
                }
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
            xPos += SPEED;
        } else if (key == KeyEvent.VK_LEFT) {
            currentState = State.RUNNING;
            runningLeft = true;
            xPos -= SPEED;
        } else if (key == KeyEvent.VK_UP) {
            currentState = State.RUNNING;
            yPos -= SPEED;
        } else if (key == KeyEvent.VK_DOWN) {
            currentState = State.RUNNING;
            yPos += SPEED;
        }

        if (key == KeyEvent.VK_D) {
            currentState = State.DEATH;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_D) {
            // ne rien changer, on est mort
        }
        else {
            currentState = State.IDLE;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}

public class Game extends JFrame {
    public Game() {
        add(new GamePanel());
        setTitle("DnD");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Game game = new Game();
            game.setVisible(true);
        });
    }
}
