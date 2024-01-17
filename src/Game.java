import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import sprites.*;

// GamePanel est responsable du dessin et de la mise à jour du jeu
class GamePanel extends JPanel implements ActionListener, KeyListener {
    private KnightIdle knightIdle;
    private KnightRun knightRun;
    private KnightDeath knightDeath;
    private int xPos = 100;
    private int yPos = 100;
    private int spriteIndex = 0;
    private final int SPEED = 5;
    private final int DELAY = 1000 / 60;
    private Timer timer;
    private boolean runningLeft = false;
    private boolean idle = true;


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
        if (runningLeft) {
            g.drawImage(knightRun.getRunFrame(spriteIndex), xPos + knightRun.getWidth(), yPos, -knightRun.getWidth(), knightRun.getHeight(), this);
        } 
        else {
            g.drawImage(knightRun.getRunFrame(spriteIndex), xPos, yPos, knightRun.getWidth(), knightRun.getHeight(), this);
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            runningLeft = false;
            xPos += SPEED;
            spriteIndex = (spriteIndex + 1) % knightRun.getFrameCount();
        }
        if (key == KeyEvent.VK_LEFT) {
            runningLeft = true;
            xPos -= SPEED;
            spriteIndex = (spriteIndex + 1) % knightRun.getFrameCount();
        }
        if (key == KeyEvent.VK_UP) {
            yPos -= SPEED;
            spriteIndex = (spriteIndex + 1) % knightRun.getFrameCount();
        }
        if (key == KeyEvent.VK_DOWN) {
            yPos += SPEED;
            spriteIndex = (spriteIndex + 1) % knightRun.getFrameCount();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}

// JFrame container for the game panel
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
