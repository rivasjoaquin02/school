package implementations;

import java.util.ArrayList;
import java.util.List;

// O(n^2) - stable
public class InsertionSort {
    static void sort(ArrayList<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (arr.get(i) <= arr.get(j)) {
                    int elem = arr.remove(i);
                    arr.add(j, elem);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(2, 3, 1, 5, 6, 8, 4));
        ArrayList<Integer> arr2 = new ArrayList<>(List.of(5, 3, 2, 1, 7, -4, -2));
        ArrayList<Integer> arr3 = new ArrayList<>(List.of(-1, -2, -3, -7));

        sort(arr);
        sort(arr2);
        sort(arr3);

        System.out.println(arr);
        System.out.println(arr2);
        System.out.println(arr3);
    }
}
