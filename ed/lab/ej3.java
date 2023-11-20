package lab;

public class ej3 {
    private static boolean sumaValores(int[] arr, int sum) {
        for (int i = 0; i < arr.length / 2; i++) {
            int needed = Math.abs(sum - arr[i]);

            if (binarySearch(arr, needed))
                return true;
        }
        return false;
    }

    private static boolean binarySearch(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1, m = -1;
        boolean found = false;

        while (lo <= hi && !found) {
            m = (lo + hi) / 2;

            if (arr[m] == x)
                found = true;
            else if (arr[m] > x)
                hi = m - 1;
            else lo = m + 1;
        }
        return found;
    }

    public static void main(String[] args) {
        System.out.println(sumaValores(new int[]{1, 5, 7, 7, 9, 45, 155}, 156)); //true
        System.out.println(sumaValores(new int[]{1, 5, 7, 7, 9, 45, 155}, 11)); //false
        System.out.println(sumaValores(new int[]{1, 5, 7, 7, 9, 45, 155}, 12)); //true
    }
}
