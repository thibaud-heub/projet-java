package dungeon;

import java.util.Random;

import entity.abstractFactory.monsterType.Monster;

public class RoomBuilder {
    private Room result;

    public RoomBuilder() {
        reset();
    }

    public void setSize(int halfCols, int halfRows) {
        result.setCols(halfCols * 2);
        result.setRows(halfRows * 2);
    }

    public void buildWalls(boolean random) {
        int[][] tempMapTileNum = new int[result.getCols() / 2][result.getRows() / 2];

        for (int i = 0; i < tempMapTileNum.length; i++) {
            for (int j = 0; j < tempMapTileNum[0].length; j++) {
                if (i == 0 || i == tempMapTileNum.length - 1 || j == 0 || j == tempMapTileNum[0].length - 1) {
                    tempMapTileNum[i][j] = -1;
                } else {
                    tempMapTileNum[i][j] = 0;
                }
            }
        }

        if (random) {
            for (int i = 1; i < tempMapTileNum.length - 1; i++) {
                for (int j = 1; j < tempMapTileNum[0].length - 1; j++) {
                    int wallCounter = 0;
                    if (tempMapTileNum[i][j - 1] == -1) {
                        wallCounter++;
                    }
                    if (tempMapTileNum[i][j + 1] == -1) {
                        wallCounter++;
                    }
                    if (tempMapTileNum[i - 1][j] == -1) {
                        wallCounter++;
                    }
                    if (tempMapTileNum[i + 1][j] == -1) {
                        wallCounter++;
                    }
                    if (tempMapTileNum[i - 1][j - 1] == -1) {
                        if (tempMapTileNum[i][j - 1] == 0 && tempMapTileNum[i - 1][j] == 0) {
                            wallCounter += 2;
                        }
                    }
                    if (tempMapTileNum[i - 1][j + 1] == -1) {
                        if (tempMapTileNum[i][j + 1] == 0 && tempMapTileNum[i - 1][j] == 0) {
                            wallCounter += 2;
                        }
                    }
                    if (tempMapTileNum[i + 1][j - 1] == -1) {
                        if (tempMapTileNum[i][j - 1] == 0 && tempMapTileNum[i + 1][j] == 0) {
                            wallCounter += 2;
                        }
                    }
                    if (tempMapTileNum[i + 1][j + 1] == -1) {
                        if (tempMapTileNum[i][j + 1] == 0 && tempMapTileNum[i + 1][j] == 0) {
                            wallCounter += 2;
                        }
                    }
                    if (wallCounter < 2) {
                        tempMapTileNum[i][j] = new Random().nextInt(2) - 1;
                    }
                }
            }
        }

        for (int i = 0; i < result.getCols(); i++) {
            for (int j = 0; j < result.getRows(); j++) {
                result.setMapTileNum(tempMapTileNum[i / 2][j / 2], i, j);
            }
        }

        for (int i = 1; i < result.getCols() - 1; i++) {
            for (int j = 1; j < result.getRows() - 1; j++) {
                if (result.getMapTileNum(i, j) == -1) {
                    if (result.getMapTileNum(i, j - 1) == 0 && result.getMapTileNum(i - 1, j) == 0) {
                        result.setMapTileNum(6, i, j);
                    } else if (result.getMapTileNum(i, j - 1) == 0 && result.getMapTileNum(i + 1, j) == 0) {
                        result.setMapTileNum(7, i, j);
                    } else if (result.getMapTileNum(i, j + 1) == 0 && result.getMapTileNum(i - 1, j) == 0) {
                        result.setMapTileNum(8, i, j);
                    } else if (result.getMapTileNum(i, j + 1) == 0 && result.getMapTileNum(i + 1, j) == 0) {
                        result.setMapTileNum(9, i, j);
                    } else if (result.getMapTileNum(i, j - 1) == 0 || result.getMapTileNum(i, j + 1) == 0) {
                        result.setMapTileNum(1, i, j);
                    } else if (result.getMapTileNum(i + 1, j) == 0) {
                        result.setMapTileNum(2, i, j);
                    } else if (result.getMapTileNum(i - 1, j) == 0) {
                        result.setMapTileNum(3, i, j);
                    } else if (result.getMapTileNum(i + 1, j + 1) == 0) {
                        result.setMapTileNum(2, i, j);
                    } else if (result.getMapTileNum(i - 1, j + 1) == 0) {
                        result.setMapTileNum(3, i, j);
                    } else if (result.getMapTileNum(i + 1, j - 1) == 0) {
                        result.setMapTileNum(4, i, j);
                    } else if (result.getMapTileNum(i - 1, j - 1) == 0) {
                        result.setMapTileNum(5, i, j);
                    }
                }
            }
        }
    }

    public void buildLadder() {
        int ladderY;
        boolean positionFound = false;
        do {
            ladderY = new Random().nextInt(result.getRows() - 4) + 2;
            if (result.getMapTileNum(result.getCols() - 3, ladderY) == 0
                    && (result.getMapTileNum(result.getCols() - 3, ladderY - 1) == 1
                            || result.getMapTileNum(result.getCols() - 3, ladderY + 1) == 1)) {
                positionFound = true;
            }
        } while (!positionFound);
        result.setMapTileNum(10, result.getCols() - 3, ladderY);
    }

    public void buildLadder(int x, int y) {
        result.setMapTileNum(10, x, y);
    }

    public void centerRoom(int cols, int rows) {
        Room r = new Room(cols, rows);

        for (int i = 0; i < r.getCols(); i++) {
            for (int j = 0; j < r.getRows(); j++) {
                r.setMapTileNum(-1, i, j);
            }
        }

        for (int i = (r.getCols() - result.getCols()) / 2; i < (r.getCols() + result.getCols()) / 2; i++) {
            for (int j = (r.getRows() - result.getRows()) / 2; j < (r.getRows() + result.getRows()) / 2; j++) {
                r.setMapTileNum(result.getMapTileNum(i - (r.getCols() - result.getCols()) / 2,
                        j - (r.getRows() - result.getRows()) / 2), i, j);
            }
        }

        result = r;
    }

    public void buildMonsters(Monster[] monsters, boolean boss) {
        if (boss) {
            monsters[0].setXY(672, 480);
            result.setMonsters(new Monster[] {monsters[0]});
        } else {
            for (int i = 0; i < monsters.length; i++) {
                int x, y;
                do {
                    x = new Random().nextInt(896);
                    y = new Random().nextInt(640);
                } while (result.getMapTileNum(x / 32, y / 32) != 0);
                monsters[i].setXY(x, y);
            }
            result.setMonsters(monsters);
        }
    }

    public void buildPlayerSpawn() {
        int x, y;
        boolean onMonster;
        do {
            onMonster = false;
            x = new Random().nextInt(448);
            y = new Random().nextInt(640);
            for (Monster monster : result.getMonsters()) {
                if (x / 32 == monster.getX() / 32 || y / 32 == monster.getY() / 32) {
                    onMonster = true;
                }
            }
        } while (result.getMapTileNum(x / 32, y / 32) != 0 || onMonster);
        result.setPlayerSpawnX(x);
        result.setPlayerSpawnY(y);
    }

    public void buildPlayerSpawn(int x, int y) {
        result.setPlayerSpawnX(x*32);
        result.setPlayerSpawnY(y*32);
    }

    public Room getResult() {
        return result;
    }

    public void reset() {
        this.result = new Room();
    }

}
