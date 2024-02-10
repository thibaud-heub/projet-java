package room;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Room extends JPanel {
    private BufferedImage[] tiles;
    private int[][] tileMap;
    private int width;
    private int height;
    private int tileSize;

    public Room(int halfWidth, int halfHeight, int tileSize) {
        int[][] tempTileMap = new int[halfHeight][halfWidth];
        width = tempTileMap[0].length * 2;
        height = tempTileMap.length * 2;
        this.tileSize = tileSize;
        tileMap = new int[height][width];

        setPreferredSize(new Dimension(width * this.tileSize, height * this.tileSize));

        tiles = new BufferedImage[11];
        try {
            tiles[0] = ImageIO.read(getClass().getResourceAsStream("/image/floor.png"));
            for (int i = 1; i < 10; i++) {
                tiles[i] = ImageIO.read(getClass().getResourceAsStream("/image/wall_" + i + ".png"));
            }
            tiles[10] = ImageIO.read(getClass().getResourceAsStream("/image/floor_ladder.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < tempTileMap.length; i++) {
            for (int j = 0; j < tempTileMap[0].length; j++) {
                if (i == 0 || i == tempTileMap.length - 1 || j == 0 || j == tempTileMap[0].length - 1) {
                    tempTileMap[i][j] = -1;
                } else {
                    tempTileMap[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < tempTileMap.length - 1; i++) {
            for (int j = 1; j < tempTileMap[0].length - 1; j++) {
                int wallCounter = 0;
                if (tempTileMap[i][j - 1] == -1) {
                    wallCounter++;
                }
                if (tempTileMap[i][j + 1] == -1) {
                    wallCounter++;
                }
                if (tempTileMap[i - 1][j] == -1) {
                    wallCounter++;
                }
                if (tempTileMap[i + 1][j] == -1) {
                    wallCounter++;
                }
                if (tempTileMap[i - 1][j - 1] == -1) {
                    if (tempTileMap[i][j - 1] == 0 && tempTileMap[i - 1][j] == 0) {
                        wallCounter += 2;
                    }
                }
                if (tempTileMap[i - 1][j + 1] == -1) {
                    if (tempTileMap[i][j + 1] == 0 && tempTileMap[i - 1][j] == 0) {
                        wallCounter += 2;
                    }
                }
                if (tempTileMap[i + 1][j - 1] == -1) {
                    if (tempTileMap[i][j - 1] == 0 && tempTileMap[i + 1][j] == 0) {
                        wallCounter += 2;
                    }
                }
                if (tempTileMap[i + 1][j + 1] == -1) {
                    if (tempTileMap[i][j + 1] == 0 && tempTileMap[i + 1][j] == 0) {
                        wallCounter += 2;
                    }
                }
                if (wallCounter < 2) {
                    tempTileMap[i][j] = new Random().nextInt(-1, 1);
                }
            }
        }

        for (int i = 0; i < tileMap.length; i++) {
            for (int j = 0; j < tileMap[0].length; j++) {
                tileMap[i][j] = tempTileMap[i / 2][j / 2];
            }
        }

        for (int i = 1; i < tileMap.length - 1; i++) {
            for (int j = 1; j < tileMap[0].length - 1; j++) {
                if (tileMap[i][j] == -1) {
                    if (tileMap[i - 1][j] == 0 && tileMap[i][j - 1] == 0) {
                        tileMap[i][j] = 6;
                    } else if (tileMap[i - 1][j] == 0 && tileMap[i][j + 1] == 0) {
                        tileMap[i][j] = 7;
                    } else if (tileMap[i + 1][j] == 0 && tileMap[i][j - 1] == 0) {
                        tileMap[i][j] = 8;
                    } else if (tileMap[i + 1][j] == 0 && tileMap[i][j + 1] == 0) {
                        tileMap[i][j] = 9;
                    } else if (tileMap[i - 1][j] == 0 || tileMap[i + 1][j] == 0) {
                        tileMap[i][j] = 1;
                    } else if (tileMap[i][j + 1] == 0) {
                        tileMap[i][j] = 2;
                    } else if (tileMap[i][j - 1] == 0) {
                        tileMap[i][j] = 3;
                    } else if (tileMap[i + 1][j + 1] == 0) {
                        tileMap[i][j] = 2;
                    } else if (tileMap[i + 1][j - 1] == 0) {
                        tileMap[i][j] = 3;
                    } else if (tileMap[i - 1][j + 1] == 0) {
                        tileMap[i][j] = 4;
                    } else if (tileMap[i - 1][j - 1] == 0) {
                        tileMap[i][j] = 5;
                    }
                }
            }
        }

        int ladderY;
        boolean positionFound = false;
        do {
            ladderY = new Random().nextInt(2, tileMap.length - 2);
            if (tileMap[ladderY][tileMap[0].length - 3] == 0 && (tileMap[ladderY - 1][tileMap[0].length - 3] == 1
                    || tileMap[ladderY + 1][tileMap[0].length - 3] == 1)) {
                positionFound = true;
            }
        } while (!positionFound);
        tileMap[ladderY][tileMap[0].length - 3] = 10;
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (int i = 0; i < tileMap.length; i++) {
            for (int j = 0; j < tileMap[0].length; j++) {
                if (tileMap[i][j] != -1) {
                    g.drawImage(tiles[tileMap[i][j]], j * tileSize, i * tileSize, tileSize, tileSize, this);
                }
            }
        }
    }
}
