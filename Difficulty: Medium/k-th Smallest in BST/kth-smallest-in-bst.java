class Solution {
    int count = 0;
    int ans = -1;

    public int kthSmallest(Node root, int k) {
        inorder(root, k);
        return ans;
    }

    void inorder(Node root, int k) {
        if (root == null || ans != -1) return;

        inorder(root.left, k);
        count++;
        if (count == k) {
            ans = root.data;
            return;
        }
        inorder(root.right, k);
    }
}
