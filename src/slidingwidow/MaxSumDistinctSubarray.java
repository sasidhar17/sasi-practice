package slidingwidow;

/*
    Given an integer array nums and an integer k, write a function to identify
    the highest possible sum of a subarray within nums,
    where the subarray meets the following criteria: its length is k,
    and all of its elements are unique. If no such subarray exists, return 0.

    Example 1: Input:
    nums = [3, 2, 2, 3, 4, 6, 7, 7, -1]
    k = 4

    Output:
    20
 */

import java.util.HashSet;

public class MaxSumDistinctSubarray {
    public static long maxSum(int[] nums, Integer k) {
        HashSet<Integer> seen = new HashSet<>();
        long sum = 0;
        long maxSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while(seen.contains(nums[right])) {
                sum -= nums[left];
                seen.remove(nums[left++]);
                left++;
            }

            seen.add(nums[right]);
            sum += nums[right];

            // Keep window size at most k.
            while (right - left + 1 > k) {
                seen.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            // Only consider windows of exactly k elements.
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, sum);
            }

        }

        return maxSum;
    }
}
