package game;

import entity.Direction;
import entity.character;
import entity.entity;

public class CollisionChecker {
    private GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(entity e, Direction direction) {
        int entityLeftX = e.getX() + e.getSolidArea().x;
        int entityRightX = e.getX() + e.getSolidArea().x + e.getSolidArea().width;
        int entityTopY = e.getY() + e.getSolidArea().y;
        int entityBottomY = e.getY() + e.getSolidArea().y + e.getSolidArea().height;

        int entityLeftCol = entityLeftX / 32;
        int entityRightCol = entityRightX / 32;
        int entityTopRow = entityTopY / 32;
        int entityBottomRow = entityBottomY / 32;

        int tileNum1, tileNum2;

        switch (direction) {
            case NORTH:
                entityTopRow = (entityTopY - e.getSpeed()) / 32;
                tileNum1 = gp.getDungeon().getCurrentRoom().getMapTileNum(entityLeftCol, entityTopRow);
                tileNum2 = gp.getDungeon().getCurrentRoom().getMapTileNum(entityRightCol, entityTopRow);
                if (gp.getTileM().getTiles()[tileNum1].isCollision()
                        || gp.getTileM().getTiles()[tileNum2].isCollision()) {
                    e.setCollisionOn(true);
                    if (e instanceof character && (tileNum1 == 10 || tileNum2 == 10)) {
                        gp.setMonsters(gp.getDungeon().nextRoom());
                        gp.getCurrentCharacter().setXY(gp.getDungeon().getCurrentRoom().getPlayerSpawnX(),
                                gp.getDungeon().getCurrentRoom().getPlayerSpawnY());
                    }
                }
                break;
            case SOUTH:
                entityBottomRow = (entityBottomY + e.getSpeed()) / 32;
                tileNum1 = gp.getDungeon().getCurrentRoom().getMapTileNum(entityLeftCol, entityBottomRow);
                tileNum2 = gp.getDungeon().getCurrentRoom().getMapTileNum(entityRightCol, entityBottomRow);
                if (gp.getTileM().getTiles()[tileNum1].isCollision()
                        || gp.getTileM().getTiles()[tileNum2].isCollision()) {
                    e.setCollisionOn(true);
                    if (e instanceof character && (tileNum1 == 10 || tileNum2 == 10)) {
                        gp.setMonsters(gp.getDungeon().nextRoom());
                        gp.getCurrentCharacter().setXY(gp.getDungeon().getCurrentRoom().getPlayerSpawnX(),
                                gp.getDungeon().getCurrentRoom().getPlayerSpawnY());
                    }
                }
                break;
            case WEST:
                entityLeftCol = (entityLeftX - e.getSpeed()) / 32;
                tileNum1 = gp.getDungeon().getCurrentRoom().getMapTileNum(entityLeftCol, entityTopRow);
                tileNum2 = gp.getDungeon().getCurrentRoom().getMapTileNum(entityLeftCol, entityBottomRow);
                if (gp.getTileM().getTiles()[tileNum1].isCollision()
                        || gp.getTileM().getTiles()[tileNum2].isCollision()) {
                    e.setCollisionOn(true);
                    if (e instanceof character && (tileNum1 == 10 || tileNum2 == 10)) {
                        gp.setMonsters(gp.getDungeon().nextRoom());
                        gp.getCurrentCharacter().setXY(gp.getDungeon().getCurrentRoom().getPlayerSpawnX(),
                                gp.getDungeon().getCurrentRoom().getPlayerSpawnY());
                    }
                }
                break;
            case EAST:
                entityRightCol = (entityRightX + e.getSpeed()) / 32;
                tileNum1 = gp.getDungeon().getCurrentRoom().getMapTileNum(entityRightCol, entityTopRow);
                tileNum2 = gp.getDungeon().getCurrentRoom().getMapTileNum(entityRightCol, entityBottomRow);
                if (gp.getTileM().getTiles()[tileNum1].isCollision()
                        || gp.getTileM().getTiles()[tileNum2].isCollision()) {
                    e.setCollisionOn(true);
                    if (e instanceof character && (tileNum1 == 10 || tileNum2 == 10)) {
                        gp.setMonsters(gp.getDungeon().nextRoom());
                        gp.getCurrentCharacter().setXY(gp.getDungeon().getCurrentRoom().getPlayerSpawnX(),
                                gp.getDungeon().getCurrentRoom().getPlayerSpawnY());
                    }
                }
                break;
        }
    }
}
