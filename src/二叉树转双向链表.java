public class 二叉树转双向链表 {
    static void convert(TreeNode root){
        if (root == null) return;
        TreeNode pre = root.left;
        TreeNode next = root.right;
        if (pre != null)
            while (pre.right != null){
             pre = pre.right;
             }
        if (next != null)
            while (next.left != null){
                next = next.left;
            }
        convert(root.left);
        convert(root.left);
        root.left = pre;
        root.right = next;
        if (pre != null)
            pre.right = root;
        if (next != null)
            next.left = root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.right = new TreeNode(9);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(2);
        convert(root);
        System.out.println(root.right.right.val);
    }
}
