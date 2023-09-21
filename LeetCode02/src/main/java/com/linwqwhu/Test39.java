package com.linwqwhu;

import java.util.*;

/**
 * 39. 组合总和
 */
public class Test39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = candidates.length;

        if (len == 0) {
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        getCombination(candidates, 0, target, path, res);

        return res;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    public void getCombination(int[] candidates, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                return;
            }
            path.addLast(candidates[i]);
            getCombination(candidates, i, target - candidates[i], path, res);
            path.removeLast();//状态重置
        }
    }
}
