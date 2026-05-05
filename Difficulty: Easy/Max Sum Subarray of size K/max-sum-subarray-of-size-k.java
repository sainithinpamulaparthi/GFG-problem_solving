class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int ws=0;
        for(int i=0;i<k;i++){
            ws += arr[i];
        }
        int max = ws;
        for(int i=k;i<arr.length;i++){
            ws = ws -arr[i-k] + arr[i];
            max = Math.max(ws,max);
        }
        return max;
    }
}