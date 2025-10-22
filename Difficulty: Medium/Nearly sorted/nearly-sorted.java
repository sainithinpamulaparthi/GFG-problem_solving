import java.util.*;

public class Solution {
    public static void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int n = arr.length;
        int index = 0;

        // Step 1: push first k+1 elements
        for (int i = 0; i < Math.min(k + 1, n); i++) {
            minHeap.add(arr[i]);
        }

        // Step 2: process remaining elements
        for (int i = k + 1; i < n; i++) {
            arr[index++] = minHeap.poll(); // place smallest
            minHeap.add(arr[i]);           // push next element
        }

        // Step 3: empty the heap
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4};
        int k = 2;
        nearlySorted(arr, k);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4]
    }
}
     
     
     
     