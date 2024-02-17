package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.Main;

public class MainMenu extends JPanel {

    public MainMenu() {
        super();

        JLabel title = new JLabel("Duke's Adventures");
        Box characterBox = Box.createHorizontalBox();
        JLabel hunter = new JLabel(new ImageIcon(Main.hunterImage.getScaledInstance(Main.hunterImage.getWidth() * 4,
                Main.hunterImage.getHeight() * 4, Image.SCALE_DEFAULT)));
        JLabel warrior = new JLabel(new ImageIcon(Main.warriorImage.getScaledInstance(Main.warriorImage.getWidth() * 4,
                Main.warriorImage.getHeight() * 4, Image.SCALE_DEFAULT)));
        JLabel witcher = new JLabel(new ImageIcon(Main.witcherImage.getScaledInstance(Main.witcherImage.getWidth() * 4,
                Main.witcherImage.getHeight() * 4, Image.SCALE_DEFAULT)));
        JButton play = new JButton("Play");
        JButton quit = new JButton("Quit");
        Dimension buttonSize = new Dimension(192, 96);

        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createGlue());

        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setFont(Main.font.deriveFont(48f));
        title.setForeground(Color.WHITE);
        add(title);

        add(Box.createRigidArea(new Dimension(0, 32)));

        characterBox.add(hunter);
        characterBox.add(Box.createRigidArea(new Dimension(32, 0)));
        characterBox.add(warrior);
        characterBox.add(Box.createRigidArea(new Dimension(32, 0)));
        characterBox.add(witcher);
        add(characterBox);

        add(Box.createRigidArea(new Dimension(0, 64)));

        play.setAlignmentX(CENTER_ALIGNMENT);
        play.setFont(Main.font);
        play.setBackground(Color.BLACK);
        play.setForeground(Color.WHITE);
        play.setFocusable(false);
        play.setMaximumSize(buttonSize);
        play.setPreferredSize(buttonSize);
        play.setActionCommand("play");
        play.addActionListener(Main.getInstance());
        add(play);

        add(Box.createRigidArea(new Dimension(0, 32)));

        quit.setAlignmentX(CENTER_ALIGNMENT);
        quit.setFont(Main.font);
        quit.setBackground(Color.BLACK);
        quit.setForeground(Color.WHITE);
        quit.setFocusable(false);
        quit.setMaximumSize(buttonSize);
        quit.setPreferredSize(buttonSize);
        quit.setActionCommand("quit");
        quit.addActionListener(Main.getInstance());
        add(quit);

        add(Box.createGlue());
    }
}
