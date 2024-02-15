    package characters.Drawing;


    import java.awt.Graphics;
    import java.awt.Image;
    import java.awt.image.ImageObserver;
    import java.awt.image.BufferedImage;
    import characters.abstractFactory.monsterType.Monster;

    public class DrawMonsters {
        private Monster currentMonster;
        private int xPos;
        private int yPos;
        private int spriteIndex;
        private boolean runningLeft;
        private ImageObserver observer;

        /**
         * Constructeur de la classe DrawMonsters
         * @param currentMonster : Le monstre à dessiner
         * @param xPos : La position en x du monstre
         * @param yPos : La position en y du monstre
         * @param spriteIndex : L'index du sprite à dessiner
         * @param runningLeft : Booléen qui indique si le monstre court vers la gauche
         * @param observer : L'observer
         */
        public DrawMonsters(Monster currentMonster, int xPos, int yPos, int spriteIndex, boolean runningLeft, ImageObserver observer) {
            this.currentMonster = currentMonster;
            this.xPos = xPos;
            this.yPos = yPos;
            this.spriteIndex = spriteIndex;
            this.runningLeft = runningLeft;
            this.observer = observer;
        }

        /**
         * Méthode qui dessine le monstre
         * @param g : Le graphique
         */
        public void draw(Graphics g) {

            // Récupère l'état du monstre et les sprites du monstre
            Monster.State currentState = currentMonster.getState();
            BufferedImage[] sprites;

            // Définit les sprites en fonction de l'état du monstre
            switch (currentState) {
                case WALK:
                    default:
                    sprites = currentMonster.getWalkSprites();
                    break;
                case DEATH:
                    sprites = currentMonster.getDeathSprites();
                    break;
                case ATTACK:
                    sprites = currentMonster.getAttackSprites();
                    break;
                case IDLE:
                    sprites = currentMonster.getIdleSprites();
                    break;
            }

            if(currentState == Monster.State.DEATH){
                System.out.println("spriteIndex : " + spriteIndex);
            }
            int adjustedSpriteIndex = spriteIndex % sprites.length;
            Image sprite = sprites[adjustedSpriteIndex];

            int drawX = xPos;
            int drawY = yPos;
            int spriteWidth = sprite.getWidth(null);
            int spriteHeight = sprite.getHeight(null);

            // Dessine le monstre
            if (runningLeft) {
                // inversion de l'image du sprite pour courir vers la gauche
                g.drawImage(sprite, drawX + spriteWidth, drawY, -spriteWidth, spriteHeight, observer);
            } else {
                g.drawImage(sprite, drawX, drawY, spriteWidth, spriteHeight, observer);
            }
        }
    }
