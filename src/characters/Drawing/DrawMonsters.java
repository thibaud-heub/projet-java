    package characters.Drawing;


    import java.awt.Graphics;
    import java.awt.Image;
    import java.awt.image.ImageObserver;
    import java.awt.image.BufferedImage;
    import characters.character;
    import characters.abstractFactory.monsterType.Monster;

    public class DrawMonsters {
        private Monster currentMonster;
        private int xPos;
        private int yPos;
        private int spriteIndex;
        private boolean runningLeft;
        private ImageObserver observer;

        // Constructeur
        public DrawMonsters(Monster currentMonster, int xPos, int yPos, int spriteIndex, boolean runningLeft, ImageObserver observer) {
            this.currentMonster = currentMonster;
            this.xPos = xPos;
            this.yPos = yPos;
            this.spriteIndex = spriteIndex;
            this.runningLeft = runningLeft;
            this.observer = observer;
        }

        public void draw(Graphics g) {

            Monster.State currentState = currentMonster.getState();
            BufferedImage[] sprites;

            switch (currentState) {
                case WALK:
                    sprites = currentMonster.getWalkSprites();
                    break;
                case IDLE:
                default:
                    sprites = currentMonster.getIdleSprites();
                    break;
                case DEATH:
                    sprites = currentMonster.getDeathSprites();
                    break;
            }

            Image sprite = sprites[spriteIndex];

            int drawX = xPos;
            int drawY = yPos;
            
            

            int spriteWidth = sprite.getWidth(null);
            int spriteHeight = sprite.getHeight(null);


            

            if (runningLeft) {
                // inversion de l'image du sprite pour courir vers la gauche
                g.drawImage(sprite, drawX + spriteWidth, drawY, -spriteWidth, spriteHeight, observer);
            } else {
                g.drawImage(sprite, drawX, drawY, spriteWidth, spriteHeight, observer);
            }
        }
    }
