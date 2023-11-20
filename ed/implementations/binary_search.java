package implementations;

public class binary_search {
    public static void main(String[] args) {
        int[] a1 = {1, 4, 6, 7, 77, 88, 122, 200};
        int[] a2 = {1, 3, 3, 4, 6, 7, 7, 8, 10};

//        System.out.println(BinarySearch.search(a1, 77)); //4
//        System.out.println(BinarySearch.search(a1, 77)); //4
//        System.out.println(BinarySearch.search(a1, 1)); //0
//        System.out.println(BinarySearch.search(a1, 122)); //6
//        System.out.println(BinarySearch.search(a1, 200)); //7
//
//        System.out.println(BinarySearch.search(a2, 3)); //1
//        System.out.println(BinarySearch.search(a2, 8)); //7
//        System.out.println(BinarySearch.search(a2, 10)); //8
//
//        System.out.println(BinarySearch.search(a2, 4)); //3
//        System.out.println(BinarySearch.first_equal(a2, 4)); //3

        /* amount common elements */
        System.out.println(
                BinarySearch.unionArray(
                        new int[]{200, 7, 77, 122, 4, 88, 6, 1},
                        new int[]{3, 4, 3, 6, 1, 8, 7, 10, 7}
                )); // 4 = 1, 4, 6, 7

        /* if theres is elements between some range */
        System.out.println(BinarySearch.between_range_without_rep(a1, 5, 8)); //true
        System.out.println(BinarySearch.between_range_without_rep(a1, 4, 5)); //false
        System.out.println(BinarySearch.between_range_without_rep(a1, 77, 123)); //true
        System.out.println(BinarySearch.between_range_without_rep(a2, 2, 2)); //false
        System.out.println(BinarySearch.between_range_without_rep(a2, 7, 11)); //true
    }
}
