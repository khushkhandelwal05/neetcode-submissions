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
    int val;
    int res = -1;
    public int kthSmallest(TreeNode root, int k) {
        val = k;
        kthSmallest(root);
        return res;
    }

    public void kthSmallest(TreeNode root) {
        if(root == null) return;
        kthSmallest(root.left);
        val--;
        if(res != -1) return;
        if(val == 0){
            res = root.val;
        }
        kthSmallest(root.right);
    }
}
