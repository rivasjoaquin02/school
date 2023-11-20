package ed2_lab4.te;

import java.util.HashMap;
import java.util.List;

public class ComputerNetwork {
    protected HashMap<Computer, Integer> computers;
    protected boolean[][] connections;

    public ComputerNetwork(int maxNetworkSize) {
        computers = new HashMap<>();
        connections = new boolean[maxNetworkSize][maxNetworkSize];
    }

    public void addComputer(Computer computer) {
        int idx = computers.size();
        computers.put(computer, idx);
    }

    public void addConnection(Computer computer1, Computer computer2) {
        int idxComputer1 = computers.get(computer1);
        int idxComputer2 = computers.get(computer2);

        connections[idxComputer1][idxComputer2] = true;
        connections[idxComputer2][idxComputer1] = true;
    }

    public boolean hasLessVulnerable() {
        boolean hasLessVulnerable = false;

        for (int i = 0; i < computers.size(); i++) {
            boolean isLessVulnerable = true;
            for (int j = 0; j < computers.size(); j++) {
                if (connections[i][j]) {
                    isLessVulnerable = false;
                    break;
                }
            }
            if (isLessVulnerable) hasLessVulnerable = true;
        }

        return hasLessVulnerable;
    }

    public int amountHighlyVulnerable(List<Computer> computersToCheck) {
        int amountHighlyVulnerable = 0;

        for (Computer computer : computersToCheck) {
            int amountConnections = 0;
            int idx = computers.get(computer);

            for (int i = 0; i < computers.size(); i++)
                if (connections[idx][i]) amountConnections++;

            if (amountConnections > 4)
                amountHighlyVulnerable++;
        }
        return amountHighlyVulnerable;
    }
}
