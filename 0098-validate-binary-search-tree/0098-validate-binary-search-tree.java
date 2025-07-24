class Solution {
    public long  max(TreeNode root){
        if(root == null) return Long.MIN_VALUE;
        
        long b = max(root.left),c = max(root.right),  a = root.val;
        return Math.max(a,Math.max(b,c));
        
    }
     public long  min(TreeNode root){
        if(root == null) return Long.MAX_VALUE;
        
        long a = root.val, b = min(root.left),  c = min(root.right);
        return Math.min(a,Math.min(b,c));
        
    }

    public boolean isValidBST(TreeNode root) {
     if(root == null) return true;
    if(max(root.left) >= root.val )   return false;
    if( min(root.right) <= root.val) return false;

      return  isValidBST(root.left) &&  isValidBST(root.right);
    }
}