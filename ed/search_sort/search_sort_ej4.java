package search_sort;

import java.util.Arrays;

public class search_sort_ej4 {

    public static int lowerInRange(int[] arr, int left, int right) {
        Arrays.sort(arr);

        int lo = 0, hi = arr.length - 1, m;
        while (lo < hi) {
            m = (lo + hi) / 2;

            if (arr[m] < left) lo = m + 1;
            else if (arr[m] >= left) hi = m;
        }
        return left <= arr[lo] && arr[lo] <= right
                ? arr[lo]
                : -1;
    }

    public static void main(String[] args) {
        System.out.println(lowerInRange(new int[]{1, 5, 4, 3, 66, 32, 11, 89}, 30, 35)); // 32
        System.out.println(lowerInRange(new int[]{1, 5, 4, 3, 66, 32, 11, 89}, 5, 12)); // 5
        System.out.println(lowerInRange(new int[]{1, 5, 4, 3, 66, 32, 11, 89}, 67, 87)); // -1
        System.out.println(lowerInRange(new int[]{1, 5, 4, 3, 66, 32, 11, 89}, 2, 6)); // 3
    }
}
