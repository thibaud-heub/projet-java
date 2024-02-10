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

public class HunterMenu extends JPanel {
    public HunterMenu() {
        super();

        JLabel title = new JLabel("Select a weapon");
        Box weaponBox = Box.createHorizontalBox();
        JButton knife = new JButton(new ImageIcon(Main.knifeImage.getScaledInstance(Main.knifeImage.getWidth() * 4,
                Main.knifeImage.getHeight() * 4, Image.SCALE_DEFAULT)));
        JButton katana = new JButton(new ImageIcon(Main.katanaImage.getScaledInstance(Main.katanaImage.getWidth() * 4,
                Main.katanaImage.getHeight() * 4, Image.SCALE_DEFAULT)));

        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createGlue());

        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setFont(Main.font.deriveFont(48f));
        title.setForeground(Color.WHITE);
        add(title);

        add(Box.createRigidArea(new Dimension(0, 64)));

        knife.setBackground(Color.BLACK);
        knife.setFocusable(false);
        knife.setActionCommand("room");
        knife.addActionListener(Main.getInstance());
        weaponBox.add(knife);
        weaponBox.add(Box.createRigidArea(new Dimension(32, 0)));
        katana.setBackground(Color.BLACK);
        katana.setFocusable(false);
        katana.setActionCommand("room");
        katana.addActionListener(Main.getInstance());
        weaponBox.add(katana);
        weaponBox.add(Box.createRigidArea(new Dimension(32, 0)));
        add(weaponBox);

        add(Box.createGlue());
    }
}
