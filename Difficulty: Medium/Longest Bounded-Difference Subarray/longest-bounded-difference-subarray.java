import java.util.*;

class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        int n = arr.length;
        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();
        
        int l = 0, bestL = 0, bestLen = 0;
        
        for (int r = 0; r < n; r++) {
            // maintain decreasing deque for max
            while (!maxD.isEmpty() && arr[maxD.peekLast()] < arr[r])
                maxD.pollLast();
            maxD.addLast(r);
            
            // maintain increasing deque for min
            while (!minD.isEmpty() && arr[minD.peekLast()] > arr[r])
                minD.pollLast();
            minD.addLast(r);
            
            // shrink window if condition breaks
            while (!maxD.isEmpty() && !minD.isEmpty() && arr[maxD.peekFirst()] - arr[minD.peekFirst()] > x) {
                if (maxD.peekFirst() == l) maxD.pollFirst();
                if (minD.peekFirst() == l) minD.pollFirst();
                l++;
            }
            
            // update best result
            if (r - l + 1 > bestLen) {
                bestLen = r - l + 1;
                bestL = l;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = bestL; i < bestL + bestLen; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
