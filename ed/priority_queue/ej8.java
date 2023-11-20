package priority_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Lugar implements Comparable<Lugar> {
    protected String name;
    protected int popularity;
    protected int frequency;
    protected String trend;

    public Lugar(String name, int popularity, int frequency, String trend) {
        this.name = name;
        this.popularity = popularity;
        this.frequency = frequency;
        this.trend = trend;
    }

    @Override
    public int compareTo(Lugar lugar) {
        if ((this.popularity + this.frequency) > (lugar.popularity + lugar.frequency))
            return 1;
        if ((this.popularity + this.frequency) < (lugar.popularity + lugar.frequency))
            return -1;
        return 0;
//        return (this.popularity + this.frecuency) - (lugar.popularity + lugar.frecuency);
    }
}

public class ej8 {
    protected List<Lugar> places;

    public ej8(List<Lugar> places) {
        this.places = places;
    }

    public List<Lugar> topK(int k) {
        PriorityQueue<Lugar> bestPlaces = new PriorityQueue<>(places);
        List<Lugar> bestKPlaces = new ArrayList<>();

        for (int i = 0; i < k; i++)
            bestKPlaces.add(bestPlaces.poll());

        return bestKPlaces;
    }
}
