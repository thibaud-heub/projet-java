    import javax.swing.JPanel;
    import java.awt.Graphics;
    import java.awt.Dimension;

    public class HUDPanel extends JPanel {
        private int health;
        private int mana;
        private int XP;
        private int Rfire;
        private int Rphysic;
        private int Rmagic;
        private int Dfire;
        private int Dphysic;
        private int Dmagic;
        private int speed;


        public HUDPanel() {
            setPreferredSize(new Dimension(200, 600)); 
        }

        public void updateHUD(double health, double mana, double XP, double Rfire, double Rphysic, double Rmagic, double Dfire, double Dphysic, double Dmagic, int speed) {
            this.health = (int) health;
            this.mana = (int) mana;
            this.XP = (int) XP;
            this.Rfire = (int) Rfire;
            this.Rphysic = (int) Rphysic;
            this.Rmagic = (int) Rmagic;
            this.Dfire = (int) Dfire;
            this.Dphysic = (int) Dphysic;
            this.Dmagic = (int) Dmagic;
            this.speed = speed;


            this.repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString("Santé: " + health, 5, 10);
            g.drawString("Mana: " + mana, 5, 25);
            g.drawString("XP: " + XP, 5, 40);
            g.drawString("Résistance au feu: " + Rfire, 5, 55);
            g.drawString("Résistance physique: " + Rphysic, 5, 70);
            g.drawString("Résistance magique: " + Rmagic, 5, 85);
            g.drawString("Dégâts de feu: " + Dfire, 5, 100);
            g.drawString("Dégâts physiques: " + Dphysic, 5, 115);
            g.drawString("Dégâts magiques: " + Dmagic, 5, 130);
            g.drawString("Vitesse: " + speed, 5, 145);
        }
    }
