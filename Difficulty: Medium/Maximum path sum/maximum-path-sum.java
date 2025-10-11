/*
class Node{
    int data;
    Node left, right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    int maxSum;
    int findMaxSum(Node root) {
        // code here
        maxSum=Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }
    int helper(Node node){
        if(node==null)
        return 0;
        int left=Math.max(0,helper(node.left));
        int right=Math.max(0,helper(node.right));
        maxSum=Math.max(maxSum,left+right+node.data);
        return node.data+Math.max(left,right);
        }
}