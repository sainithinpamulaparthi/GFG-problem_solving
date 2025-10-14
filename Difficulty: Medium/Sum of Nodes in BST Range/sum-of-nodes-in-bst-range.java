class Solution {
    public int nodeSum(Node root, int l, int r) {
        if (root == null) return 0;
        
        // If current node value is less than l, skip left subtree
        if (root.data < l)
            return nodeSum(root.right, l, r);
        
        // If current node value is greater than r, skip right subtree
        if (root.data > r)
            return nodeSum(root.left, l, r);
        
        // Node lies in range, include it and explore both sides
        return root.data + nodeSum(root.left, l, r) + nodeSum(root.right, l, r);
    }
}
