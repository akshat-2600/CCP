// import java.util.Scanner;

// public class maxProduct {
//     public static void main(String[] args) {
//         Scanner s = new Scanner(System.in);

//         // Input array size
//         System.out.println("Enter size of the array");
//         int n = s.nextInt();
//         int[] arr = new int[n];

//         // Input array elements
//         System.out.println("Enter elements of the array");
//         for (int i = 0; i < n; i++) {
//             arr[i] = s.nextInt();
//         }

//         int prefix = 1;
//         int suffix = 1;
//         int ans = 1;

//         // Calculate maximum product subarray
//         for (int i = 0; i < n; i++) {
//             if (prefix == 0) {
//                 prefix = 1;
//             }
//             if (suffix == 0) {
//                 suffix = 1;
//             }

//             prefix = prefix * arr[i];
//             suffix = suffix * arr[n - i - 1];

//             ans = Math.max(ans, Math.max(prefix, suffix));
//         }

//         System.out.println(ans);
//         s.close();
//     }
// }

// -------------------------------------------------------------------------------------------------------------------

// class maxProduct {
//     static int maxSubarrayProduct(int arr[], int n) {
//         int max_ending_here = arr[0];
//         int min_ending_here = arr[0];
//         int max_so_far = arr[0];

//         for (int i = 1; i < n; i++) {
//             // Store max temporarily because it is needed to calculate min_ending_here
//             int temp = Math.max(Math.max(arr[i], arr[i] * max_ending_here), arr[i] * min_ending_here);

//             min_ending_here = Math.min(Math.min(arr[i], arr[i] * max_ending_here), arr[i] * min_ending_here);

//             max_ending_here = temp;
//             max_so_far = Math.max(max_so_far, max_ending_here);
//         }

//         return max_so_far;
//     }

//     public static void main(String args[]) {
//         int[] arr = { 1, -2, -3, 0, 7, -8, -2 };
//         int n = arr.length;

//         System.out.printf("Maximum Sub array product is %d", maxSubarrayProduct(arr, n));
//     }
// }


// --------------------------------------------------------------------------------------------------------------

import java.util.*;

public class maxProduct {
    public static int maxProduct(List<Integer> nums) {
        if (nums.size() == 0) {
            return 0;
        }

        int maxSoFar = nums.get(0);
        int minSoFar = nums.get(0);
        int result = maxSoFar;

        for (int i = 1; i < nums.size(); i++) {
            int curr = nums.get(i);

            // Store max temporarily because it is needed to calculate minSoFar
            int tempMax = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            
            minSoFar = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));
            maxSoFar = tempMax;

            result = Math.max(maxSoFar, result);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 5, -15, 39);
        int maxProduct = maxProduct(nums);

        System.out.println("Max Product: " + maxProduct);
    }
}
