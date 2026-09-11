public class MaxSubarraySumBrute {
    public static int findMaxSum(int[] arr, int k) {
        int n = arr.length;
        // Edge case: if window size is greater than array length
        if (n < k || k <= 0) {
            return -1; 
        }

        int maxSum = Integer.MIN_VALUE;

        // Loop through all possible starting points of a window of size K
        for (int i = 0; i <= n - k; i++) {
            int currentSum = 0;
            
            // Calculate sum for the current window
            for (int j = i; j < i + k; j++) {
                currentSum += arr[j];
            }
            
            // Track the maximum sum seen so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Brute Force Max Sum: " + findMaxSum(arr, k)); // Output: 9 (from)
    }
}

// ---------------------------------------------------------------------------------------------------------

public class MaxSubarraySumSlidingWindow {
    public static int findMaxSum(int[] arr, int k) {
        int n = arr.length;
        if (n < k || k <= 0) {
            return -1;
        }

        int i = 0; // Left pointer of the window
        int j = 0; // Right pointer of the window
        int currentWindowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        // Run exactly one while loop until the right pointer finishes traversal
        while (j < n) {
            // 1. Expand the window by adding the element at the right pointer
            currentWindowSum += arr[j];

            // 2. Check if the window size has reached exactly size k
            if ((j - i + 1) == k) {
                // Update the maximum sum found so far
                maxSum = Math.max(maxSum, currentWindowSum);
                
                // Shrink the window from the left before moving forward
                currentWindowSum -= arr[i];
                i++; // Move left pointer forward
            }

            j++; // Move right pointer forward to expand next cycle
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Sliding Window Max Sum: " + findMaxSum(arr, k)); // Output: 9
    }
}


// ---------------------------------------------------------------------------------------------------------


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if (s == "") {
            return 0;
        }
        int i = 0;
        int j = 0;
        int ans = INT_MIN;
        unordered_map<char, int> mp;
        while (j < s.size()) {
            mp[s[j]]++;

            if (mp.size() == j-i+1) {
                ans = max(ans, j-i+1);
                j++;
            }
            else if (mp.size() < j-i+1) {
                while (mp.size() < j-i+1) {
                    mp[s[i]]--;
                    if (mp[s[i]] == 0) {
                        mp.erase(s[i]);
                    }
                    i++;
                }
                j++;
            }
        }
        return ans;
    }
};


// ------------------------------------------------------------------------------------------------


