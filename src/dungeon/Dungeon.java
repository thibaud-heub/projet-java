package dungeon;

import entity.MonsterGame.monsterManager;

public class Dungeon {
    private Room[] rooms;
    private monsterManager manager;
    private int currentRoomIndex;

    public Dungeon(int nbRooms) {
        rooms = new Room[nbRooms];
        manager = new monsterManager();
        currentRoomIndex = 0;
        RoomBuilder roomBuilder = new RoomBuilder();
        RoomDirector roomDirector = new RoomDirector(roomBuilder);

        rooms[0] = roomDirector.makeSpawnRoom();
        for (int i = 1; i < rooms.length - 1; i++) {
            rooms[i] = roomDirector.makeFightRoom(manager.monstersLevel(false));
        }
        rooms[rooms.length - 1] = roomDirector.makeBossRoom(manager.monstersLevel(true));
    }

    public Room getCurrentRoom() {
        return rooms[currentRoomIndex];
    }

    public Room nextRoom() {
        if (currentRoomIndex == rooms.length - 1) {
            return null;
        } else {
            return rooms[++currentRoomIndex];
        }
    }
}
