// import java.util.*;

// public class BlockSwapAlgorithm {

//     // Swap two equal-sized blocks
//     static void swap(int arr[], int first, int second, int size) {
//         for (int i = 0; i < size; i++) {
//             int temp = arr[first + i];
//             arr[first + i] = arr[second + i];
//             arr[second + i] = temp;
//         }
//     }

//     static void blockSwap(int arr[], int start, int d, int n) {

//         // No rotation
//         if (d == 0 || d == n)
//             return;

//         // A == B
//         if (d == n - d) {
//             swap(arr, start, start + d, d);
//             return;
//         }

//         // A < B
//         if (d < n - d) {

//             // A | BL | BR
//             // Swap A and BL
//             swap(arr, start, start + d, d);

//             // Solve A | BR
//             blockSwap(arr, start + d, d, n - d);
//         }

//         // A > B
//         else {

//             int sizeB = n - d;

//             // AL | AR | B
//             // Swap AR and B
//             swap(arr, start + d - sizeB, start + d, sizeB);

//             // Solve AL | B
//             blockSwap(arr, start, d - sizeB, d);
//         }
//     }

//     public static void main(String args[]) {

//         int arr[] = {10, 20, 30, 40, 50, 60, 70};

//         int d = 3;

//         blockSwap(arr, 0, d, arr.length);

//         System.out.println(Arrays.toString(arr));
//     }
// }


// // -----------------------------------------------------------------------------------------------------

// public class BlockSwapAlgorithm {

//     public static void rotateToLeft(int[] arr, int n, int k, int[] temp) {
//         if (n == 0) return;
        
//         k = k % n;
//         int idx = 0;
        
//         for (int i = k; i < n; i++) {
//             temp[idx] = arr[i];
//             idx++;
//         }

//         for (int i = 0; i < k; i++) {
//             temp[idx] = arr[i];
//             idx++;
//         }
//     }

//     public static void main(String[] args) {
//         int n = 7;
//         int[] arr = {1, 2, 3, 4, 5, 6, 7};
//         int k = 2;
//         int[] temp = new int[n];

//         rotateToLeft(arr, n, k, temp);

//         System.out.println("After Rotating the elements to left: ");
//         for (int i = 0; i < n; i++) {
//             System.out.print(temp[i] + " ");
//         }
//     }
// }


// --------------------------------------------------------------------------------------------------------

public class BlockSwapAlgorithm {

    public static void rotateArray(int[] arr, int d) {
        int n = arr.length;
        d = d % n;
        
        if (d == 0) {
            return;
        }

        // Reversal Algorithm Steps
        swap(arr, 0, d - 1);
        swap(arr, d, n - 1);
        swap(arr, 0, n - 1);
    }

    public static void swap(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70};
        int rotations = 3;

        rotateArray(arr, rotations);

        System.out.println("Rotated array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
