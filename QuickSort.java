import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    // Time complexity -> O(n log n) average & best case, O(n^2) worst case
    // Space complexity -> O(log n) auxiliary stack space
    public static int partition(List<Integer> arr, int st, int end) {
        int idx = st - 1;
        int pivot = arr.get(end);

        for (int j = st; j < end; j++) {
            if (arr.get(j) <= pivot) { // for descending change sign >=
                idx++;
                // Swap arr.get(j) and arr.get(idx)
                int temp = arr.get(j);
                arr.set(j, arr.get(idx));
                arr.set(idx, temp);
            }
        }

        idx++;
        // Swap pivot element into correct position
        int temp = arr.get(end);
        arr.set(end, arr.get(idx));
        arr.set(idx, temp);

        return idx;
    }

    public static void quickSort(List<Integer> arr, int st, int end) {
        if (st < end) {
            int pivIdx = partition(arr, st, end);
            quickSort(arr, st, pivIdx - 1); // left half
            quickSort(arr, pivIdx + 1, end); // right half
        }
    }

    public static void main(String[] args) {
        // Using an ArrayList to mimic C++ vector behavior
        List<Integer> arr = new ArrayList<>(Arrays.asList(12, 31, 35, 8, 32, 17));  // arr.add(12) // arr.add(31) ...

        quickSort(arr, 0, arr.size() - 1);

        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
