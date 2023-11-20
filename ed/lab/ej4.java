package lab;

//1 2 3 4
//
//1 3 6 10
//1   4  8

public class ej4 {
    public static int sumatory(int n) {
        return (n * (n + 1)) / 2;
    }

    //    O(1)
    public static int whoIsMissingFaster(int[] students) {
        int total = sumatory(students.length + 1);
        int amount = 0;
        for (int student : students) amount += student;
        return total - amount;
    }

    // 1 2 3 4   6  7
    // 1 3 6 10  16 23

//    public static int whoIsMissing(int[] students) {
//        int lo = 0, hi = students.length - 1, m = -1;
//        boolean found = false;
//
//        while (lo <= hi && !found) {
//            m = (lo + hi) / 2;
//
//            if (students[m - 1] != students[m] - 1 && students[m] != students[m + 1] - 1)
//                found = true;
//            else if (sumatory(m + 1) < m)
//        }
//    }

    public static void main(String[] args) {
        System.out.println(whoIsMissingFaster(new int[]{1, 3, 4})); // 2
        System.out.println(whoIsMissingFaster(new int[]{1, 2, 4})); // 3
        System.out.println(whoIsMissingFaster(new int[]{1, 2, 3, 4, 6, 7})); // 5

    }
}
