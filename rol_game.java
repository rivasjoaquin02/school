import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Player implements Comparable<Player> {
    protected String id;
    protected int gameHours;
    protected int gameScore;

    public Player(int gameHours, int gameScore) {
        this.id = String.valueOf(Math.random());
        this.gameHours = gameHours;
        this.gameScore = gameScore;
    }

    @Override
    public int compareTo(Player player) {
        if (this.gameHours < player.gameHours) return -1;
        else if (this.gameHours > player.gameHours) return 1;
        return player.gameScore - this.gameScore;
    }

    public String toString() {
        return id + gameHours + gameScore;
    }
}

class Server {
    protected List<Player> playerList;
    protected Queue<Player> playerQueue;

    public Server(List<Player> playerList) {
        this.playerList = playerList;
        playerQueue = new PriorityQueue<>(playerList);
    }

    public List<Player> queueState() {
        List<Player> state = new ArrayList<>();

        while (!playerQueue.isEmpty())
            state.add(playerQueue.poll());

        return state;
    }
}


public class rol_game {
    public static void main(String[] args) {
        Server s0 = new Server(
                List.of(
                        new Player(100, 20),
                        new Player(50, 20),
                        new Player(200, 20),
                        new Player(100, 60)
                )
        );

        List<Player> sol = s0.queueState();
        System.out.println(sol);
    }
}
