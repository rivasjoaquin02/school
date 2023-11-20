import java.util.ArrayList;
import java.util.List;

class Player {
    protected String name;
    protected int life;
    protected int attack;
    protected int sp;

    public Player(String name, int life, int attack, int sp) {
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.sp = sp;
    }
}

class Raid {
    protected List<Player> players;
    protected int[][] distances;

    public Raid(List<Player> players, int[][] distances) {
        this.players = players;
        this.distances = distances;
    }

    public int castRelief(Player priest, Player objetivePlayer) {
        int idxPriest = players.indexOf(priest);
        int idxPlayer = players.indexOf(objetivePlayer);

        int INITIAL_DISTANCE = 0;
        int SPELL_POWER = players.get(idxPriest).sp;
        boolean[] visited = new boolean[players.size()];

//        return dfs(INITIAL_DISTANCE, visited, idxPlayer, SPELL_POWER);
        return dfsFixed(INITIAL_DISTANCE, visited, idxPlayer, SPELL_POWER);
    }

    private int dfs(int distance, boolean[] visited, int currentPosition, int spellpower) {
        if (distance > 5) return 0;

        visited[currentPosition] = true;
        int amountRelief = (3 * spellpower);

        for (int ady = 0; ady < players.size(); ady++) {
            if (!visited[ady] && distances[currentPosition][ady] > 0) {
                amountRelief += dfs(
                        distance + distances[currentPosition][ady],
                        visited,
                        ady,
                        spellpower
                );
            }
        }

        return amountRelief;
    }

    private int dfsFixed(int distance, boolean[] visited, int currentPosition, int spellpower) {
        if (distance > 5) return 0;

        visited[currentPosition] = true;
        int amountRelief = (3 * spellpower);

        for (int ady = 0; ady < players.size(); ady++) {
            if (!visited[ady] && distances[currentPosition][ady] > 0) {
                amountRelief += dfsFixed(
                        distance + distances[currentPosition][ady],
                        visited,
                        ady,
                        spellpower
                );
                visited[currentPosition] = false;
            }
        }

        return amountRelief;
    }
}


public class ej2 {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    static void test1() {
        Player pa = new Player("a", 100, 20, 100);
        Player pb = new Player("b", 100, 20, 100);
        Player pc = new Player("c", 100, 20, 100);
        Player pd = new Player("d", 100, 20, 100);
        Player pe = new Player("e", 100, 20, 100);
        Player pf = new Player("f", 100, 20, 100);
        Player pg = new Player("g", 100, 20, 100);
        Player ph = new Player("h", 100, 10, 100);

        List<Player> players = new ArrayList<>(List.of(pg, pb, ph, pf, pe, pd, pc, pa));

        int[][] distances = new int[players.size()][players.size()];
        distances[7][1] = 5;
        distances[7][0] = 3;
        distances[7][6] = 2;
        distances[7][4] = 1;
        distances[6][5] = 4;
        distances[6][4] = 1;
        distances[1][2] = 2;
        distances[4][3] = 2;

        Raid r0 = new Raid(players, distances);

        System.out.println(r0.castRelief(ph, pa)); // 1800
    }

    static void test2() {
        Player pa = new Player("a", 100, 20, 100);
        Player pb = new Player("b", 100, 20, 100);
        Player pc = new Player("c", 100, 20, 100);
        Player pd = new Player("d", 100, 20, 100);
        Player pe = new Player("e", 100, 20, 100);

        List<Player> players = new ArrayList<>(List.of(pa, pb, pc, pd, pe));

        int[][] distances = new int[players.size()][players.size()];
        distances[0][1] = 3;
        distances[0][2] = 1;
        distances[0][3] = 5;
        distances[1][3] = 1;
        distances[2][3] = 3;
        distances[3][4] = 1;

        Raid r0 = new Raid(players, distances);

        System.out.println(r0.castRelief(pa, pb)); // 3
        System.out.println(r0.castRelief(pa, pc)); // 1
        System.out.println(r0.castRelief(pa, pd)); // 1
        System.out.println(r0.castRelief(pa, pe)); // 2
    }
}
