class Solution {
    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);

        // Sort based on absolute difference, then by value
        Collections.sort(inorder, (a, b) -> {
            int diffA = Math.abs(a - target);
            int diffB = Math.abs(b - target);
            if (diffA == diffB) return a - b; // smaller value first if same diff
            return diffA - diffB;
        });

        // Pick first k elements
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++)
            res.add(inorder.get(i));

        return res;
    }

    private void inorderTraversal(Node root, ArrayList<Integer> inorder) {
        if (root == null) return;
        inorderTraversal(root.left, inorder);
        inorder.add(root.data);
        inorderTraversal(root.right, inorder);
    }
}
