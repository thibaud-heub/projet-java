package sprites;

import java.awt.Image;

public class KnightDeath extends SpriteSheet {

    private static final int FRAME_COUNT = 6;
    public KnightDeath() {
        super("../../ressources/sprites/Heroes/Knight/Death/Death-Sheet.png");
    }

    public Image getDeathFrame(int frame) {
        int width = 48; 
        int height = 32; 
        return getSprite(frame, 0, width, height);
    }

    public int getFrameCount(){
        return FRAME_COUNT;
    }
}
