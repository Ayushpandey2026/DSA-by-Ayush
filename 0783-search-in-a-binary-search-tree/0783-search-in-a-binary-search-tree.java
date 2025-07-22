
class Solution {
    public TreeNode tree(TreeNode root){
        return root;
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(val > root.val) return searchBST(root.right,val);
        else if(val < root.val) return searchBST(root.left,val);
       else  if(val == root.val) return tree(root);
        return null;
    }
}