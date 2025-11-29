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
    static int maxsum;
    public int lineSum(TreeNode root) {
        if(root==null) return 0;
        int leftsum =lineSum(root.left);
         int rightsum =lineSum(root.right);
         int pathsum = root.val;
         if(leftsum>0) pathsum +=leftsum;
          if(rightsum>0) pathsum +=rightsum;
          maxsum = Math.max(pathsum,maxsum);
        return root.val +  Math.max(0,Math.max(leftsum,rightsum));
    }
    public int maxPathSum(TreeNode root) {
        maxsum = Integer.MIN_VALUE;
        lineSum(root);
        return maxsum;
    }
}