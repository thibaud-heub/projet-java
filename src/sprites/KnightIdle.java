package sprites;

import java.awt.Image;

public class KnightIdle extends SpriteSheet {

    private static final int FRAME_COUNT = 4;
    public KnightIdle() {
        super("../../ressources/sprites/Heroes/Knight/Idle/Idle-Sheet.png");
    }

    public Image getIdleFrame(int frame) {
        int width = 32; 
        int height = 32; 
        return getSprite(frame, 0, width, height);
    }

    public int getFrameCount() {
        return FRAME_COUNT;
    }
}
