import java.util.List;

class House {
    protected int number;

    public House(int number) {
        this.number = number;
    }
}

class ElectricNetwork {
    protected List<House> houses;
    protected List<List<Integer>> neighborhood;

    public ElectricNetwork(List<House> houses, List<List<Integer>> neighborhood) {
        this.houses = houses;
        this.neighborhood = neighborhood;
    }

    public boolean isInterconnected(House house1, House house2) {
        int size = houses.size();

        int idxHouse1 = houses.indexOf(house1);
        int idxHouse2 = houses.indexOf(house2);

        boolean[] visited = new boolean[size];
        dfs(visited, idxHouse1);

        return visited[idxHouse2];
    }

    private void dfs(boolean[] visited, int pos) {
        visited[pos] = true;

        for (Integer neighbor : neighborhood.get(pos))
            if (!visited[neighbor])
                dfs(visited, neighbor);
    }

    public int amountCircuits() {
        int amount = 0;

        int size = houses.size();
        boolean[] visited = new boolean[size];

        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                amount++;
                dfs(visited, i);
            }
        }

        return amount;
    }
}


public class ej1 {
    public static void main(String[] args) {
        House h1 = new House(1);
        House h2 = new House(2);
        House h3 = new House(3);
        House h4 = new House(4);

//        ElectricNetwork en0 =
    }
}
