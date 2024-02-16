package dungeon;

import entity.abstractFactory.monsterType.Monster;

public class Room {
    private int cols;
    private int rows;
    private int[][] mapTileNum;
    private Monster[] monsters = new Monster[0];
    private int playerSpawnX = 0;
    private int playerSpawnY = 0;

    public Room() {
        this(0,0);
    }

    public Room(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.mapTileNum = new int[cols][rows];
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
        this.mapTileNum = new int[cols][rows];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
        this.mapTileNum = new int[cols][rows];
    }

    public int getMapTileNum(int x, int y) {
        return mapTileNum[x][y];
    }

    public void setMapTileNum(int mapTileNum, int x, int y) {
        this.mapTileNum[x][y] = mapTileNum;
    }

    public Monster[] getMonsters() {
        return monsters;
    }

    public void setMonsters(Monster[] monsters) {
        this.monsters = monsters;
    }

    public int getPlayerSpawnX() {
        return playerSpawnX;
    }

    public void setPlayerSpawnX(int playerSpawnX) {
        this.playerSpawnX = playerSpawnX;
    }

    public int getPlayerSpawnY() {
        return playerSpawnY;
    }

    public void setPlayerSpawnY(int playerSpawnY) {
        this.playerSpawnY = playerSpawnY;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                s += mapTileNum[j][i] + " ";
            }
            s += "\n";
        }

        for (int i = 0; i < monsters.length; i++) {
            s += "(" + monsters[i].getX() + ", " + monsters[i].getY() + ") ";
        }

        s += "\n(" + playerSpawnX + ", " + playerSpawnY + ")";

        return s;
    }
}
