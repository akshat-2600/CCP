class Solution {
    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int maxLen = 0;

        while (j < n) {
            if (nums[j] == 1) {
                j++;
            } else {
                if (k > 0) {
                    k--;
                    j++;
                } else {
                    if (nums[i] == 0) {
                        k++;
                    }
                    i++;
                }
            }
            maxLen = Math.max(maxLen, j - i);
        }
        return maxLen;
    }

    public static void main(String[] args) {

        // Test Case 1
        int[] nums1 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k1 = 2;
        int result1 = longestOnes(nums1, k1);
        System.out.println("Test Case 1 Output: " + result1); // Expected: 6

        // Test Case 2
        int[] nums2 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k2 = 3;
        int result2 = longestOnes(nums2, k2);
        System.out.println("Test Case 2 Output: " + result2); // Expected: 10
    }
}
