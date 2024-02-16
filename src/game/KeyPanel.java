package game;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.io.InputStream;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.GraphicsEnvironment;



public class KeyPanel extends JPanel {
    private BufferedImage toucheHaut;
    private BufferedImage toucheBas;
    private BufferedImage toucheDroite;
    private BufferedImage toucheGauche;
    private BufferedImage toucheA;
    private BufferedImage escape;
    private Font customFont;
    
    

    public KeyPanel() {
        setPreferredSize(new Dimension(800, 25)); 
    }

    private void loadFont(){
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/ressources/font/04B_03__.TTF"))
                             .deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();
            customFont = new Font("SansSerif", Font.PLAIN, 12); 
        }
    }

    private void loadImage() {
        try {
            InputStream is = getClass().getResourceAsStream("/ressources/keyboard/toucheHautWhite.png");
            toucheHaut = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            InputStream is = getClass().getResourceAsStream("/ressources/keyboard/toucheBasWhite.png");
            toucheBas = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            InputStream is = getClass().getResourceAsStream("/ressources/keyboard/toucheDroiteWhite.png");
            toucheDroite = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            InputStream is = getClass().getResourceAsStream("/ressources/keyboard/toucheGaucheWhite.png");
            toucheGauche = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            InputStream is = getClass().getResourceAsStream("/ressources/keyboard/toucheAWhite.png");
            toucheA = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            InputStream is = getClass().getResourceAsStream("/ressources/keyboard/escapeWhite.png");
            escape = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        loadImage();
        loadFont();
        super.paintComponent(g);

        setBackground(Color.BLACK);

        // Mettre la police
        if (customFont != null) {
            g.setFont(customFont);
        }

        g.setColor(Color.WHITE);
        // Mettre les images
        if (toucheHaut != null) {
            g.drawImage(toucheHaut, 72, 5, this); 
        }
        g.drawString("Aller en haut", 93, 17);

        if (toucheBas != null) {
            g.drawImage(toucheBas, 193, 5, this); 
        }
        g.drawString("Aller en bas", 213, 17);

        if (toucheGauche != null) {
            g.drawImage(toucheGauche, 312, 5, this); 
        }
        g.drawString("Aller a gauche", 333, 17);

        if (toucheDroite != null) {
            g.drawImage(toucheDroite, 442, 5, this); 
        }
        g.drawString("Aller a droite", 463, 17);

        if (toucheA != null) {
            g.drawImage(toucheA, 557, 5, this); 
        }
        g.drawString("Attaquer", 578, 17);

        if (escape != null) {
            g.drawImage(escape, 650, 5, this); 
        }
        g.drawString("Quitter", 670, 17);

    }
}
