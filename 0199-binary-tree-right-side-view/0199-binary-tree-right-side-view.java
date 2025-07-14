class Solution {
    public int levels(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left),levels(root.right));
    }

    public void dfs(TreeNode root , int level, List<Integer> list ){
        if(root == null) return;
        list.set(level, root.val);
        dfs(root.left,level+1,list);
       dfs(root.right,level+1,list);
    }
   

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int leftl = levels(root);
        for(int i =0; i<leftl;i++){
                list.add(0);
        }
        dfs(root, 0 ,list);
         return list;
       
    }
}
