package com.linwqwhu;

import javafx.scene.shape.VLineTo;

/**
 * 106.从中序与后序遍历序列构造二叉树
 */
public class Test106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight)
            return null;
        if (postLeft > postRight)
            return null;
        if (inLeft == inRight) {
            return new TreeNode(inorder[inLeft]);
        }
        int val = postorder[postRight];
        TreeNode root = new TreeNode(val);

        int leftEnd = inLeft;
        int rightEnd = postLeft;
        while (inorder[leftEnd] != val) {
            leftEnd++;
            rightEnd++;
        }

        root.left = build(inorder, inLeft, leftEnd - 1, postorder, postLeft, rightEnd - 1);
        root.right = build(inorder, leftEnd + 1, inRight, postorder, rightEnd, postRight - 1);
        return root;
    }


}
