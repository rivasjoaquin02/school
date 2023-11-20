package src;

import src.ed2_lab4.ejercicio1.GraphLVLA;
import src.ed2_lab4.ejercicio2.Person;
import src.ed2_lab4.ejercicio2.PersonNetwork;
import src.ed2_lab4.estudioIndependiente.Maze;
import src.ed2_lab4.estudioIndependiente.Room;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ej1();
        ej2();
//        te();
    }

    public static void ej1() {
        List<String> LV = new ArrayList<>(List.of("one", "two", "three", "four", "five"));
        List<List<Integer>> LA = new ArrayList<>();

//        adjacent to: one
        LA.add(new ArrayList<>(List.of(2, 3)));
//        adjacent to: two
        LA.add(new ArrayList<>(List.of(2, 4)));
//        adjacent to: three
        LA.add(new ArrayList<>(List.of(0, 1)));
//        adjacent to: four
        LA.add(new ArrayList<>(List.of(3, 4)));


        GraphLVLA graph = new GraphLVLA(LV, LA);

        System.out.println(graph.isEmpty()); // false

//        adjacent to
        System.out.println(graph.adjacentTo("one")); //[three, four]
        System.out.println(graph.adjacentTo("three")); //[one, two]

//        incident to
        System.out.println(graph.incidentTo("two")); //1
        System.out.println(graph.incidentTo("five")); //2
    }

    public static void ej2() {
        Person a = new Person("a", "a@email.com", 19);
        Person b = new Person("b", "b@email.com", 10);
        Person c = new Person("c", "c@email.com", 28);
        Person d = new Person("d", "d@email.com", 47);
        Person e = new Person("e", "e@email.com", 7);

        List<Person> LV = new ArrayList<>(List.of(a, b, c, d, e));
        List<List<Integer>> LA = new ArrayList<>();

        LA.add(new ArrayList<>(List.of(1, 4)));
        LA.add(new ArrayList<>(List.of(0, 2, 3, 4)));
        LA.add(new ArrayList<>(List.of(1, 2, 0)));
        LA.add(new ArrayList<>(List.of(1, 2)));
        LA.add(new ArrayList<>(List.of(0, 2)));

        PersonNetwork pn = new PersonNetwork(LV, LA);

//        friendsInCommon
        System.out.println(pn.friendsInCommon(a, b)); // [e]
        System.out.println(pn.friendsInCommon(d, e)); // [c]
        System.out.println(pn.friendsInCommon(a, c)); // [b]

//        hasYoungFriends
        System.out.println(pn.hasYoungFriends(a)); // true
        System.out.println(pn.hasYoungFriends(b)); // true
        System.out.println(pn.hasYoungFriends(d)); // true
        System.out.println(pn.hasYoungFriends(e)); // false

//        amountPersonsWithKFriends
        System.out.println(pn.amountPersonsWithKFriends(3)); // 1
        System.out.println(pn.amountPersonsWithKFriends(2)); // 3
        System.out.println(pn.amountPersonsWithKFriends(4)); // 1
        System.out.println(pn.amountPersonsWithKFriends(6)); // 0
    }

    public static void te() {
        Room a = new Room(0, true);
        Room b = new Room(1, false);
        Room c = new Room(2, false);
        Room d = new Room(3, true);
        Room e = new Room(4, false);

        List<Room> LV = new ArrayList<>(List.of(a, b, c, d, e));
        List<List<Integer>> LA = new ArrayList<>();

        LA.add(new ArrayList<>(List.of(3, 4)));
        LA.add(new ArrayList<>(List.of(1, 4)));
        LA.add(new ArrayList<>(List.of(2, 3)));
        LA.add(new ArrayList<>(List.of(1, 3)));
        LA.add(new ArrayList<>(List.of()));

        Maze maze = new Maze(LV, LA);

        System.out.println(maze.isASecureRoom(a)); // false
        System.out.println(maze.isASecureRoom(b)); // true
        System.out.println(maze.isASecureRoom(c)); // false
        System.out.println(maze.isASecureRoom(d)); // false
        System.out.println(maze.isASecureRoom(e)); // true
    }
}
