package cn;

/**
 * 二叉树展开为链表
 */
public class Test114 {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode tempLeft = root.left;//暂时存储当前结点的左子树
                while (tempLeft.right != null) {
                    tempLeft = tempLeft.right;
                }
                tempLeft.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
