class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int flips = 0;        // result count
        int flipParity = 0;   // current flip parity (0 = even, 1 = odd)
        int[] isFlipped = new int[n];  // mark where a flip starts

        for (int i = 0; i < n; i++) {
            // Remove effect of expired flip (window length k)
            if (i >= k) {
                flipParity ^= isFlipped[i - k];
            }

            // If current bit after parity is 0, we must flip here
            if ((arr[i] ^ flipParity) == 0) {
                if (i + k > n) return -1; // not enough space for flip
                flips++;
                flipParity ^= 1;        // new flip toggles parity
                isFlipped[i] = 1;       // record flip start
            }
        }
        return flips;
    }
}
