package tile;

import java.awt.Graphics;

import javax.imageio.ImageIO;

import game.GamePanel;

public class TileManager {
    private GamePanel gp;
    private Tile[] tiles;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        this.tiles = new Tile[11];
        getTileImage();
    }

    public void getTileImage() {
        try {
            tiles[0] = new Tile(ImageIO.read(getClass().getResourceAsStream("/ressources/dungeon/floor.png")), false);
            for (int i = 1; i < 10; i++) {
                tiles[i] = new Tile(ImageIO.read(getClass().getResourceAsStream("/ressources/dungeon/wall_" + i + ".png")), false);
            }
            tiles[10] = new Tile(ImageIO.read(getClass().getResourceAsStream("/ressources/dungeon/floor_ladder.png")), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        g.drawImage(tiles[0].getImage(), 0, 0, 32, 32, null);
        g.drawImage(tiles[1].getImage(), 32, 0, 32, 32, null);
        g.drawImage(tiles[10].getImage(), 64, 0, 32, 32, null);
    }

    public GamePanel getGp() {
        return gp;
    }

    public void setGp(GamePanel gp) {
        this.gp = gp;
    }

    public Tile[] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[] tiles) {
        this.tiles = tiles;
    }
}
