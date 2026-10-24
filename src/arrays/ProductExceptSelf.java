package arrays;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {

        int[] array = {1, 4, 9, 5, 2};
        int[] result = productExceptSelf(array);
        System.out.printf("answer -> " + Arrays.toString(result));

    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Step 1: Calculate Prefix Products
        // res[i] will contain the product of all elements to the left of i
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate Suffix Products on the fly
        // We use a single variable 'right' to track the product from the right
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }

        return res;
    }
}
