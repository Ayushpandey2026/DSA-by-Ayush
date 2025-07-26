class Solution {
    public void preorder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode curr = list.get(i);
            TreeNode next = list.get(i + 1);
            curr.left = null;
            curr.right = next;
        }
    }
}
