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
import javax.swing.JTextArea;

import app.Main;

public class CharacterMenu extends JPanel {

    public CharacterMenu() {
        super();

        JLabel title = new JLabel("Select a character");
        Box hunterBox = Box.createHorizontalBox();
        Box warriorBox = Box.createHorizontalBox();
        Box witcherBox = Box.createHorizontalBox();
        JButton hunter = new JButton(new ImageIcon(Main.hunterImage.getScaledInstance(Main.hunterImage.getWidth() * 4,
                Main.hunterImage.getHeight() * 4, Image.SCALE_DEFAULT)));
        JButton warrior = new JButton(new ImageIcon(Main.warriorImage.getScaledInstance(Main.warriorImage.getWidth() * 4,
                Main.warriorImage.getHeight() * 4, Image.SCALE_DEFAULT)));
        JButton witcher = new JButton(new ImageIcon(Main.witcherImage.getScaledInstance(Main.witcherImage.getWidth() * 4,
                Main.witcherImage.getHeight() * 4, Image.SCALE_DEFAULT)));
        JTextArea hunterStats = new JTextArea("Physical :\t++\nMagic :\t++\nFire :\t\t++");
        JTextArea warriorStats = new JTextArea("Physical :\t++++++\nMagic :\t-\nFire :\t\t-");
        JTextArea witcherStats = new JTextArea("Physical :\t-\nMagic :\t++++++\nFire :\t\t-");

        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createGlue());

        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setFont(Main.font.deriveFont(48f));
        title.setForeground(Color.WHITE);
        add(title);

        add(Box.createRigidArea(new Dimension(0, 64)));

        hunter.setBackground(Color.BLACK);
        hunter.setForeground(Color.WHITE);
        hunter.setFocusable(false);
        hunter.setActionCommand("hunter");
        hunter.addActionListener(Main.getInstance());
        hunterBox.add(hunter);
        hunterBox.add(Box.createRigidArea(new Dimension(32, 0)));
        hunterStats.setFont(Main.font);
        hunterStats.setBackground(Color.BLACK);
        hunterStats.setForeground(Color.WHITE);
        hunterStats.setEditable(false);
        hunterStats.setLineWrap(true);
        hunterStats.setTabSize(4);
        hunterStats.setMaximumSize(new Dimension(336, 96));
        hunterBox.add(hunterStats);
        add(hunterBox);
        
        add(Box.createRigidArea(new Dimension(0, 32)));

        warrior.setBackground(Color.BLACK);
        warrior.setForeground(Color.WHITE);
        warrior.setFocusable(false);
        warrior.setActionCommand("warrior");
        warrior.addActionListener(Main.getInstance());
        warriorBox.add(warrior);
        warriorBox.add(Box.createRigidArea(new Dimension(32, 0)));
        warriorStats.setFont(Main.font);
        warriorStats.setBackground(Color.BLACK);
        warriorStats.setForeground(Color.WHITE);
        warriorStats.setEditable(false);
        warriorStats.setLineWrap(true);
        warriorStats.setTabSize(4);
        warriorStats.setMaximumSize(new Dimension(336, 96));
        warriorBox.add(warriorStats);
        add(warriorBox);

        add(Box.createRigidArea(new Dimension(0, 32)));

        witcher.setBackground(Color.BLACK);
        witcher.setForeground(Color.WHITE);
        witcher.setFocusable(false);
        witcher.setActionCommand("witcher");
        witcher.addActionListener(Main.getInstance());
        witcherBox.add(witcher);
        witcherBox.add(Box.createRigidArea(new Dimension(32, 0)));
        witcherStats.setFont(Main.font);
        witcherStats.setBackground(Color.BLACK);
        witcherStats.setForeground(Color.WHITE);
        witcherStats.setEditable(false);
        witcherStats.setLineWrap(true);
        witcherStats.setTabSize(4);
        witcherStats.setMaximumSize(new Dimension(336, 96));
        witcherBox.add(witcherStats);
        add(witcherBox);

        add(Box.createGlue());
    }
}
