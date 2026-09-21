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
    public int goodNodes(TreeNode root) {
        int curMax = Integer.MIN_VALUE;
        return goodNodes(root, curMax);
    }

    public int goodNodes(TreeNode root, int curMax) {
        if(root == null) return 0;
        if(root.val >= curMax) {
            return 1 + goodNodes(root.left, root.val) + goodNodes(root.right, root.val);
        } else {
            return goodNodes(root.left, curMax) + goodNodes(root.right, curMax);
        }
    }
}
