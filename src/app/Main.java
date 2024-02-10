package app;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import menu.CharacterMenu;
import menu.HunterMenu;
import menu.MainMenu;
import menu.WarriorMenu;
import menu.WitcherMenu;
import room.Room;

public class Main implements Runnable, ActionListener {

    private static Main instance;
    private Container contentPane;

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
        switch (e.getActionCommand()) {
            case "play":
                cardLayout.show(contentPane, "CharacterMenu");
                break;
            case "hunter":
                cardLayout.show(contentPane, "HunterMenu");
                break;
            case "warrior":
                cardLayout.show(contentPane, "WarriorMenu");
                break;
            case "witcher":
                cardLayout.show(contentPane, "WitcherMenu");
                break;
            case "room":
                cardLayout.show(contentPane, "Room");
                break;
            case "quit":
                System.exit(0);
                break;
        }
    }

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    @Override
    public void run() {
        JFrame window = new JFrame("Duke's Adventures");
        contentPane = window.getContentPane();

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/font/04B_03__.TTF"))
                    .deriveFont(24f);

            hunterImage = ImageIO.read(getClass().getResourceAsStream("/image/hunter.png"));
            warriorImage = ImageIO.read(getClass().getResourceAsStream("/image/warrior.png"));
            witcherImage = ImageIO.read(getClass().getResourceAsStream("/image/witcher.png"));

            knifeImage = ImageIO.read(getClass().getResourceAsStream("/image/dague.png"));
            katanaImage = ImageIO.read(getClass().getResourceAsStream("/image/katana.png"));
            swordImage = ImageIO.read(getClass().getResourceAsStream("/image/epee.png"));
            greatSwordImage = ImageIO.read(getClass().getResourceAsStream("/image/grande_epee.png"));
            staffImage = ImageIO.read(getClass().getResourceAsStream("/image/baton.png"));
            greatStaffImage = ImageIO.read(getClass().getResourceAsStream("/image/grand_baton.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        contentPane.setPreferredSize(new Dimension(896, 640));
        contentPane.setBackground(Color.BLACK);
        contentPane.setLayout(new CardLayout());
        contentPane.add(new MainMenu(), "MainMenu");
        contentPane.add(new CharacterMenu(), "CharacterMenu");
        contentPane.add(new HunterMenu(), "HunterMenu");
        contentPane.add(new WarriorMenu(), "WarriorMenu");
        contentPane.add(new WitcherMenu(), "WitcherMenu");
        contentPane.add(new Room(14, 10, 32), "Room");

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main.getInstance());
    }
}
