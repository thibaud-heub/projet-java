    import javax.swing.JPanel;
    import java.awt.Graphics;
    import java.awt.Dimension;

    public class HUDPanel extends JPanel {
        private double health;
        private double mana;
        private double XP;

        public HUDPanel() {
            setPreferredSize(new Dimension(800, 100)); 
        }

        public void updateHUD(double health, double mana, double XP) {
            this.health = (int) health;
            this.mana = (int) mana;
            this.XP = XP;
            this.repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // g.setColor(Color.RED);
            // g.fillRect(0, 0, getWidth(), getHeight());
            g.drawString("Santé: " + health, 5, 10);
            g.drawString("Mana: " + mana, 5, 25);
            g.drawString("XP: " + XP, 5, 40);
        }
    }
