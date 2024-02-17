package dungeon;

import entity.abstractFactory.monsterType.Monster;

public class RoomDirector {
    private RoomBuilder builder;

    public RoomDirector(RoomBuilder builder) {
        this.builder = builder;
    }

    public RoomBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(RoomBuilder builder) {
        this.builder = builder;
    }

    public Room makeSpawnRoom() {
        builder.reset();
        builder.setSize(7, 5);
        builder.buildWalls(false);
        builder.buildLadder(8, 4);
        builder.centerRoom(28, 20);
        builder.buildPlayerSpawn(11, 9);
        return builder.getResult();
    }

    public Room makeFightRoom(Monster[] monsters) {
        builder.reset();
        builder.setSize(14, 10);
        builder.buildWalls(true);
        builder.buildLadder();
        builder.buildMonsters(monsters, false);
        builder.buildPlayerSpawn();
        return builder.getResult();
    }

    public Room makeBossRoom(Monster[] monsters) {
        builder.reset();
        builder.setSize(14, 10);
        builder.buildWalls(false);
        builder.buildMonsters(monsters, true);
        builder.buildPlayerSpawn(7, 10);
        return builder.getResult();
    }
}
