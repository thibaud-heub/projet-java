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
                tiles[i] = new Tile(
                        ImageIO.read(getClass().getResourceAsStream("/ressources/dungeon/wall_" + i + ".png")), false);
            }
            tiles[10] = new Tile(ImageIO.read(getClass().getResourceAsStream("/ressources/dungeon/floor_ladder.png")),
                    false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < 28; i++) {
            for (int j = 0; j < 20; j++) {
                int tileNum = gp.getDungeon().getCurrentRoom().getMapTileNum(i, j);
                if (tileNum >= 0) {
                    g.drawImage(tiles[tileNum].getImage(), i * 32, j * 32, 32, 32, null);
                }
            }
        }
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
