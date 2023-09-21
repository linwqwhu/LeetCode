package com.linwqwhu;

import java.beans.beancontext.BeanContext;
import java.util.*;

/**
 * 40.组合总和II
 */
public class Test40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0)
            return res;
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(candidates, target, 0, res, stack);
        return res;
    }

    public void dfs(int[] candidates, int target, int index, List<List<Integer>> res, Deque<Integer> stack) {
        if (target == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0)
                break;
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            stack.addLast(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, res, stack);
            stack.removeLast();
        }
    }
}
