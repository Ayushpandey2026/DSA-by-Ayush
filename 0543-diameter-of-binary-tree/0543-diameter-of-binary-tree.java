
class Solution {
    private  int max =0;
    private int depth(TreeNode root){
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        max = Math.max(max, left + right);
        return 1+ Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
}