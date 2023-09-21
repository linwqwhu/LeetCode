package com.linwqwhu;

import java.util.Arrays;
import java.util.Map;

/**
 * 2560.打家劫舍IV
 */
public class Test2560 {
    public int minCapability(int[] nums, int k) {
        int lower = Arrays.stream(nums).min().getAsInt();
        int upper = Arrays.stream(nums).max().getAsInt();

        while (lower <= upper) {
            int middle = lower + (upper - lower) / 2;
            int count = 0;
            boolean visited = false;
            for (int num : nums) {
                if (num <= middle && !visited) {
                    count++;
                    visited = true;
                } else {
                    visited = false;
                }
            }
            if (count >= k)
                upper = middle - 1;
            else
                lower = middle + 1;
        }
        return lower;
    }

    public int minCapability2(int[] nums, int k) {
        int left = 0;
        int right = Arrays.stream(nums).max().getAsInt();
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(nums, k, mid)) {
                right = mid;
            } else
                left = mid;
        }
        return right;
    }

    private boolean check(int[] nums, int k, int mx) {
        int f0 = 0, f1 = 0;
        for (int x : nums) {
            if (x > mx) {
                f0 = f1;
            } else {
                int tmp = f1;
                f1 = Math.max(f1, f0 + 1);
                f0 = tmp;
            }
        }
        return f1 >= k;
    }
}
