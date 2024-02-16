package dungeon;

import characters.abstractFactory.monsterType.Monster;

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
        builder.buildPlayerSpawn(4, 4);
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
        builder.buildPlayerSpawn();
        return builder.getResult();
    }
}
