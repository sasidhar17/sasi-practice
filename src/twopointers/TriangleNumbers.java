package twopointers;

import java.util.Arrays;

public class TriangleNumbers {
    public static Integer triangleNumber(int[] nums) {
        int count = 0;
        if (nums == null || nums.length == 0) {
            return count;
        }
        Arrays.sort(nums);

        for (int end = nums.length - 1; end >= 2; end--) {
            int left = 0;
            int right = end - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[end]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[] {11,4,9,6,15,18}));
    }

}
