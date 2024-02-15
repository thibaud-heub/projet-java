import javax.swing.Timer;

public class GameLoop {
    private Timer timer;
    private GamePanel gamePanel;
    private HUDPanel hudPanel;


    public GameLoop(GamePanel gamePanel, HUDPanel hudPanel) {
        this.gamePanel = gamePanel;
        this.hudPanel = hudPanel;
        init();
    }

    private void init() {
        timer = new Timer(1000 / 30, e -> update());
        timer.start();
    }

    private void update() {
    
        // Mettre à jour le HUD
        hudPanel.updateHUD(gamePanel.getCurrentCharacter().getPV(), gamePanel.getCurrentCharacter().getMana(), gamePanel.getCurrentCharacter().getLevel());

        // Mettre à jour les entités
        gamePanel.updateGame();
    }

    public void handleKeyPress(int keyCode) {
    }

    public void handleKeyRelease(int keyCode) {
    }
}
