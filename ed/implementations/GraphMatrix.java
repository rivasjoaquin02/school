package implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphMatrix<T> {
    private final HashMap<T, Integer> nodes;
    private final boolean[][] adjacencyMatrix;

    public GraphMatrix() {
        nodes = new HashMap<T, Integer>();
        adjacencyMatrix = new boolean[100][100];
    }

    public boolean isEmpty() {
        return nodes.isEmpty();
    }

    public int amountNodes() {
        return nodes.size();
    }

    public boolean isNodeInGraph(T node) {
        return nodes.containsKey(node);
    }

    public boolean isEdgeInGraph(Edge<T> edge) {
        int n0 = nodes.get(edge.v1);
        int n1 = nodes.get(edge.v2);

        return adjacencyMatrix[n0][n1];
    }

    public void insertNode(T node) {
        int idx = nodes.size() + 1;
        nodes.put(node, idx);
    }

    public void insertEdge(Edge<T> edge) {
        int n0 = nodes.get(edge.v1);
        int n1 = nodes.get(edge.v2);
        adjacencyMatrix[n0][n1] = true;
    }

    public void removeNode(T node) {
        nodes.remove(node);
    }

    public void removeEdge(Edge<T> edge) {
        int n0 = nodes.get(edge.v1);
        int n1 = nodes.get(edge.v2);
        adjacencyMatrix[n0][n1] = false;
    }

    public List<T> adjacentTo(T node) {
        List<T> adjacent = new ArrayList<>();
        int n0 = nodes.get(node);

        nodes.forEach((n, i) -> {
            int n1 = nodes.get(n);
            if (adjacencyMatrix[n0][n1])
                adjacent.add(n);
        });
        return adjacent;
    }

    public List<T> loopsOnes() {
        List<T> loops = new ArrayList<>();

        nodes.forEach((node, i) -> {
            int n0 = nodes.get(node);
            if (adjacencyMatrix[n0][n0])
                loops.add(node);
        });

        return loops;
    }

    public void lineUpNodes(List<T> allies) {
//        disconnect first
        for (T ally : allies) {
            int n0 = nodes.get(ally);

            for (int j = 0; j < nodes.size(); j++) {
                adjacencyMatrix[n0][j] = false;
                adjacencyMatrix[j][n0] = false;
            }
        }

//        connect allies with the other allies
        for (int i = 0; i < allies.size(); i++) {
            T ally = allies.get(i);

            int n0 = nodes.get(ally);
            for (int j = i; j < allies.size(); j++) {
                T allyAdj = allies.get(j);
                int n1 = nodes.get(allyAdj);

                adjacencyMatrix[n0][n1] = true;
                adjacencyMatrix[n1][n0] = true;
            }
        }
    }
}

