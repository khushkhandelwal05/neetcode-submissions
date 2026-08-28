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
    public int kthSmallest(TreeNode root, int k) {
        int[] arr = new int[1];
        arr[0] = k;
        return kthSmallest(root, arr);
    }

    public int kthSmallest(TreeNode root, int[] dia) {
        if (root == null) return -1;
        int lval = kthSmallest(root.left, dia);
        if (lval != -1) return lval;
        if(dia[0] == 1) return root.val;
        dia[0] = dia[0] - 1; 
        int rval = kthSmallest(root.right, dia);
        if (rval != -1) return rval;
        return -1;
    }
}
