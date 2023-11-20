package implementations;

class City {
    protected String name;
    protected int population;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" + "name='" + name + '\'' + ", population=" + population + '}';
    }
}

public class GraphMatrixTest {
    public static void main(String[] args) {
        GraphMatrix<City> g = new GraphMatrix<>();

        System.out.println(g.isEmpty()); // true

        City new_york = new City("New York", 11000);
        City tokyo = new City("Tokyo", 5000);
        City toronto = new City("Toronto", 1000);
        City paris = new City("Paris", 400);
        City madrid = new City("Madrid", 1000);

        g.insertNode(new_york);
        g.insertNode(tokyo);
        g.insertNode(toronto);
        g.insertNode(paris);
        g.insertNode(madrid);

        g.insertEdge(new Edge<>(new_york, tokyo));
        g.insertEdge(new Edge<>(new_york, toronto));
        g.insertEdge(new Edge<>(new_york, madrid));
        g.insertEdge(new Edge<>(paris, madrid));

        System.out.println(g.amountNodes()); //5
        System.out.println(g.isNodeInGraph(tokyo)); //true
        System.out.println(g.isNodeInGraph(paris)); //true
        System.out.println(g.isNodeInGraph(new City("Havana", 100))); //false

        g.removeNode(madrid);
        System.out.println(g.amountNodes()); //4

        System.out.println(g.adjacentTo(new_york)); // [tokyo, toronto]
        System.out.println(g.adjacentTo(paris)); // []

        System.out.println(g.loopsOnes()); // []
        g.insertEdge(new Edge<>(paris, paris));
        System.out.println(g.loopsOnes()); // [paris]


    }
}
