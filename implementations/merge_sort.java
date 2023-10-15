package implementations;

class MergeSort {
    static void sort (int [] arr, int l, int h) {
//        if (arr.length == 1) return arr;
        if (arr.length == 2){

        }


        int m = (l + h) / 2;
        sort(arr, l, m);
        sort(arr, m + 1, h);
    }

    static void merge(  ) {}
}

public class merge_sort {
    public static void main(String[] args) {

    }

}
