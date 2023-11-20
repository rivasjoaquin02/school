package implementations;

import java.util.Arrays;

// O(n^2) - no stable
public class SelectionSort {
    static void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int min_pos = i;

            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_pos = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[min_pos];
            arr[min_pos] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 5, 6, 8, 4};
        int[] arr2 = new int[]{5, 3, 2, 1, 7, -4, -2};
        int[] arr3 = new int[]{-1, -2, -3, -7};

        sort(arr);
        sort(arr2);
        sort(arr3);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }
}
