class Solution {
    public int findMedian(Node root) {
        // Step 1: get inorder traversal
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);

        int n = inorderList.size();

        // Step 2: find median based on count
        if (n % 2 == 1)
            return inorderList.get(n / 2);           // odd → middle element
        else
            return inorderList.get((n / 2) - 1);     // even → (n/2)th element (1-based)
    }

    private void inorder(Node root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
}
