package slidingwidow;

public class MaxSubArray {

    public static int maxSubarraySum(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            windowSum += nums[end];

            if (end - start + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[start];
                start++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{2, 1, 5, 1, 3, 2},3));
    }

}
