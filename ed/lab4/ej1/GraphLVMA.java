package ed2_lab4.ej1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphLVMA<T> {
    private HashMap<T, Integer> nodeMapToInt;
    private HashMap<Integer, T> intMapToNode;
    private boolean[][] adjacencyMatrix;
    private final boolean isBidirectional;

    public boolean isEmpty() {
        return nodeMapToInt.isEmpty();
    }

    public boolean isNodeIn(T node) {
        return nodeMapToInt.get(node) != null;
    }

    public boolean isEdgeIn(T node1, T node2) {
        int idxNode1 = nodeMapToInt.get(node1);
        int idxNode2 = nodeMapToInt.get(node2);
        return adjacencyMatrix[idxNode1][idxNode2];
    }

    public void addNode(T node) {
        int idx = nodeMapToInt.size();
        nodeMapToInt.put(node, idx);
        intMapToNode.put(idx, node);
    }

    public void addEdge(T node1, T node2) {
        int idxNode1 = nodeMapToInt.get(node1);
        int idxNode2 = nodeMapToInt.get(node2);
        adjacencyMatrix[idxNode1][idxNode2] = true;
        if (isBidirectional)
            adjacencyMatrix[idxNode2][idxNode1] = true;
    }

    public void removeEdge(T node1, T node2) {
        int idxNode1 = nodeMapToInt.get(node1);
        int idxNode2 = nodeMapToInt.get(node2);
        adjacencyMatrix[idxNode1][idxNode2] = false;

        if (isBidirectional)
            adjacencyMatrix[idxNode2][idxNode1] = false;
    }

    public int amountOfNodes() {
        return nodeMapToInt.size();
    }

    public int amountOfEdges() {
        int amountEdges = 0;

        for (int i = 0; i < nodeMapToInt.size(); i++)
            for (int j = isBidirectional ? i : 0; j < nodeMapToInt.size(); j++)
                if (adjacencyMatrix[i][j])
                    amountEdges++;

        return amountEdges;
    }

    public List<T> adjacentTo(T node) {
        List<T> adjacent = new ArrayList<>();

        int idxNode = nodeMapToInt.get(node);

        for (int i = 0; i < nodeMapToInt.size(); i++)
            if (adjacencyMatrix[idxNode][i])
                adjacent.add(intMapToNode.get(i));

        return adjacent;
    }

    public int nodeDegree(T node) {
        int degree = 0;

        int idxNode = nodeMapToInt.get(node);
        for (int i = 0; i < nodeMapToInt.size(); i++)
            if (adjacencyMatrix[idxNode][i]) degree++;

        return degree;
    }


    /********************************************/

    public GraphLVMA(boolean isBidirectional) {
        int MAX_SIZE = 100;

        this.isBidirectional = isBidirectional;
        this.nodeMapToInt = new HashMap<>();
        this.intMapToNode = new HashMap<>();
        this.adjacencyMatrix = new boolean[MAX_SIZE][MAX_SIZE];
    }

    public GraphLVMA(HashMap<T, Integer> nodeMapToInt, boolean[][] adjacencyMatrix, boolean isBidirectional) {
        this.nodeMapToInt = nodeMapToInt;
        this.adjacencyMatrix = adjacencyMatrix;
        this.isBidirectional = isBidirectional;
    }

}
