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

    public void dfs(TreeNode root, ArrayList<Integer> tree) {
        if(root == null) {
            tree.add(100001);
            return;
        }
        tree.add(root.val);
        dfs(root.left, tree);
        dfs(root.right, tree);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        ArrayList<Integer> tree = new ArrayList<>();
        ArrayList<Integer> subtree = new ArrayList<>();
        dfs(root, tree);
        dfs(subRoot, subtree);
        return Collections.indexOfSubList(tree, subtree) != -1; 
    }
}
