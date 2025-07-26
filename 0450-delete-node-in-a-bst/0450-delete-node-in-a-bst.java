class Solution {
    public TreeNode inpred(TreeNode root){
        TreeNode temp =root.left;
        while(temp.right != null) temp = temp.right;
        return temp;
    }
      public TreeNode parent(TreeNode root,TreeNode pred){
        if(root.left == pred || root.right==pred) return root;
        TreeNode temp =root.left;
        while(temp.right != pred) temp = temp.right;
        return temp;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) {
        if(root.left == null && root.right == null) return null;
        
        else if(root.left == null || root.right == null){
            if(root.left == null ) return  root.right;
            else return root.left;
        }
        else{
            TreeNode pred = inpred(root);
            TreeNode predparent  = parent(root,pred);
            if(root == predparent){
                pred.right = root.right;
                return pred;
            }
            predparent.right = pred.left;
            pred.left = root.left; pred.right = root.right;
            return pred;
        }
    }
       else if(root.val > key) root.left = deleteNode(root.left,key);
        else if(root.val < key) root.right = deleteNode(root.right,key);
      return root;
    }
}