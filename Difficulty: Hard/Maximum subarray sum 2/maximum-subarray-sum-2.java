//import java.util.*;

class Solution {
    public int maxSubarrSum(int[] arr, int a, int b) {
        int n = arr.length;
        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + arr[i];
        }

        // Deque to maintain candidate prefix sums (min)
        Deque<Integer> dq = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;

        for (int i = a; i <= n; i++) {
            // Add pref[i - a] into deque (window start candidate)
            while (!dq.isEmpty() && pref[dq.peekLast()] >= pref[i - a]) {
                dq.pollLast();
            }
            dq.addLast(i - a);

            // Remove indices < i - b
            while (!dq.isEmpty() && dq.peekFirst() < i - b) {
                dq.pollFirst();
            }

            // best sum ending at i-1
            ans = Math.max(ans, (int)(pref[i] - pref[dq.peekFirst()]));
        }

        return ans;
    }
}
