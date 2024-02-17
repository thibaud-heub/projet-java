package game;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import entity.character;
import entity.hunter;
import weapons.katana;
import weapons.weapon;

public class Game extends JFrame {
    public Game() {
        setTitle("DnD");
        // setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        character chosenCharacter = new hunter();
        weapon chosenWeapon = new katana();

        HUDPanel hudPanel = new HUDPanel();
        KeyPanel keyPanel = new KeyPanel();
        GamePanel gamePanel = new GamePanel(hudPanel, chosenCharacter, chosenWeapon);

        add(gamePanel, BorderLayout.CENTER);
        add(hudPanel, BorderLayout.WEST);
        add(keyPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Game();
            }
        });
    }
}
