package game;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import characters.character;
import characters.hunter;
import characters.MonsterGame.monsterManager;
import characters.abstractFactory.monsterType.Monster;
import dungeon.RoomBuilder;
import dungeon.RoomDirector;
import weapons.katana;
import weapons.weapon;

public class Game extends JFrame {
    public Game() {
        monsterManager manager = new monsterManager();
        Monster[] monsters = manager.monstersLevel(false);
        RoomBuilder r = new RoomBuilder();
        RoomDirector d = new RoomDirector(r);
        System.out.println(d.makeFightRoom(monsters));
        r.setSize(ALLBITS, ABORT);
        setTitle("DnD");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        character chosenCharacter = new hunter();
        weapon chosenWeapon = new katana();

        HUDPanel hudPanel = new HUDPanel();
        KeyPanel keyPanel = new KeyPanel();
        GamePanel gamePanel = new GamePanel(hudPanel, chosenCharacter, chosenWeapon);

        add(gamePanel, BorderLayout.CENTER);
        add(hudPanel, BorderLayout.WEST);
        add(keyPanel, BorderLayout.SOUTH);

        setVisible(true);
        gamePanel.initializeMonsterPositions();
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
