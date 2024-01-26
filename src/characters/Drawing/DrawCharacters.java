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

    /*
     * Constructeur de la classe DrawCharacters
     * @param currentCharacter : Le personnage à dessiner
     * @param xPos : La position en x du personnage
     * @param yPos : La position en y du personnage
     * @param spriteIndex : L'index du sprite à dessiner
     * @param runningLeft : Booléen qui indique si le personnage court vers la gauche
     * @param observer : L'observer
     */
    public DrawCharacters(character currentCharacter, int xPos, int yPos, int spriteIndex, boolean runningLeft, ImageObserver observer) {
        this.currentCharacter = currentCharacter;
        this.xPos = xPos;
        this.yPos = yPos;
        this.spriteIndex = spriteIndex;
        this.runningLeft = runningLeft;
        this.observer = observer;
    }

    /**
     * Méthode qui dessine le personnage
     * @param g : Le graphique
     */
    public void draw(Graphics g) {

        // Récupère l'état du personnage et les sprites du personnage
        character.State currentState = currentCharacter.getState();
        BufferedImage[] sprites;

        // Définit les sprites en fonction de l'état du personnage
        switch (currentState) {
            case RUNNING:
                sprites = currentCharacter.getRunSprites();
                break;
            case IDLE:
            default:
                sprites = currentCharacter.getIdleSprites();
                break;
            case DEATH:
                sprites = currentCharacter.getDeathSprites();
                break;
        }

        Image sprite = sprites[spriteIndex];

        // Dessine le personnage
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
