// import java.util.*;

// class EquilibriumPoint {
//     static int findMaxSum(int[] arr, int n) {
//         int res = Integer.MIN_VALUE;

//         for (int i = 0; i < n; i++) {
//             int prefix_sum = arr[i];
//             for (int j = 0; j < i; j++) {
//                 prefix_sum += arr[j];
//             }

//             int suffix_sum = arr[i];
//             for (int j = n - 1; j > i; j--) {
//                 suffix_sum += arr[j];
//             }

//             if (prefix_sum == suffix_sum) {
//                 res = Math.max(res, prefix_sum);
//             }
//         }

//         return res;
//     }

//     public static void main(String[] args) {
//         Scanner s = new Scanner(System.in);

//         System.out.println("Enter size of the array");
//         int n = s.nextInt();
//         int[] arr = new int[n];

//         System.out.println("Enter elements of the array");
//         for (int i = 0; i < n; i++) {
//             arr[i] = s.nextInt();
//         }

//         System.out.println(findMaxSum(arr, n));
//         s.close();
//     }
// }



// -------------------------------------------------------------------------------------------------------------

public class EquilibriumPoint {
    static int findMaxSum(int[] arr, int n) {
        int[] preSum = new int[n];
        int[] suffSum = new int[n];
        int ans = Integer.MIN_VALUE;

        // Populate prefix sum array
        preSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }

        // Handle the last element for suffix sum
        suffSum[n - 1] = arr[n - 1];
        if (preSum[n - 1] == suffSum[n - 1]) {
            ans = Math.max(ans, preSum[n - 1]);
        }

        // Populate suffix sum array and check for matching sums
        for (int i = n - 2; i >= 0; i--) {
            suffSum[i] = suffSum[i + 1] + arr[i];
            if (suffSum[i] == preSum[i]) {
                ans = Math.max(ans, preSum[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 20, 10};
        int n = arr.length;

        System.out.println(findMaxSum(arr, n));
    }
}
