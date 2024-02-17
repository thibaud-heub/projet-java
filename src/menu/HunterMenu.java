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

public class HunterMenu extends JPanel {
    public HunterMenu() {
        super();

        JLabel title = new JLabel("Select a weapon");
        Box knifeBox = Box.createHorizontalBox();
        Box katanaBox = Box.createHorizontalBox();
        JButton knife = new JButton(new ImageIcon(Main.knifeImage.getScaledInstance(Main.knifeImage.getWidth() * 4,
                Main.knifeImage.getHeight() * 4, Image.SCALE_DEFAULT)));
        JButton katana = new JButton(new ImageIcon(Main.katanaImage.getScaledInstance(Main.katanaImage.getWidth() * 4,
                Main.katanaImage.getHeight() * 4, Image.SCALE_DEFAULT)));
        JTextArea knifeStats = new JTextArea("Damage :\t\t+\nAttack speed :\t+++++");
        JTextArea katanaStats = new JTextArea("Damage :\t\t++\nAttack speed :\t+++");

        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createGlue());

        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setFont(Main.font.deriveFont(48f));
        title.setForeground(Color.WHITE);
        add(title);

        add(Box.createRigidArea(new Dimension(0, 64)));

        knife.setBackground(Color.BLACK);
        knife.setForeground(Color.WHITE);
        knife.setFocusable(false);
        knife.setActionCommand("knife");
        knife.addActionListener(Main.getInstance());
        knifeBox.add(knife);
        knifeBox.add(Box.createRigidArea(new Dimension(32, 0)));
        knifeStats.setFont(Main.font);
        knifeStats.setBackground(Color.BLACK);
        knifeStats.setForeground(Color.WHITE);
        knifeStats.setEditable(false);
        knifeStats.setLineWrap(true);
        knifeStats.setTabSize(4);
        knifeStats.setMaximumSize(new Dimension(336, 48));
        knifeBox.add(knifeStats);
        add(knifeBox);

        add(Box.createRigidArea(new Dimension(0, 32)));

        katana.setBackground(Color.BLACK);
        katana.setForeground(Color.WHITE);
        katana.setFocusable(false);
        katana.setActionCommand("katana");
        katana.addActionListener(Main.getInstance());
        katanaBox.add(katana);
        katanaBox.add(Box.createRigidArea(new Dimension(32, 0)));
        katanaStats.setFont(Main.font);
        katanaStats.setBackground(Color.BLACK);
        katanaStats.setForeground(Color.WHITE);
        katanaStats.setEditable(false);
        katanaStats.setLineWrap(true);
        katanaStats.setTabSize(4);
        katanaStats.setMaximumSize(new Dimension(336, 48));
        katanaBox.add(katanaStats);
        add(katanaBox);

        add(Box.createGlue());
    }
}
