import javax.swing.Timer;
import characters.*;

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
    
        double PV = gamePanel.getCurrentCharacter().getPV();
        double mana = gamePanel.getCurrentCharacter().getMana();
        double XP = gamePanel.getCurrentCharacter().getLevel();
        typeDamage degats = gamePanel.getCurrentWeapon().getDamage();
        typeDamage resistance = gamePanel.getCurrentCharacter().getResistance();
        double dfire = degats.getFire();
        double dphysic = degats.getPhysic();
        double dmagic = degats.getMagic();
        double rfire = resistance.getFire();
        double rphysic = resistance.getPhysic();
        double rmagic = resistance.getMagic();
        double littleLevel = gamePanel.getCurrentCharacter().getLittleLevel();

        // Mettre à jour le HUD
        hudPanel.updateHUD(PV, mana, XP, rfire, rphysic, rmagic, dfire, dphysic, dmagic, littleLevel);

        // Mettre à jour les entités
        gamePanel.updateGame();
    }

    public void stop() {
        timer.stop();
    }

    public void handleKeyPress(int keyCode) {
    }

    public void handleKeyRelease(int keyCode) {
    }
}
