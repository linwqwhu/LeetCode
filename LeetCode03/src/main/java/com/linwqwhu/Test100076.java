package com.linwqwhu;

import javafx.beans.binding.When;
import org.junit.Test;

/**
 * 100076.无限数组的最短子数组
 */
public class Test100076 {
    public int minSizeSubarray(int[] nums, int target) {
        int len = nums.length;
        long sum = 0l;
        for (int i = 0; i < len; i++) {
            sum = sum + 0l + nums[i];
        }
        int n = (int) (target / sum) + 2;
        int res = Integer.MAX_VALUE;
        int start = 0, end = 0;
        for (start = 0; end <= len * n; start++) {
            int s = target;
            end = start;
            while (end <= len * n) {
                int num = s - nums[end % len];
                if (num == 0) {
                    end++;
                    res = Math.min(end - start, res);
                    break;
                }
                if (num < 0)
                    break;
                if (num > 0) {
                    end++;
                    s = num;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    @Test
    public void testMinSizeSubarray() {
//        int[] nums = {1,2,3};
//        int[] nums = {1, 1, 1, 2, 3};
        int[] nums = {2, 4, 6, 8};
        int target = 5;
        int res = minSizeSubarray(nums, target);
        System.out.println(res);

    }
}
