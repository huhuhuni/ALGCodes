public class 二插搜索树插入 {
    TreeNode insert(TreeNode root, int x) {
        if (root == null) return new TreeNode(x);
        TreeNode pre = root, p = root;
        while (p != null){
            pre = p;
            if (p.val == x) return root;
            if (p.val > x) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (pre.val > x) pre.left = new TreeNode(x);
        if (pre.val < x) pre.right = new TreeNode(x);
        return root;
    }
}
