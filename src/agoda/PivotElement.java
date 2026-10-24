package agoda;

class PivotElement {

    static int findElement(int[] arr) {
        int n = arr.length;

        // leftMax[i] stores maximum of arr[0..i]
        int[] leftMax = new int[n];
        leftMax[0] = arr[0];

        // Fill leftMax[1..n-1]
        for (int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);

        // rightMin[i] stores minimum of arr[i..n - 1]
        int[] rightMin = new int[n];
        rightMin[n - 1] = arr[n - 1];

        // Fill rightMin[1..n-1]
        for (int i = n - 2; i >= 0; i--)
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);

        // Check if we found a required element
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] >= leftMax[i] && arr[i] <= rightMin[i]) {
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 3, 6, 8, 10, 7, 9};
        System.out.println(findElement(arr));
    }
}