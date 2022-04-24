package leetcode.tree;

public class MaxTreeDepth {
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int lDepth = maxDepth(root.left);
            int rDepth = maxDepth(root.right);

            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
    }
}
