import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import sprites.*;

class GamePanel extends JPanel implements ActionListener, KeyListener {
    private KnightIdle knightIdle;
    private KnightRun knightRun;
    private KnightDeath knightDeath;
    private int xPos = 100;
    private int yPos = 100;
    private int spriteIndex = 0;
    private final int SPEED = 5;
    private final int DELAY = 1000 / 30;
    private Timer timer;
    private boolean runningLeft = false;

    private enum State { IDLE, RUNNING, DEATH }
    private State currentState = State.IDLE;

    public GamePanel() {
        knightIdle = new KnightIdle();
        knightRun = new KnightRun();
        knightDeath = new KnightDeath();
        timer = new Timer(DELAY, this);
        timer.start();
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image sprite;
        switch (currentState) {
            case RUNNING:
                sprite = knightRun.getRunFrame(spriteIndex);
                break;
            case DEATH:
                sprite = knightDeath.getDeathFrame(spriteIndex);
                break;
            case IDLE:
            default:
                sprite = knightIdle.getIdleFrame(spriteIndex);
                break;
        }

        if (runningLeft) {
            g.drawImage(sprite, xPos + sprite.getWidth(null), yPos, -sprite.getWidth(null), sprite.getHeight(null), this);
        } else {
            g.drawImage(sprite, xPos, yPos, sprite.getWidth(null), sprite.getHeight(null), this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (currentState == State.RUNNING || currentState == State.IDLE) {
            spriteIndex = (spriteIndex + 1) % knightRun.getFrameCount(); 
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        currentState = State.RUNNING;
        if (key == KeyEvent.VK_RIGHT) {
            runningLeft = false;
            xPos += SPEED;
        } else if (key == KeyEvent.VK_LEFT) {
            runningLeft = true;
            xPos -= SPEED;
        } else if (key == KeyEvent.VK_UP) {
            yPos -= SPEED;
        } else if (key == KeyEvent.VK_DOWN) {
            yPos += SPEED;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        currentState = State.IDLE;
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
