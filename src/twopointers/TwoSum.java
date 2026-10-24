package twopointers;

/*
    Given a sorted array of integers nums, determine if there exists a pair of numbers
    that sum to a given target.

    nums = [1,3,4,6,8,10,13]
    target = 13
 */

import java.util.Stack;

public class TwoSum {
    public static boolean twoSum(int[] nums, Integer target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return true;
            }
            if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}
