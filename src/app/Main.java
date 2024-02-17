package app;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import entity.hunter;
import entity.warrior;
import entity.witcher;
import game.Game;
import game.GamePanel;
import menu.CharacterMenu;
import menu.DiedMenu;
import menu.HunterMenu;
import menu.MainMenu;
import menu.WarriorMenu;
import menu.WinMenu;
import menu.WitcherMenu;
import weapons.bigMagicWand;
import weapons.bigSword;
import weapons.katana;
import weapons.magicWand;
import weapons.spike;
import weapons.sword;

public class Main implements Runnable, ActionListener {

    private static Main instance;
    private Container contentPane;
    private Game game;

    public static Font font;
    public static BufferedImage hunterImage;
    public static BufferedImage warriorImage;
    public static BufferedImage witcherImage;
    public static BufferedImage knifeImage;
    public static BufferedImage katanaImage;
    public static BufferedImage swordImage;
    public static BufferedImage greatSwordImage;
    public static BufferedImage staffImage;
    public static BufferedImage greatStaffImage;

    private Main() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        GamePanel gamePanel = game.getGamePanel();
        switch (e.getActionCommand()) {
            case "play":
                cardLayout.show(contentPane, "CharacterMenu");
                break;
            case "hunter":
                gamePanel.setCurrentCharacter(new hunter());
                cardLayout.show(contentPane, "HunterMenu");
                break;
            case "warrior":
            gamePanel.setCurrentCharacter(new warrior());
                cardLayout.show(contentPane, "WarriorMenu");
                break;
            case "witcher":
            gamePanel.setCurrentCharacter(new witcher());
                cardLayout.show(contentPane, "WitcherMenu");
                break;
            case "knife":
                gamePanel.setCurrentWeapon(new spike());
                launchGame();
                break;
            case "katana":
                gamePanel.setCurrentWeapon(new katana());
                launchGame();
                break;
            case "sword":
                gamePanel.setCurrentWeapon(new sword());
                launchGame();
                break;
            case "greatSword":
                gamePanel.setCurrentWeapon(new bigSword());
                launchGame();
                break;
            case "staff":
                gamePanel.setCurrentWeapon(new magicWand());
                launchGame();
                break;
            case "greatStaff":
                gamePanel.setCurrentWeapon(new bigMagicWand());
                launchGame();
                break;
            case "quit":
                System.exit(0);
                break;
        }
    }

    public void launchGame() {
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        GamePanel gamePanel = game.getGamePanel();
        gamePanel.getGameLoop().init();
        cardLayout.show(contentPane, "Game");
        gamePanel.requestFocus();
    }

    public void win() {
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, "WinMenu");
    }

    public void died() {
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, "DiedMenu");
    }

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    public Game getGame() {
        return game;
    }

    @Override
    public void run() {
        JFrame window = new JFrame("Duke's Adventures");
        contentPane = window.getContentPane();
        game = new Game();

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/ressources/font/04B_03__.TTF"))
                    .deriveFont(24f);

            hunterImage = ImageIO.read(getClass().getResourceAsStream("/ressources/menu/hunter.png"));
            warriorImage = ImageIO.read(getClass().getResourceAsStream("/ressources/menu/warrior.png"));
            witcherImage = ImageIO.read(getClass().getResourceAsStream("/ressources/menu/witcher.png"));

            knifeImage = ImageIO.read(getClass().getResourceAsStream("/ressources/menu/dague.png"));
            katanaImage = ImageIO.read(getClass().getResourceAsStream("/ressources/menu/katana.png"));
            swordImage = ImageIO.read(getClass().getResourceAsStream("/ressources/menu/epee.png"));
            greatSwordImage = ImageIO.read(getClass().getResourceAsStream("/ressources/menu/grande_epee.png"));
            staffImage = ImageIO.read(getClass().getResourceAsStream("/ressources/menu/baton.png"));
            greatStaffImage = ImageIO.read(getClass().getResourceAsStream("/ressources/menu/grand_baton.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        contentPane.setBackground(Color.BLACK);
        contentPane.setLayout(new CardLayout());
        contentPane.add(new MainMenu(), "MainMenu");
        contentPane.add(new CharacterMenu(), "CharacterMenu");
        contentPane.add(new HunterMenu(), "HunterMenu");
        contentPane.add(new WarriorMenu(), "WarriorMenu");
        contentPane.add(new WitcherMenu(), "WitcherMenu");
        contentPane.add(game, "Game");
        contentPane.add(new DiedMenu(), "DiedMenu");
        contentPane.add(new WinMenu(), "WinMenu");

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main.getInstance());
    }
}
