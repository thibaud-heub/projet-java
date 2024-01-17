package sprites;

import java.awt.Image;

public class KnightDeath extends SpriteSheet {
    private static final int WIDTH = 48;
    private static final int HEIGHT = 32;

    private static final int FRAME_COUNT = 6;
    public KnightDeath() {
        super("../../ressources/sprites/Heroes/Knight/Death/Death-Sheet.png");
    }

    public Image getDeathFrame(int frame) {
        return getSprite(frame, 0, WIDTH, HEIGHT);
    }

    public int getFrameCount(){
        return FRAME_COUNT;
    }

    public int getWidth(){
        return WIDTH;
    }
    
    public int getHeight(){
        return HEIGHT;
    }
}
