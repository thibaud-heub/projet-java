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

public class WitcherMenu extends JPanel {
    public WitcherMenu() {
        super();

        JLabel title = new JLabel("Select a weapon");
        Box staffBox = Box.createHorizontalBox();
        Box greatStaffBox = Box.createHorizontalBox();
        JButton staff = new JButton(new ImageIcon(Main.staffImage.getScaledInstance(Main.staffImage.getWidth() * 4,
                Main.staffImage.getHeight() * 4, Image.SCALE_DEFAULT)));
        JButton greatStaff = new JButton(
                new ImageIcon(Main.greatStaffImage.getScaledInstance(Main.greatStaffImage.getWidth() * 4,
                        Main.greatStaffImage.getHeight() * 4, Image.SCALE_DEFAULT)));
        JTextArea staffStats = new JTextArea("Damage :\t\t+++\nAttack speed :\t++");
        JTextArea greatStaffStats = new JTextArea("Damage :\t\t++++\nAttack speed :\t+");

        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createGlue());

        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setFont(Main.font.deriveFont(48f));
        title.setForeground(Color.WHITE);
        add(title);

        add(Box.createRigidArea(new Dimension(0, 64)));

        staff.setBackground(Color.BLACK);
        staff.setForeground(Color.WHITE);
        staff.setFocusable(false);
        staff.setActionCommand("room");
        staff.addActionListener(Main.getInstance());
        staffBox.add(staff);
        staffBox.add(Box.createRigidArea(new Dimension(32, 0)));
        staffStats.setFont(Main.font);
        staffStats.setBackground(Color.BLACK);
        staffStats.setForeground(Color.WHITE);
        staffStats.setEditable(false);
        staffStats.setLineWrap(true);
        staffStats.setTabSize(4);
        staffStats.setMaximumSize(new Dimension(336, 48));
        staffBox.add(staffStats);
        add(staffBox);
        
        add(Box.createRigidArea(new Dimension(0, 32)));

        greatStaff.setBackground(Color.BLACK);
        greatStaff.setForeground(Color.WHITE);
        greatStaff.setFocusable(false);
        greatStaff.setActionCommand("room");
        greatStaff.addActionListener(Main.getInstance());
        greatStaffBox.add(greatStaff);
        greatStaffBox.add(Box.createRigidArea(new Dimension(32, 0)));
        greatStaffStats.setFont(Main.font);
        greatStaffStats.setBackground(Color.BLACK);
        greatStaffStats.setForeground(Color.WHITE);
        greatStaffStats.setEditable(false);
        greatStaffStats.setLineWrap(true);
        greatStaffStats.setTabSize(4);
        greatStaffStats.setMaximumSize(new Dimension(336, 48));
        greatStaffBox.add(greatStaffStats);
        add(greatStaffBox);

        add(Box.createGlue());
    }
}
