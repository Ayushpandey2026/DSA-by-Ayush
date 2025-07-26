
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(val > root.val && root.right !=null)   insertIntoBST(root.right,val); 
        if(root.val > val && root.left != null) insertIntoBST(root.left,val); 

        if(val < root.val && root.left == null) root.left = new TreeNode(val);  
        if(val > root.val && root.right == null) root.right = new TreeNode(val);
        return root;

    }
}