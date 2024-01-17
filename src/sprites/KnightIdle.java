package sprites;

import java.awt.Image;

public class KnightIdle extends SpriteSheet {
    
    private static final int WIDTH = 32;
    private static final int HEIGHT = 32;

    private static final int FRAME_COUNT = 4;
    public KnightIdle() {
        super("../../ressources/sprites/Heroes/Knight/Idle/Idle-Sheet.png");
    }

    public Image getIdleFrame(int frame) {
        return getSprite(frame, 0, WIDTH, HEIGHT);
    }

    public int getFrameCount() {
        return FRAME_COUNT;
    }

    public int getWidth(){
        return WIDTH;
    }
    
    public int getHeight(){
        return HEIGHT;
    }
}
