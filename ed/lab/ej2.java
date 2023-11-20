package lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Client {
    protected int id;
    protected String name;
    protected boolean isVIP;

    public Client(int id, String name, boolean isVIP) {
        this.id = id;
        this.name = name;
        this.isVIP = isVIP;
    }
}

class Hotel {
    protected List<Client> clients;

    public Hotel(List<Client> clients) {
        this.clients = clients;
    }

    private boolean findId(int[] ids, int id) {
        int lo = 0, hi = clients.size() - 1, m = -1;
        boolean found = false;

        while (lo <= hi && !found) {
            m = (lo + hi) / 2;

            if (ids[m] == id)
                found = true;
            else if (ids[id] > id)
                hi = m - 1;
            else lo = m + 1;
        }

        return found;
    }

    public void modifyVIPs(int[] ids, boolean[] newVIP) {
        Arrays.sort(ids);

        for (int i = 0; i < clients.size(); i++) {
            if (findId(ids, clients.get(i).id))
                clients.get(i).isVIP = newVIP[i];
        }
    }
}

public class ej2 {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(
                new ArrayList<>(
                        List.of(
                                new Client(2, "b", false),
                                new Client(1, "a", true),
                                new Client(4, "d", false),
                                new Client(3, "c", true)
                        ))
        );

        hotel.modifyVIPs(new int[]{1, 2, 3, 4}, new boolean[]{false, true, false, true});


    }
}
