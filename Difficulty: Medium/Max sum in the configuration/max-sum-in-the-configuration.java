class Solution {
    int maxSum(int[] arr) {
        int n = arr.length;

        int arrSum = 0;   // sum of array elements
        int currVal = 0;  // value of i*arr[i] for current rotation

        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
            currVal += i * arr[i];
        }

        int maxVal = currVal;

        // Compute values for next rotations using formula
        for (int i = 1; i < n; i++) {
            currVal = currVal + arrSum - n * arr[n - i];
            maxVal = Math.max(maxVal, currVal);
        }

        return maxVal;
    }
}