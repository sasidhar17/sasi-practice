package twopointers;

public class TrappingRainWater {

    /*
    Write a function to calculate the total amount of water trapped between bars on an elevation map,
    where each bar's width is 1. The input is given as an array of n non-negative integers height
    representing the height of each bar.
     */

    public static int trappingWater(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        int result = 0;

        int left = 0;
        int right = heights.length - 1;
        int leftMax = heights[0];
        int rightMax = heights[heights.length - 1];

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                if (heights[left] >= leftMax) {
                    leftMax = heights[left];
                } else {
                    result += leftMax - heights[left];
                }
            } else {
                right--;
                if(heights[right] >= rightMax) {
                    rightMax = heights[right];
                } else {
                    result += rightMax - heights[right];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(trappingWater(new int[] {3, 4, 1, 2, 2, 5, 1, 0, 2}));
    }
}
