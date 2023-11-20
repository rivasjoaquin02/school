package search_sort;

import java.util.ArrayList;
import java.util.List;

public class a_subset_of_b {

    public static boolean find(List<Integer> arr, int v) {
        int lo = 0, hi = arr.size() - 1, m;
        boolean found = false;

        while (lo <= hi && !found) {
            m = (lo + hi) / 2;

            if (arr.get(m) == v) found = true;
            if (arr.get(m) > v) hi = m - 1;
            else lo = m + 1;
        }

        return found;
    }

    //    O(nlogn)
    public static boolean isASubsetOfB(List<Integer> a, List<Integer> b) {
        b.sort((n0, n1) -> n0 - n1);
        boolean isSubset = true;

        for (int v : a)
            if (!find(b, v))
                isSubset = false;

        return isSubset;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(List.of(1, 4, 3, 2, 5, 6, 3));
        List<Integer> b = new ArrayList<>(List.of(1, 4, 3, 2, 5, 6, 3));
        List<Integer> c = new ArrayList<>(List.of(7, 8, 9));

        System.out.println(isASubsetOfB(a, b)); // true
        System.out.println(isASubsetOfB(a, c)); // false
        System.out.println(isASubsetOfB(b, c)); // false
    }
}
