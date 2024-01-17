package sprites;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class SpriteSheet {
    private BufferedImage sheet;

    public SpriteSheet(String path) {
        try {
            sheet = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getSprite(int col, int row, int width, int height) {
        int x = col * (width);
        int y = row * (height);
        return sheet.getSubimage(x, y, width, height);
    }
}
