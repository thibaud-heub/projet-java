package characters.Drawing;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.BufferedImage;
import characters.character;

public class DrawCharacters {
    private character currentCharacter;
    private int xPos;
    private int yPos;
    private int spriteIndex;
    private boolean runningLeft;
    private ImageObserver observer;

    // Constructeur
    public DrawCharacters(character currentCharacter, int xPos, int yPos, int spriteIndex, boolean runningLeft, ImageObserver observer) {
        this.currentCharacter = currentCharacter;
        this.xPos = xPos;
        this.yPos = yPos;
        this.spriteIndex = spriteIndex;
        this.runningLeft = runningLeft;
        this.observer = observer;
    }

    public void draw(Graphics g) {

        character.State currentState = currentCharacter.getState();
        BufferedImage[] sprites;

        switch (currentState) {
            case RUNNING:
                sprites = currentCharacter.getRunSprites();
                break;
            case IDLE:
            default:
                sprites = currentCharacter.getIdleSprites();
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
