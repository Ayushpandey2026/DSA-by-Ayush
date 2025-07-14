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
    static boolean ans;
    public int level(TreeNode root){
        if(root == null) return 0;
         int l = level(root.left);
        int r = level(root.right);
       if(Math.abs(l-r) > 1) ans = false;
        return 1 + Math.max(l,r);
    }
    public boolean isBalanced(TreeNode root) {
        ans = true;
        level(root);
        return ans;

        
    }
}