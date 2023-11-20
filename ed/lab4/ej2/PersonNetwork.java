package ed2_lab4.ej2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonNetwork {
    private final List<Person> people;
    private final boolean[][] friendships;

    public List<String> friendsInCommon(Person p1, Person p2) {
        List<String> commonFriends = new ArrayList<>();

        int idxP1 = people.indexOf(p1);
        int idxP2 = people.indexOf(p2);

        for (int i = 0; i < people.size(); i++)
            if (friendships[idxP1][i] && friendships[idxP2][i])
                commonFriends.add(people.get(i).name);

        return commonFriends;
    }

    public boolean hasYoungFriends(Person person) {
        int amountYoungFriends = 0;
        int idx = people.indexOf(person);

        for (int i = 0; i < people.size(); i++) {
            int age = people.get(i).age;
            if (friendships[idx][i] && 15 <= age && age <= 35) amountYoungFriends++;
        }

        return amountYoungFriends > 1;
    }

    public int amountPersonsWithKFriends(int k) {
        int amountPersons = 0;

        for (int i = 0; i < people.size(); i++) {
            int amountFriends = 0;
            for (int j = 0; j < people.size(); j++)
                if (friendships[i][j]) amountFriends++;

            if (amountFriends == k) amountPersons++;
        }
        return amountPersons;
    }


    /***************************************/

    public PersonNetwork(List<Person> people, boolean[][] friendships) {
        this.people = people;
        this.friendships = friendships;
    }

    @Override
    public String toString() {
        return "PersonNetwork{" +
                "people=" + people +
                ", friendships=" + Arrays.toString(friendships) +
                '}';
    }
}
