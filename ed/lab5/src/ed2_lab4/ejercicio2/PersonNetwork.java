package src.ed2_lab4.ejercicio2;

import java.util.List;

public class PersonNetwork {
    private final List<Person> people;
    private final List<List<Integer>> friends;

    public PersonNetwork(List<Person> people, List<List<Integer>> friends) {
        this.people = people;
        this.friends = friends;
    }

    public List<String> friendsInCommon(Person p1, Person p2) {
        int idxP1 = people.indexOf(p1);
        int idxP2 = people.indexOf(p2);

        List<Integer> friendsP1 = friends.get(idxP1);
        List<Integer> friendsP2 = friends.get(idxP2);

        return friendsP1
                .stream()
                .filter(friendsP2::contains)
                .map(idxFriendInCommon -> people.get(idxFriendInCommon).email)
                .toList();
    }

    public boolean hasYoungFriends(Person person) {
        int MAX_AGE = 19;
        int idxPerson = people.indexOf(person);

        return friends
                .get(idxPerson)
                .stream()
                .anyMatch(idxFriend -> people.get(idxFriend).age < MAX_AGE);
    }

    public int amountPersonsWithKFriends(int k) {
//        todo: dangerous to cast a long into a int: JAVA BE LIKE
        return (int) friends
                .stream()
                .filter(friends -> friends.size() == k)
                .count();
    }

    @Override
    public String toString() {
        return "PersonNetwork{" +
                "people=" + people +
                ", friends=" + friends +
                '}';
    }


}
