package src.ed2_lab4.estudioIndependiente;

import java.util.List;

public class Maze {
    private final List<Room> rooms;
    private final List<List<Integer>> adjacentRooms;

    public boolean isASecureRoom(Room room) {
        int idxRoom = rooms.indexOf(room);

        return adjacentRooms
                .get(idxRoom)
                .stream()
                .noneMatch(idxAdjacent -> rooms.get(idxAdjacent).isCollapsed);
    }

    public Maze(List<Room> rooms, List<List<Integer>> adjacentRooms) {
        this.rooms = rooms;
        this.adjacentRooms = adjacentRooms;
    }
}
