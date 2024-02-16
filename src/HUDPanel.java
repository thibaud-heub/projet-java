    import javax.imageio.ImageIO;
    import javax.swing.JPanel;
    import java.awt.Graphics;
    import java.awt.Dimension;
    import java.awt.Color;
    import java.awt.image.BufferedImage;
    import java.io.InputStream;
    import java.awt.Font;
    import java.awt.GraphicsEnvironment;

    public class HUDPanel extends JPanel {
        private double health;
        private double mana;
        private int XP;
        private double littleXP;
        private double Rfire;
        private double Rphysic;
        private double Rmagic;
        private double Dfire;
        private double Dphysic;
        private double Dmagic;
        private BufferedImage heart;
        private BufferedImage lightning;
        private BufferedImage fire;
        private BufferedImage magic;
        private BufferedImage physic;
        private Font customFont;


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
            InputStream is = getClass().getResourceAsStream("/ressources/keyboard/heart.png");
            heart = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            InputStream is = getClass().getResourceAsStream("/ressources/keyboard/lightning.png");
            lightning = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            InputStream is = getClass().getResourceAsStream("/ressources/keyboard/fire.png");
            fire = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            InputStream is = getClass().getResourceAsStream("/ressources/keyboard/magic.png");
            magic = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            InputStream is = getClass().getResourceAsStream("/ressources/keyboard/physic.png");
            physic = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public HUDPanel() {
            setPreferredSize(new Dimension(200, 600)); 
        }

        public void updateHUD(double health, double mana, double XP, double Rfire, double Rphysic, double Rmagic, double Dfire, double Dphysic, double Dmagic, double littleXP) {
            this.health = health;
            this.mana = mana;
            this.XP = (int) XP;
            this.littleXP = littleXP;
            this.Rfire = Rfire;
            this.Rphysic = Rphysic;
            this.Rmagic = Rmagic;
            this.Dfire = Dfire;
            this.Dphysic = Dphysic;
            this.Dmagic = Dmagic;
            this.repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Color darkGreen = new Color(35, 194, 7);
            Color darkRed = new Color(128, 15, 15);
            loadImage();
            loadFont();
            super.paintComponent(g);

            // Mettre la police
            if (customFont != null) {
                g.setFont(customFont);
            }

            // Dessiner la barre de vie
            int widthHealthAndMana = 150; // Largeur de la barre de vie
            int heightHealthAndMana = 20; // Hauteur de la barre de vie
            int healthX = 5; // Position X de la barre de vie
            int healthY = 10; // Position Y de la barre de vie
            int manaX = 5;
            int manaY = 40;
            int xpX = 5;
            int xpY = 80;
            int heightXP = 10;
            int width = 150;
            int height = 10;
            int RphysicX = 5;
            int RphysicY = 400;
            int RmagicX = 5;
            int RmagicY = 430;
            int RfireX = 5;
            int RfireY = 460;
            int DphysicX = 5;
            int DphysicY = 410;
            int DmagicX = 5;
            int DmagicY = 440;
            int DfireX = 5;
            int DfireY = 470;


            double healthPercentage = health / 100;
            int currentwidth = (int) (widthHealthAndMana * healthPercentage);
            double manaPercentage = mana / 100;
            int currentManaWidth = (int) (widthHealthAndMana * manaPercentage);
            double RfirePercentage = Rfire / 20;
            double RphysicPercentage = Rphysic / 20;
            double RmagicPercentage = Rmagic / 20;
            double DfirePercentage = Dfire / 20;
            double DphysicPercentage = Dphysic / 40;
            double DmagicPercentage = Dmagic / 20;
            double XPPercentage = (littleXP) / 100;
            int currentRfire = (int) (width * RfirePercentage);
            int currentRphysic = (int) (width * RphysicPercentage);
            int currentRmagic = (int) (width * RmagicPercentage);
            int currentDfire = (int) (width * DfirePercentage);
            int currentDphysic = (int) (width * DphysicPercentage);
            int currentDmagic = (int) (width * DmagicPercentage);
            int currentXP = (int) (width * XPPercentage);

            // XP en jaune
            g.drawString("Niveau " + XP, xpX, xpY - 5);
            g.setColor(Color.BLACK);
            g.fillRect(xpX, xpY, width, heightXP);
            g.setColor(Color.YELLOW);
            g.fillRect(xpX, xpY, currentXP, heightXP);


            // Résistance en gris, dégats en rouge
            g.setColor(Color.GRAY);
            g.fillRect(RfireX, RfireY, currentRfire, height);
            g.fillRect(RphysicX, RphysicY, currentRphysic, height);
            g.fillRect(RmagicX, RmagicY, currentRmagic, height);
            g.setColor(Color.RED);
            g.fillRect(DfireX, DfireY, currentDfire, height);
            g.fillRect(DphysicX, DphysicY, currentDphysic, height);
            g.fillRect(DmagicX, DmagicY, currentDmagic, height);   

            g.setColor(Color.BLACK);
            for (int i = 0; i < 2; i++) {
                g.drawRect(RfireX - i, RfireY - i, width + (2 * i), height + (2 * i));
                g.drawRect(RphysicX - i, RphysicY - i, width + (2 * i), height + (2 * i));
                g.drawRect(RmagicX - i, RmagicY - i, width + (2 * i), height + (2 * i));
                g.drawRect(DfireX - i, DfireY - i, width + (2 * i), height + (2 * i));
                g.drawRect(DphysicX - i, DphysicY - i, width + (2 * i), height + (2 * i));
                g.drawRect(DmagicX - i, DmagicY - i, width + (2 * i), height + (2 * i));
            }

    
            // Dessiner le fond de la barre de vie
            g.setColor(Color.RED);
            g.fillRect(healthX, healthY, width, heightHealthAndMana);

            // Dessiner la barre de vie actuelle
            if(health > 75){
                g.setColor(darkGreen);
                g.fillRect(healthX, healthY, currentwidth, heightHealthAndMana);
            } else if(health > 50){
                g.setColor(Color.GREEN);
                g.fillRect(healthX, healthY, currentwidth, heightHealthAndMana);
            } else if (health > 40){
                g.setColor(Color.YELLOW);
                g.fillRect(healthX, healthY, currentwidth, heightHealthAndMana);
            }else if(health > 25){
                g.setColor(Color.ORANGE);
                g.fillRect(healthX, healthY, currentwidth, heightHealthAndMana);
            }else {
                g.setColor(darkRed);
                g.fillRect(healthX, healthY, currentwidth, heightHealthAndMana);
            }
    
            g.setColor(Color.BLUE);
            g.fillRect(manaX, manaY, width, heightHealthAndMana);

            g.setColor(Color.CYAN);
            g.fillRect(manaX, manaY, currentManaWidth, heightHealthAndMana);

            if (heart != null) {
                g.drawImage(heart, 0, 6, this); 
            }
            if (lightning != null) {
                g.drawImage(lightning, 0, 40, this); 
            }
            if (fire != null) {
                g.drawImage(fire, 0, 455, this); 
            }
            if (magic != null) {
                g.drawImage(magic, 0, 425, this); 
            }
            if (physic != null) {
                g.drawImage(physic, 0, 395, this); 
            }


            g.setColor(Color.BLACK);
        }
    }
