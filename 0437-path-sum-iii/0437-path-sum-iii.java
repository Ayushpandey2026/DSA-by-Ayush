
class Solution {
    public int helper(TreeNode root, long sum){
        if(root == null) return 0;
        int cnt = 0;
        if(root.val == sum) cnt++;
        cnt += helper(root.left,sum - root.val) +  helper(root.right,sum - root.val) ;
        return cnt;
    }
    public int pathSum(TreeNode root, int sum) {
                if(root == null) return 0;
           return  helper(root,sum) + pathSum( root.left,sum) + pathSum( root.right,sum); 
    }
}