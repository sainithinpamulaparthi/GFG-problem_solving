class Solution {
    static int sum = 0;
    
    public static void transformTree(Node root) {
        sum = 0;
        helper(root);
    }
    
    static void helper(Node root) {
        if (root == null) return;
        
        // Traverse right subtree first (greater values)
        helper(root.right);
        
        // Store original value
        int val = root.data;
        
        // Replace current node with sum of greater nodes
        root.data = sum;
        
        // Update sum
        sum += val;
        
        // Traverse left subtree (smaller values)
        helper(root.left);
    }
}
