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

public class WarriorMenu extends JPanel {
    public WarriorMenu() {
        super();

        JLabel title = new JLabel("Select a weapon");
        Box weaponBox = Box.createHorizontalBox();
        JButton sword = new JButton(new ImageIcon(Main.swordImage.getScaledInstance(Main.swordImage.getWidth() * 4,
                Main.swordImage.getHeight() * 4, Image.SCALE_DEFAULT)));
        JButton greatSword = new JButton(
                new ImageIcon(Main.greatSwordImage.getScaledInstance(Main.greatSwordImage.getWidth() * 4,
                        Main.greatSwordImage.getHeight() * 4, Image.SCALE_DEFAULT)));

        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createGlue());

        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setFont(Main.font.deriveFont(48f));
        title.setForeground(Color.WHITE);
        add(title);

        add(Box.createRigidArea(new Dimension(0, 64)));

        sword.setBackground(Color.BLACK);
        sword.setFocusable(false);
        sword.setActionCommand("room");
        sword.addActionListener(Main.getInstance());
        weaponBox.add(sword);
        weaponBox.add(Box.createRigidArea(new Dimension(32, 0)));
        greatSword.setBackground(Color.BLACK);
        greatSword.setFocusable(false);
        greatSword.setActionCommand("room");
        greatSword.addActionListener(Main.getInstance());
        weaponBox.add(greatSword);
        weaponBox.add(Box.createRigidArea(new Dimension(32, 0)));
        add(weaponBox);

        add(Box.createGlue());
    }
}
