
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
            InputStream is = getClass().getResourceAsStream("../ressources/keyboard/clavier.png");
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
            InputStream is = getClass().getResourceAsStream("../ressources/keyboard/toucheA.png");
            toucheA = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            InputStream is = getClass().getResourceAsStream("../ressources/keyboard/escape.png");
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
            g.drawImage(toucheHaut, 5, 15, this); 
        }
        if (toucheBas != null) {
            g.drawImage(toucheBas, 5, 15, this); 
        }
        if (toucheGauche != null) {
            g.drawImage(toucheGauche, 5, 15, this); 
        }
        if (toucheDroite != null) {
            g.drawImage(toucheDroite, 5, 15, this); 
        }
        if (toucheA != null) {
            g.drawImage(toucheA, 55, 15, this); 
        }
        if (escape != null) {
            g.drawImage(escape, 105, 15, this); 
        }

        g.drawString("Avancer, Reculer, Aller à droite, Aller à gauche", 5, 15);
    }
}
