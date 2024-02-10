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

public class WitcherMenu extends JPanel {
    public WitcherMenu() {
        super();

        JLabel title = new JLabel("Select a weapon");
        Box weaponBox = Box.createHorizontalBox();
        JButton staff = new JButton(new ImageIcon(Main.staffImage.getScaledInstance(Main.staffImage.getWidth() * 4,
                Main.staffImage.getHeight() * 4, Image.SCALE_DEFAULT)));
        JButton greatStaff = new JButton(
                new ImageIcon(Main.greatStaffImage.getScaledInstance(Main.greatStaffImage.getWidth() * 4,
                        Main.greatStaffImage.getHeight() * 4, Image.SCALE_DEFAULT)));

        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createGlue());

        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setFont(Main.font.deriveFont(48f));
        title.setForeground(Color.WHITE);
        add(title);

        add(Box.createRigidArea(new Dimension(0, 64)));

        staff.setBackground(Color.BLACK);
        staff.setFocusable(false);
        staff.setActionCommand("room");
        staff.addActionListener(Main.getInstance());
        weaponBox.add(staff);
        weaponBox.add(Box.createRigidArea(new Dimension(32, 0)));
        greatStaff.setBackground(Color.BLACK);
        greatStaff.setFocusable(false);
        greatStaff.setActionCommand("room");
        greatStaff.addActionListener(Main.getInstance());
        weaponBox.add(greatStaff);
        weaponBox.add(Box.createRigidArea(new Dimension(32, 0)));
        add(weaponBox);

        add(Box.createGlue());
    }
}
