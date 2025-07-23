class Solution {
     private  void inorder(TreeNode root,List<Integer> list){
        if(root==null) return ;
         inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        if(list.size()==1 && k==1) return list.get(0);
        if(list.size()==1 && k==0) return 0;


        for(int i=1;i<=list.size();i++){
            if(i==k) return list.get(i-1);
        }
        return 0;
    }
}