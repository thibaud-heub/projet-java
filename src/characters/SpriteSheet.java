package characters;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class SpriteSheet {
    private BufferedImage sheet;
    private int frameWidth;
    private int frameHeight;

    public SpriteSheet(String path, int frameWidth, int frameHeight) {
        try {
            this.sheet = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
    }

    public BufferedImage getSprite(int col, int row) {
        int x = col * frameWidth;
        int y = row * frameHeight;
        return sheet.getSubimage(x, y, frameWidth, frameHeight);
    }
}
