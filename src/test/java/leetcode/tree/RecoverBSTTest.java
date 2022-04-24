package leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecoverBSTTest {
    @Test
    public void recoverBSTTest1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        RecoverBST recoverBST = new RecoverBST();
        assertTrue(recoverBST.recoverTree(root));
        assertFalse(recoverBST.recoverTree(root));
    }

    @Test
    public void recoverBSTTest2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        RecoverBST recoverBST = new RecoverBST();
        assertTrue(recoverBST.recoverTree(root));
        assertFalse(recoverBST.recoverTree(root));
    }
}
