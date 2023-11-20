package graph;

import implementations.Edge;
import implementations.GraphMatrix;

import java.util.List;

class Tank {
    public String name;
    public int minCapacity;
    public int maxCapacity;

    public Tank(String name, int minCapacity, int maxCapacity) {
        this.name = name;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "Tank{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class ej3 {
    public static void main(String[] args) {
        GraphMatrix<Tank> tanksNetwork = new GraphMatrix<>();

        Tank t0 = new Tank("t0", 10, 10);
        Tank t1 = new Tank("t1", 10, 100);
        Tank t2 = new Tank("t2", 10, 30);
        Tank t3 = new Tank("t3", 10, 60);

        tanksNetwork.insertNode(t0);
        tanksNetwork.insertNode(t1);
        tanksNetwork.insertNode(t2);
        tanksNetwork.insertNode(t3);

        tanksNetwork.insertEdge(new Edge<>(t0, t1));
        tanksNetwork.insertEdge(new Edge<>(t0, t2));
        tanksNetwork.insertEdge(new Edge<>(t1, t3));

//       getConnectedTest(tanksNetwork);
       canPumpTest(tanksNetwork);
    }

    public static void getConnectedTest(GraphMatrix<Tank> tanksNetwork) {
        Tank t0 = new Tank("t0", 10, 10);
        Tank t1 = new Tank("t1", 10, 100);
        Tank t2 = new Tank("t2", 10, 30);
        Tank t3 = new Tank("t3", 10, 60);

        tanksNetwork.insertNode(t0);
        tanksNetwork.insertNode(t1);
        tanksNetwork.insertNode(t2);
        tanksNetwork.insertNode(t3);

        tanksNetwork.insertEdge(new Edge<>(t0, t1));
        tanksNetwork.insertEdge(new Edge<>(t0, t2));
        tanksNetwork.insertEdge(new Edge<>(t1, t3));

        System.out.println(tanksNetwork.adjacentTo(t0)); // [t1, t2]
    }

    public static void canPumpTest(GraphMatrix<Tank> tanksNetwork) {


    }
}
