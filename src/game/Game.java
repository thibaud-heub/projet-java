package game;
import java.awt.BorderLayout;

import javax.swing.JPanel;

public class Game extends JPanel {
    private GamePanel gamePanel;

    public Game() {
        HUDPanel hudPanel = new HUDPanel();
        KeyPanel keyPanel = new KeyPanel();
        gamePanel = new GamePanel(hudPanel);

        setLayout(new BorderLayout());
        add(gamePanel, BorderLayout.CENTER);
        add(hudPanel, BorderLayout.WEST);
        add(keyPanel, BorderLayout.SOUTH);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }
}
