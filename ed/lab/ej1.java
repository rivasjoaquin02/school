package lab;

import java.util.ArrayList;
import java.util.List;

class Game {
    protected String name;
    protected int difficulty;
    protected int amountOfLevels;
    protected int amountOfEnemies;

    public Game(String name, int difficulty, int amountOfLevels, int amountOfEnemies) {
        this.name = name;
        this.difficulty = difficulty;
        this.amountOfLevels = amountOfLevels;
        this.amountOfEnemies = amountOfEnemies;
    }

    @Override
    public String toString() {
        return "lab.Game{" +
                "name='" + name + '\'' +
                ", difficulty=" + difficulty +
                ", amountOfLevels=" + amountOfLevels +
                ", amountOfEnemies=" + amountOfEnemies +
                '}';
    }
}

class GameStore {
    private final List<Game> games;

    public GameStore(List<Game> games) {
        this.games = games;
    }

    private int calculateScore(Game game) {
        return (game.difficulty + game.amountOfLevels) / game.amountOfEnemies;
    }

    private int search(List<Game> games, int value) {
        int lo = 0;
        int hi = games.size() - 1;
        int m = -1;
        boolean found = false;

        while (lo <= hi && !found) {
            m = (lo + hi) / 2;
            int score = calculateScore(games.get(m));

            if (score == value)
                found = true;
            else if (score < value)
                hi = m - 1;
            else lo = m + 1;
        }
        return m;
    }

    public List<Game> searchGames(int[] values) {
        this.games.sort((o1, o2) -> calculateScore(o2) - calculateScore(o1));
        List<Game> gamesWithScore = new ArrayList<>();

        for (int value : values) {
            int pos = this.search(games, value);
            if (pos >= 0) gamesWithScore.add(games.get(pos));
        }
        return gamesWithScore;
    }
}

public class ej1 {
    public static void main(String[] args) {
        GameStore store = new GameStore(
                new ArrayList<>(
                        List.of(
                                new Game("a", 30, 20, 10),
                                new Game("b", 20, 11, 17),
                                new Game("c", 60, 50, 10),
                                new Game("d", 10, 80, 20)
                        )
                )
        );

        List<Game> foundedGames = store.searchGames(new int[]{5, 11});
        for (Game game : foundedGames)
            System.out.println(game);
    }
}
