/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ed2_lab4;

import ed2_lab4.ej1.GraphLVMA;
import ed2_lab4.ej2.Person;
import ed2_lab4.ej2.PersonNetwork;
import ed2_lab4.te.Computer;
import ed2_lab4.te.ComputerNetwork;

import java.util.ArrayList;
import java.util.List;


public class ED2_Lab4 {
    public static void main(String[] args) {
//        ej1();
//        ej2();
        te();
    }

    public static void ej1() {
        GraphLVMA<String> graph = new GraphLVMA<>(true);
        graph.addNode("one");
        graph.addNode("two");
        graph.addNode("three");
        graph.addNode("four");
        graph.addNode("five");

        graph.addEdge("one", "two");
        graph.addEdge("one", "five");

        graph.addEdge("two", "three");
        graph.addEdge("two", "four");
        graph.addEdge("two", "five");

        graph.addEdge("three", "four");
        graph.addEdge("three", "five");


        System.out.println(graph.isEmpty()); // false

        System.out.println(graph.isNodeIn("one")); //true
        System.out.println(graph.isNodeIn("ten")); //false

        System.out.println(graph.isEdgeIn("one", "two")); //true
        System.out.println(graph.isEdgeIn("one", "three")); //false

        graph.addEdge("one", "three");
        System.out.println(graph.isEdgeIn("one", "three")); //true

        graph.removeEdge("one", "three");
        System.out.println(graph.isEdgeIn("one", "three")); //false

        System.out.println(graph.amountOfNodes()); //5
        System.out.println(graph.amountOfEdges()); //7

        System.out.println(graph.adjacentTo("one")); //[two, five]
        System.out.println(graph.adjacentTo("three")); //[two, four, five]

        System.out.println(graph.nodeDegree("one")); //2
    }

    public static void ej2() {
        Person p0 = new Person("Sabrina", "sabrina@gmail.com", 19);
        Person p1 = new Person("Roberto", "roberto@gmail.com", 10);
        Person p2 = new Person("Adrián", "adrian@gmail.com", 28);
        Person p3 = new Person("Roxana", "roxana@gmail.com", 47);
        Person p4 = new Person("Alayn", "alayn@gmail.com", 7);

        PersonNetwork red = new PersonNetwork(
                new ArrayList<>(List.of(p0, p1, p2, p3, p4)),
                new boolean[][]{
                        {false, true, false, false, true},
                        {true, false, true, true, true},
                        {false, true, false, true, true},
                        {false, true, true, false, false},
                        {true, true, true, false, false}}
        );

        System.out.println(red.friendsInCommon(p0, p1)); //[Alayn]
        System.out.println(red.friendsInCommon(p0, p2)); //[Roberto, Alayn]

        System.out.println(red.hasYoungFriends(p0)); //false
        System.out.println(red.hasYoungFriends(p1)); //true

        System.out.println(red.amountPersonsWithKFriends(2)); //2
        System.out.println(red.amountPersonsWithKFriends(3)); //2
    }

    public static void te() {
        Computer c0 = new Computer(0, 19216801, "node0");
        Computer c1 = new Computer(1, 19216811, "node1");
        Computer c2 = new Computer(2, 19216821, "node2");
        Computer c3 = new Computer(3, 19216831, "node3");
        Computer c4 = new Computer(4, 19216841, "node4");

        ComputerNetwork network = new ComputerNetwork(5);
        network.addComputer(c0);
        network.addComputer(c1);
        network.addComputer(c2);
        network.addComputer(c3);
        network.addComputer(c4);

        network.addConnection(c0, c1);
        network.addConnection(c0, c4);
        network.addConnection(c1, c2);
        network.addConnection(c1, c4);
        network.addConnection(c2, c4);
        network.addConnection(c3, c4);
        network.addConnection(c4, c4);

        System.out.println(network.hasLessVulnerable()); //false
        System.out.println(network.amountHighlyVulnerable(List.of(c0, c2))); //0
        System.out.println(network.amountHighlyVulnerable(List.of(c4, c0, c1, c2, c3))); //1

    }

}
