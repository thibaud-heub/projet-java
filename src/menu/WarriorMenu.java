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

public class WarriorMenu extends JPanel {
    public WarriorMenu() {
        super();

        JLabel title = new JLabel("Select a weapon");
        Box swordBox = Box.createHorizontalBox();
        Box greatSwordBox = Box.createHorizontalBox();
        JButton sword = new JButton(new ImageIcon(Main.swordImage.getScaledInstance(Main.swordImage.getWidth() * 4,
                Main.swordImage.getHeight() * 4, Image.SCALE_DEFAULT)));
        JButton greatSword = new JButton(
                new ImageIcon(Main.greatSwordImage.getScaledInstance(Main.greatSwordImage.getWidth() * 4,
                        Main.greatSwordImage.getHeight() * 4, Image.SCALE_DEFAULT)));
        JTextArea swordStats = new JTextArea("Damage :\t\t+++\nAttack speed :\t++");
        JTextArea greatSwordStats = new JTextArea("Damage :\t\t++++\nAttack speed :\t+");

        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createGlue());

        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setFont(Main.font.deriveFont(48f));
        title.setForeground(Color.WHITE);
        add(title);

        add(Box.createRigidArea(new Dimension(0, 64)));

        sword.setBackground(Color.BLACK);
        sword.setForeground(Color.WHITE);
        sword.setFocusable(false);
        sword.setActionCommand("room");
        sword.addActionListener(Main.getInstance());
        swordBox.add(sword);
        swordBox.add(Box.createRigidArea(new Dimension(32, 0)));
        swordStats.setFont(Main.font);
        swordStats.setBackground(Color.BLACK);
        swordStats.setForeground(Color.WHITE);
        swordStats.setEditable(false);
        swordStats.setLineWrap(true);
        swordStats.setTabSize(4);
        swordStats.setMaximumSize(new Dimension(336, 48));
        swordBox.add(swordStats);
        add(swordBox);
        
        add(Box.createRigidArea(new Dimension(0, 32)));

        greatSword.setBackground(Color.BLACK);
        greatSword.setForeground(Color.WHITE);
        greatSword.setFocusable(false);
        greatSword.setActionCommand("room");
        greatSword.addActionListener(Main.getInstance());
        greatSwordBox.add(greatSword);
        greatSwordBox.add(Box.createRigidArea(new Dimension(32, 0)));
        greatSwordStats.setFont(Main.font);
        greatSwordStats.setBackground(Color.BLACK);
        greatSwordStats.setForeground(Color.WHITE);
        greatSwordStats.setEditable(false);
        greatSwordStats.setLineWrap(true);
        greatSwordStats.setTabSize(4);
        greatSwordStats.setMaximumSize(new Dimension(336, 48));
        greatSwordBox.add(greatSwordStats);
        add(greatSwordBox);

        add(Box.createGlue());
    }
}
