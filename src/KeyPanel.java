
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.io.InputStream;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.InputStream;



public class KeyPanel extends JPanel {
    private BufferedImage toucheHaut;
    private BufferedImage toucheBas;
    private BufferedImage toucheDroite;
    private BufferedImage toucheGauche;
    private BufferedImage toucheA;
    private BufferedImage escape;
    

    public KeyPanel() {
        setPreferredSize(new Dimension(800, 25)); 
    }


    private void loadImage() {
        try {
            InputStream is = getClass().getResourceAsStream("../ressources/keyboard/toucheHaut.png");
            toucheHaut = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            InputStream is = getClass().getResourceAsStream("../ressources/keyboard/toucheBas.png");
            toucheBas = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            InputStream is = getClass().getResourceAsStream("../ressources/keyboard/toucheDroite.png");
            toucheDroite = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            InputStream is = getClass().getResourceAsStream("../ressources/keyboard/toucheGauche.png");
            toucheGauche = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            InputStream is = getClass().getResourceAsStream("../ressources/keyboard/toucheGauche.png");
            toucheA = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            InputStream is = getClass().getResourceAsStream("../ressources/keyboard/toucheGauche.png");
            escape = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        loadImage();
        super.paintComponent(g);
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
        g.drawString("Aller à gauche", 333, 17);

        if (toucheDroite != null) {
            g.drawImage(toucheDroite, 442, 5, this); 
        }
        g.drawString("Aller à droite", 463, 17);

        if (toucheA != null) {
            g.drawImage(toucheA, 557, 5, this); 
        }
        g.drawString("Attaquer", 578, 17);

        if (escape != null) {
            g.drawImage(escape, 650, 5, this); 
        }
        g.drawString("Quitter", 670, 17);

        //g.drawString("Avancer, Reculer, Aller à droite, Aller à gauche", 5, 15);
    }
}
