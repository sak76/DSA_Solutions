/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size-1; i++) {
                TreeNode curr = queue.poll();
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
            
            TreeNode last = queue.poll();
            ans.add(last.val);
            if(last.left != null) {
                    queue.add(last.left);
            }
            if(last.right != null) {
                    queue.add(last.right);
            }
        }
         return ans;
    }
}