package com.linwqwhu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 46 全排列
 */
public class Test46 {
    public List<List<Integer>> permute1(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<Integer> stack = new ArrayDeque<>();
        dfs1(nums, res, stack);
        return res;
    }

    public void dfs1(int[] nums, List<List<Integer>> res, Deque<Integer> stack) {

        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!stack.contains(nums[i])) {
                stack.addLast(nums[i]);
                dfs1(nums, res, stack);
                stack.removeLast();
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, res, stack, used);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, Deque<Integer> stack, boolean[] used) {

        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                stack.addLast(nums[i]);
                dfs(nums, res, stack, used);
                stack.removeLast();
                used[i] = false;
            }
        }
    }
}
