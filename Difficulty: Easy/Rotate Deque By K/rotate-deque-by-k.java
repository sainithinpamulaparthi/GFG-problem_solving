class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        int n = dq.size();
        if (n == 0) return;
        
        k = k % n; // avoid extra rotations
        
        if (type == 1) { // Right rotation
            for (int i = 0; i < k; i++) {
                dq.addFirst(dq.removeLast());
            }
        } else { // type == 2, Left rotation
            for (int i = 0; i < k; i++) {
                dq.addLast(dq.removeFirst());
            }
        }
    }
}
