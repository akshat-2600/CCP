import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        if (n == 0 || k == 0) return new int[0];

        Deque<Integer> deq = new ArrayDeque<>();
        int[] result = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            // Step1 : Make space for nums[i] by removing out of bounds indices
            while (!deq.isEmpty() && deq.peekFirst() <= i - k) {
                deq.pollFirst();
            }

            // Step2 : Remove smaller elements from the back as they are useless
            while (!deq.isEmpty() && nums[i] > nums[deq.peekLast()]) {
                deq.pollLast();
            }

            // Step3 : Add cuurent element idx to the back
            deq.offerLast(i);

            // Step4 : Once the window hits size k, add the maximum to the result
            if (i >= k - 1) {
                result[idx++] = nums[deq.peekFirst()];
            }
        }
        return result;
    }
}