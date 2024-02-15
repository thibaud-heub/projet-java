import javax.swing.JFrame;
import java.awt.BorderLayout;
import characters.*;
import weapons.*;

public class Game extends JFrame {
    public Game() {
        setTitle("DnD");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        character chosenCharacter = new hunter();
        weapon chosenWeapon = new katana();

        HUDPanel hudPanel = new HUDPanel();
        GamePanel gamePanel = new GamePanel(hudPanel, chosenCharacter, chosenWeapon);

        add(gamePanel, BorderLayout.CENTER);
        add(hudPanel, BorderLayout.WEST);

        setVisible(true);
        gamePanel.initializeMonsterPositions();
    }

    public static void main(String[] args) {
        new Game();
    }
}
