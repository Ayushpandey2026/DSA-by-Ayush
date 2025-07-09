class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();  // number of nodes in current level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                level.add(node.val);

                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }

            ans.add(level);  // add the current level to answer
        }

        return ans;
    }
}
