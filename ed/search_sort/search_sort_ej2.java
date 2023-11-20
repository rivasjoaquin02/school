package search_sort;

import java.util.Arrays;

public class search_sort_ej2 {

    public static void main(String[] args) {

        System.out.println(isContained(
                "TENGO TODOS LOS CARACTERES".toCharArray(),
                "NAONDECN".toCharArray())); // true

        System.out.println(isContained(
                "TENGO TODOS LOS CARACTERES".toCharArray(),
                "NAONDECNZ".toCharArray())); // false

        System.out.println(isContained(
                "HELLO WORLD!".toCharArray(),
                "WOLD".toCharArray())); // true
    }

    private static boolean isContained(char[] baseString, char[] newString) {
        Arrays.sort(baseString);
        boolean isSubset = true;

        for (char c : newString) {
            if (!find(baseString, c)) {
                isSubset = false;
                break;
            }
        }

        return isSubset;
    }

    private static boolean find(char[] baseString, char c) {
        int lo = 0, hi = baseString.length - 1, m;
        boolean found = false;

        while (lo <= hi && !found) {
            m = (lo + hi) / 2;

            if (baseString[m] == c) found = true;
            if (baseString[m] > c) hi = m - 1;
            else lo = m + 1;
        }

        return found;
    }
}
