package src.ed2_lab4.estudioIndependiente;

public class Room {
    protected int id;
    protected boolean isCollapsed;

    public Room(int id, boolean isCollapsed) {
        this.id = id;
        this.isCollapsed = isCollapsed;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", isCollapsed=" + isCollapsed +
                '}';
    }
}
