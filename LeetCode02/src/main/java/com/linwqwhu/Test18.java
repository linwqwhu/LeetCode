package com.linwqwhu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18.四数之和
 */
public class Test18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return res;

        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = len - 1;
                while (k < l) {
                    long num = 0l + nums[i] + nums[j] + nums[k] + nums[l];
                    if (num == (long) target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        res.add(list);
                        while (k < l && nums[k] == nums[k + 1])
                            k++;
                        while (k < l && nums[l] == nums[l - 1])
                            l--;
                        k++;
                        l--;
                    } else if (num < (long) target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return res;
    }


    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return res;

        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            if (0l + nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > (long) target)
                break;
            if (0l + nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < (long) target)
                continue;

            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                if (0l + nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > (long) target)
                    break;
                if (0l + nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < (long) target)
                    continue;

                int k = j + 1;
                int l = len - 1;
                while (k < l) {
                    long num = 0l + nums[i] + nums[j] + nums[k] + nums[l];
                    if (num == (long) target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        res.add(list);
                        while (k < l && nums[k] == nums[k + 1])
                            k++;
                        while (k < l && nums[l] == nums[l - 1])
                            l--;
                        k++;
                        l--;
                    } else if (num < (long) target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return res;
    }
}
