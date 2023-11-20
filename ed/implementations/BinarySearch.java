package implementations;

import java.util.Arrays;

public class BinarySearch {
    static int search(int[] arr, int elem) {
        int lo = 0;
        int hi = arr.length - 1;
        boolean found = false;
        int pos = -1;

        while (lo <= hi && !found) {
            int m = (lo + hi) / 2;

            if (arr[m] == elem) {
                found = true;
                pos = m;
            } else if (arr[m] < elem)
                lo = m + 1;
            else hi = m - 1;
        }

        return pos;
    }

    static int first_equal(int[] arr, int elem) {
        int lo = 0, hi = arr.length - 1, m = 0;

        while (lo < hi) {
            m = (lo + hi) / 2;

            if (arr[m] >= elem)
                hi = m;
            else lo = m + 1;
        }

        return arr[m] == elem
                ? m
                : -1;
    }

    static int unionArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr1); //merge -> stable

        int amount = 0;
        for (int elem : arr2) if (BinarySearch.search(arr1, elem) > 0) amount++;

        return amount;
    }

    static boolean between_range_without_rep(int[] arr, int left, int right) {
        int lo = 0, hi = arr.length - 1, m = 0;
        boolean found = false;

        while (lo < hi && !found) {
            m = (lo + hi) / 2;

            if (arr[m] == left) found = true;
            else if (left < arr[m]) hi = m - 1;
            else lo = m + 1;
        }

        return left < arr[m + 1] && arr[m + 1] < right;
    }
}
