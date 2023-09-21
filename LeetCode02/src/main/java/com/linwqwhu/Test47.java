package com.linwqwhu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47.全排列II
 */
public class Test47 {
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<>();

        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, res, 0, perm);
        return res;

    }

    private void backTrack(int[] nums, List<List<Integer>> res, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            res.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backTrack(nums, res, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}
