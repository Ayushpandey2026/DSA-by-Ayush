class Solution {
    static int sum ;
    public void reverseinorder(TreeNode root){
     if(root == null) return ;
        reverseinorder(root.right);
        root.val += sum;
        sum = root.val;
        reverseinorder(root.left);   
    }
    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
         reverseinorder(root);
         return root;
    }
}