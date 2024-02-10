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

public class CharacterMenu extends JPanel {

    public CharacterMenu() {
        super();

        JLabel title = new JLabel("Select a character");
        Box characterBox = Box.createHorizontalBox();
        JButton hunter = new JButton(new ImageIcon(Main.hunterImage.getScaledInstance(Main.hunterImage.getWidth() * 4,
                Main.hunterImage.getHeight() * 4, Image.SCALE_DEFAULT)));
        JButton warrior = new JButton(new ImageIcon(Main.warriorImage.getScaledInstance(Main.warriorImage.getWidth() * 4,
                Main.warriorImage.getHeight() * 4, Image.SCALE_DEFAULT)));
        JButton witcher = new JButton(new ImageIcon(Main.witcherImage.getScaledInstance(Main.witcherImage.getWidth() * 4,
                Main.witcherImage.getHeight() * 4, Image.SCALE_DEFAULT)));

        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createGlue());

        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setFont(Main.font.deriveFont(48f));
        title.setForeground(Color.WHITE);
        add(title);

        add(Box.createRigidArea(new Dimension(0, 64)));

        hunter.setBackground(Color.BLACK);
        hunter.setFocusable(false);
        hunter.setActionCommand("hunter");
        hunter.addActionListener(Main.getInstance());
        characterBox.add(hunter);
        characterBox.add(Box.createRigidArea(new Dimension(32, 0)));
        warrior.setBackground(Color.BLACK);
        warrior.setFocusable(false);
        warrior.setActionCommand("warrior");
        warrior.addActionListener(Main.getInstance());
        characterBox.add(warrior);
        characterBox.add(Box.createRigidArea(new Dimension(32, 0)));
        witcher.setBackground(Color.BLACK);
        witcher.setFocusable(false);
        witcher.setActionCommand("witcher");
        witcher.addActionListener(Main.getInstance());
        characterBox.add(witcher);
        add(characterBox);

        add(Box.createGlue());
    }
}
