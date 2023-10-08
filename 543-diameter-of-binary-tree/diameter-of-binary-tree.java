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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = findDiameter(root);
        return ans[1] - 1;
    }

    /**
        return type int[] : where 0 index represent the height of the dependent subtree,
                            and 1 index represent the diameter of the dependent subtree
     */
    private int[] findDiameter(TreeNode root) {
        if(root == null) {
            return new int[]{0,0};
        }

        int[] leftMetadata = findDiameter(root.left);
        int[] rightMetadata = findDiameter(root.right);

        int diameter = Math.max(1 + leftMetadata[0] + rightMetadata[0], Math.max(leftMetadata[1], rightMetadata[1]));

        return new int[]{1 + Math.max(leftMetadata[0], rightMetadata[0]), diameter};
    }
}