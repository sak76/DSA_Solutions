/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new ArrayDeque<>();

        if(root != null) {
            queue.add(root);
        }

        while(!queue.isEmpty()) {
            Node second;
            Node first = queue.poll();
            int size = queue.size();
            if(first.left != null) {
                    queue.add(first.left);
                }

                if(first.right != null) {
                    queue.add(first.right);
                }
            
            for(int i = 0; i < size; i++) {
                second = queue.poll();
                first.next = second;

                if(second.left != null) {
                    queue.add(second.left);
                }

                if(second.right != null) {
                    queue.add(second.right);
                }

                first = second;
            }
        }
        return root;
    }
}