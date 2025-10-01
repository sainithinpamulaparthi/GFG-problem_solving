import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        Arrays.sort(arr); // start with smallest permutation
        
        do {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int x : arr) temp.add(x);
            result.add(temp);
        } while (nextPermutation(arr)); // keep generating next permutations
        
        return result;
    }
    
    // Function to generate next lexicographic permutation
    private static boolean nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 2;
        
        // 1. Find rightmost element smaller than its next
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i < 0) return false; // no more permutations
        
        // 2. Find element just larger than arr[i]
        int j = n - 1;
        while (arr[j] <= arr[i]) j--;
        
        // 3. Swap
        swap(arr, i, j);
        
        // 4. Reverse the suffix
        reverse(arr, i + 1, n - 1);
        
        return true;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
    }
}
