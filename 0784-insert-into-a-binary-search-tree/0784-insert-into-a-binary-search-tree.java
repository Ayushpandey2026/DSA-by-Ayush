
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
                        TreeNode node = new TreeNode(val);
                        return node;
        }
        if(val > root.val && root.right !=null)   insertIntoBST(root.right,val); 
        if(root.val > val && root.left != null) insertIntoBST(root.left,val); 

        if(val < root.val && root.left == null){
            TreeNode node = new TreeNode(val);
            root.left = node;
        }  
         if(val > root.val && root.right == null){
            TreeNode node = new TreeNode(val);
            root.right = node;
        }  
             return root;

    }
}