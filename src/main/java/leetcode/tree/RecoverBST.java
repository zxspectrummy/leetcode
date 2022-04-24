package leetcode.tree;


public class RecoverBST {
    TreeNode first, middle, last, prev;

    public boolean recoverTree(TreeNode root) {
        first = middle = last = prev = null;
        findSwappedNodes(root);
        if (first != null && last != null) {
            swapNodeValues(first, last);
            return true;
        } else if (first != null && middle != null) {
            swapNodeValues(first, middle);
            return true;
        }
        return false;
    }

    public void findSwappedNodes(TreeNode root) {
        if (root != null) {
            findSwappedNodes(root.left);
            if (prev != null && root.val < prev.val) {
                if (first == null) {
                    first = prev;
                    middle = root;
                } else
                    last = root;
            }
            prev = root;
            findSwappedNodes(root.right);
        }
    }

    public void swapNodeValues(TreeNode firstNode, TreeNode secondNode) {
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }
}
