package implementations;

import java.util.ArrayList;
import java.util.List;

class SelectionSort {
    static void sort(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            int min = arr.get(i);
            int min_idx = i;
            for (int j = i; j < arr.size(); j++) {
                if (min < arr.get(j)) {
                    min = arr.get(j);
                    min_idx = j;
                }
            }
            int elem = arr.remove(min_idx);
//            arr.addFirst(elem);
        }
    }
}

public class selection_sort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(2, 3, 1, 5, 6, 8, 4));
        ArrayList<Integer> arr2 = new ArrayList<>(List.of(5, 3, 2, 1, 7, -4, -2));
        ArrayList<Integer> arr3 = new ArrayList<>(List.of(-1, -2, -3, -7));

        SelectionSort.sort(arr);
        SelectionSort.sort(arr2);
        SelectionSort.sort(arr3);

        System.out.println(arr);
        System.out.println(arr2);
        System.out.println(arr3);
    }
}
