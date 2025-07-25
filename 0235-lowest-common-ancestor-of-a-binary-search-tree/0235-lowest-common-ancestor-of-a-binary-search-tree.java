
class Solution {
    public boolean exists(TreeNode root, TreeNode node){
        if(node == root  ) return true;
        if(root == null) return false;
        return exists(root.left, node) || exists(root.right, node);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( p == root || q==root) return root;
        boolean plies = exists(root.left, p);
        boolean qlies = exists(root.left, q);
        if(plies == true &&  qlies == true) return lowestCommonAncestor(root.left,p,q);
    if(plies == false && qlies == false) return lowestCommonAncestor(root.right,p,q);
    else return root;
    }
}