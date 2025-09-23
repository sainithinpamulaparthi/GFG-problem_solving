class Solution {
    public void reverseQueue(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();
        
        // Move all elements from queue to stack
        while (!q.isEmpty()) {
            st.push(q.poll());
        }
        
        // Move back from stack to queue
        while (!st.isEmpty()) {
            q.add(st.pop());
        }
    }
}
