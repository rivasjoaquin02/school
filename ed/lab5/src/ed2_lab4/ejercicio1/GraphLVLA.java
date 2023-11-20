package src.ed2_lab4.ejercicio1;

import java.util.List;

public class GraphLVLA {
    private final List<String> nodes;
    private final List<List<Integer>> adjacencyList;

    public GraphLVLA(List<String> nodes, List<List<Integer>> adjacencyList) {
        this.nodes = nodes;
        this.adjacencyList = adjacencyList;
    }

    public boolean isEmpty() {
        return nodes.isEmpty();
    }

    public List<String> adjacentTo(String node) {
        int nodeIdx = nodes.indexOf(node);

        return adjacencyList
                .get(nodeIdx)
                .stream()
                .map(nodes::get)
                .toList();
    }

    public int incidentTo(String node) {
        int nodeIdx = nodes.indexOf(node);

        return (int) adjacencyList
                .stream()
                .filter(integers -> integers.contains(nodeIdx))
                .count();
    }
}
