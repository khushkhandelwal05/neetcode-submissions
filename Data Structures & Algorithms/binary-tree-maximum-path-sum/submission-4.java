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
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        int val = maxPathSum(root, res);
        return res[0];
    }

    public int maxPathSum(TreeNode root, int[] maxi) {
        if (root == null) return 0;

        int maxL = Math.max(0,maxPathSum(root.left, maxi));
        int maxR = Math.max(0,maxPathSum(root.right, maxi));

        maxi[0] = Math.max(maxi[0], maxL+maxR+root.val);

        return root.val + Math.max(maxL, maxR);

    }
}
