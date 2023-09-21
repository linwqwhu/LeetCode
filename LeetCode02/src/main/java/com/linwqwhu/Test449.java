package com.linwqwhu;


import org.junit.Test;

import java.util.Arrays;

/**
 * 449. 序列化和反序列化二叉搜索树
 */
public class Test449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stb = new StringBuilder();
        pre(root, stb);
        return stb.toString();
    }

    /**
     * 先序遍历 ： 根——》左子树——》右子树
     *
     * @param root 根节点
     * @param stb
     */
    public void pre(TreeNode root, StringBuilder stb) {
        if (root != null) {
            stb.append(root.val + "-");
            pre(root.left, stb);
            pre(root.right, stb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data != null && data != "") {
            String[] str = data.split("-");
            TreeNode root = new TreeNode(Integer.parseInt(str[0]));
            TreeNode head = root;
            for (int i = 1; i < str.length; i++) {
                head = root;
                construct(head, Integer.parseInt(str[i]));
            }
            return root;
        }
        return null;
    }

    public void construct(TreeNode root, int num) {
        if (num < root.val) {
            if (root.left != null) {
                construct(root.left, num);
            } else {
                root.left = new TreeNode(num);
            }
        } else {
            if (root.right != null) {
                construct(root.right, num);
            } else {
                root.right = new TreeNode(num);
            }
        }
    }

    @Test
    public void testDeserialize() {
        String s = "23-32-43-";
        String[] strs = s.split("-");
        System.out.println(Arrays.stream(strs).toArray());
    }
}
