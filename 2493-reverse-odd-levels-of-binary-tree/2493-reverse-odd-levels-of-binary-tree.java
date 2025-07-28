 class Solution {
     private  void  level(TreeNode left, TreeNode right, int lvl){
        if(left==null || right==null) return;
         if (lvl % 2==1){
                int temp = left.val;
                left.val = right.val;
                right.val = temp;
         } 

          level(left.left,right.right,lvl+1);
            level(left.right,right.left,lvl+1);

     }
    public TreeNode reverseOddLevels(TreeNode root) {
                if (root == null) return null;
         level(root.left,root.right,1 );
         return root;
    }
}