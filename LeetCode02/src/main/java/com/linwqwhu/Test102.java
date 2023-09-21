package com.linwqwhu;

import java.util.*;

/**
 * 102.二叉树的层序遍历
 */
public class Test102 {
    public List<List<Integer>> levelOrder1(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<TreeNode> deque1 = new LinkedList<>();
        Deque<TreeNode> deque2 = new LinkedList<>();
        if (root == null)
            return res;

        deque1.offer(root);
        while (!deque1.isEmpty() || !deque2.isEmpty()) {
            List<Integer> list1 = new ArrayList<>();
            while (!deque1.isEmpty()) {
                TreeNode node = deque1.poll();
                list1.add(node.val);
                if (node.left != null) {
                    deque2.offer(node.left);
                }
                if (node.right != null) {
                    deque2.offer(node.right);
                }
            }
            if (list1.size() > 0)
                res.add(list1);

            List<Integer> list2 = new ArrayList<>();
            while (!deque2.isEmpty()) {
                TreeNode node = deque2.poll();
                list2.add(node.val);
                if (node.left != null) {
                    deque1.offer(node.left);
                }
                if (node.right != null) {
                    deque1.offer(node.right);
                }
            }
            if (list2.size() > 0)
                res.add(list2);
        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<TreeNode> deque = new LinkedList<>();

        if (root != null)
            deque.offer(root);

        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }

}
