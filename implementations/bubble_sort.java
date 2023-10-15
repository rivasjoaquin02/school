package implementations;

import java.util.Arrays;

class BubbleSort {
    static void sort_normal(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    static void sort_with_new_swap(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                }
        ;
    }

    static void sort_with_stop(int[] arr) {
        boolean stop = false;
        for (int i = 1; i <= arr.length - 1 && !stop; i++) {
            stop = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                    stop = false;
                }
            }
        }
    }

    static void sort_with_xor(int[] arr) {
        boolean stop = false;
        for (int i = 1; i <= arr.length - 1 && !stop; i++) {
            stop = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                    stop = false;
                }
            }
        }
    }
}

class bubble_sort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 3, 7, 5, 15, 6, 8, 8, 9, 1, 2};
        int[] arr2 = {5,3,2,1,7,-4,-2};
        int[] arr3 = {-1, -2, -3,-7};

        BubbleSort.sort_with_xor(arr);
        BubbleSort.sort_with_xor(arr2);
        BubbleSort.sort_with_xor(arr3);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }
}
