package twopointers;

/*
    Given an array heights where each element represents the height of a vertical line,
    pick two lines to act as the walls of a container. Return the maximum area (amount of water)
    the container can hold.
*/

public class ContainerMostWater {
    public Integer max_area(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;
        while (left < right) {
            int minHeight = Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, minHeight * (right - left));
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

}
