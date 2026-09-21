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
    public boolean isBalanced(TreeNode root) {
        if(isBal(root) != -1) return true;
        return false;
    }

    public int isBal(TreeNode root) {
        if(root == null) return 0;
        int left = isBal(root.left);
        int right = isBal(root.right);
        if(left != -1 && right != -1 && Math.abs(left - right) < 2) return 1 + (Math.max(left, right));
        return -1;
    }
}
