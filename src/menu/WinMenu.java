package menu;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.Main;

public class WinMenu extends JPanel {

    public WinMenu() {
        super();

        JLabel title = new JLabel("You win !");
        JButton quit = new JButton("Quit");
        Dimension buttonSize = new Dimension(192, 96);

        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createGlue());

        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setFont(Main.font.deriveFont(48f));
        title.setForeground(Color.WHITE);
        add(title);

        add(Box.createRigidArea(new Dimension(0, 64)));

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
