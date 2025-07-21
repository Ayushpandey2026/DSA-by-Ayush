
class Solution {
    int preindex = 0;
    Map<Integer,Integer> map = new HashMap<>();
    private TreeNode build(int[] preorder, int left, int right){
        if(left > right) return null;
        int rootval = preorder[preindex++];
        TreeNode root = new TreeNode(rootval);
        int index = map.get(rootval);
        root.left = build(preorder,left,index-1);
        root.right = build(preorder,index+1,right);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i< preorder.length;i++){
             map.put(inorder[i], i );

        }
        return build(preorder,0,preorder.length-1);
    }
}