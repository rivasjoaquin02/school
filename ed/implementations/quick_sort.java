package implementations;

import java.util.ArrayList;
import java.util.List;

class QuickSort {
    static void swap(Integer a, Integer b) {
        a = a + b;
        b = a - b;
        a = a - b;
    }

    static void sort(List<Integer> arr, int l, int h) {
        if (l < h) {
            int pivot = partition(arr, l, h);
            sort(arr, l, pivot - 1);
            sort(arr, pivot + 1, h);
        }
    }

    static int partition(List<Integer> arr, int l, int h) {
        int pivot = h - 1;

        //pos where the elements lower than pivot will be placed
        int i = 0;

        for (int k = l; k < h; k++) {
            if (arr.get(k) <= arr.get(pivot)) {
//                swap
                arr.set(i, arr.get(i) + arr.get(k));
                arr.set(k, arr.get(i) - arr.get(k));
                arr.set(i, arr.get(i) - arr.get(k));

                i++;
            }
        }
        arr.set(i, arr.get(i) + arr.get(pivot));
        arr.set(pivot, arr.get(i) - arr.get(pivot));
        arr.set(i, arr.get(i) - arr.get(pivot));

        return i + 1;
    }
}

public class quick_sort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(4, 3, 2, 3, 7, 5, 15, 6, 8, 8, 9, 1, 2));
        ArrayList<Integer> arr2 = new ArrayList<>(List.of(5, 3, 2, 1, 7, -4, -2));
        ArrayList<Integer> arr3 = new ArrayList<>(List.of(-1, -2, -3, -7));

        int a = 10;
        int b = 5;

        QuickSort.sort(arr, 0, arr.size());
//        QuickSort.sort(arr2, 0, arr2.size());
//        QuickSort.sort(arr3, 0, arr3.size());
//
//        System.out.println(arr);
//        System.out.println(arr2);
//        System.out.println(arr3);
    }
}
