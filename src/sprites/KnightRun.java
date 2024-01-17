package sprites;

import java.awt.Image;

public class KnightRun extends SpriteSheet {

    private static final int WIDTH = 64;
    private static final int HEIGHT = 64;

    private static final int FRAME_COUNT = 6;
    public KnightRun() {
        super("../../ressources/sprites/Heroes/Knight/Run/Run-Sheet.png");
    }

    public Image getRunFrame(int frame) {
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
