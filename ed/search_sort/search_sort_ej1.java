package search_sort;

import java.util.ArrayList;
import java.util.List;

public class search_sort_ej1 {

    //    O(nlogn) + O(nlogn + logn) = O(nlogn)
    static List<Integer> intersectionWithoutReps(List<Integer> a, List<Integer> b) {
        a.sort((n0, n1) -> n0 - n1);

        List<Integer> intersection = new ArrayList<>();

        for (int v : b)
            if (find(a, v) && !find(intersection, v))
                intersection.add(v);

        return intersection;
    }

    private static boolean find(List<Integer> a, int v) {
        int lo = 0, hi = a.size() - 1, m;
        boolean found = false;

        while (lo <= hi && !found) {
            m = (lo + hi) / 2;

            if (a.get(m) == v) found = true;
            if (a.get(m) > v) hi = m - 1;
            else lo = m + 1;
        }

        return found;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(List.of(2, 3, 1, 2));
        List<Integer> b = new ArrayList<>(List.of(2, 2, 3, 4));
        List<Integer> c = new ArrayList<>(List.of(5, 1, 3, 6, 1, 2));

        System.out.println(intersectionWithoutReps(a, b)); //[2, 3]
        System.out.println(intersectionWithoutReps(a, c)); //[1, 3, 3]
        System.out.println(intersectionWithoutReps(b, c)); //[3, 2]
    }
}
